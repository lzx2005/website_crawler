package com.lzx2005.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzx2005.entity.Website;
import com.lzx2005.service.ElasticsearchService;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class ElasticsearchServiceImpl implements ElasticsearchService {


    @Override
    public void insertOneRecord(Website website) {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "my-application").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("112.74.33.145"), 9300));

            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elasticsearch")
                            .endObject()
                    )
                    .get();

            System.out.println(response.getIndex());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public static void main(String[] args) {
        Website website = new Website();
        new ElasticsearchServiceImpl().insertOneRecord(website);
    }
}
