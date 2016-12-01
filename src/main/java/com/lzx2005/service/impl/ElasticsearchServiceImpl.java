package com.lzx2005.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzx2005.entity.Website;
import com.lzx2005.service.ElasticsearchService;
import com.lzx2005.thread.CrawlerTask;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

/**
 * 连接Elasticsearch的类
 */
@Component("elasticsearchServiceImpl")
public class ElasticsearchServiceImpl implements ElasticsearchService {
    final static Logger logger= LoggerFactory.getLogger(ElasticsearchServiceImpl.class);

    private Settings settings;
    private TransportClient client;

    public ElasticsearchServiceImpl() {

        settings = Settings.settingsBuilder()
                .put("cluster.name", "my-application").build();
        try {
            client = TransportClient.builder()
                    .settings(settings)
                    .build();

            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.18.8.205"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOneRecord(Website website) {

        try {
            XContentBuilder xContentBuilder = jsonBuilder();
            xContentBuilder.startObject();
            xContentBuilder.field("website_id",website.getWebsiteId());
            xContentBuilder.field("host",website.getHost());
            xContentBuilder.field("url",website.getUrl());
            xContentBuilder.field("title",website.getTitle());
            xContentBuilder.field("head",website.getHead());
            xContentBuilder.field("content",website.getContent());
            xContentBuilder.field("create_time",website.getCreateTime());
            xContentBuilder.endObject();
            IndexResponse response = client.prepareIndex("website", "website")
                    .setSource(xContentBuilder)
                    .get();
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    /*public static void main(String[] args) {
        Website website = new Website("host","url","title","head","body","conetnt");

        new ElasticsearchServiceImpl().insertOneRecord(website);
    }*/
}
