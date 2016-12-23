package com.lzx2005.service.impl;

import com.lzx2005.entity.ThreadMark;
import com.lzx2005.entity.Website;
import com.lzx2005.exception.UrlRepeatException;
import com.lzx2005.repository.WebsiteRepository;
import com.lzx2005.service.CrawlerService;
import com.lzx2005.service.ElasticsearchService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Li Zhengxian on 2016/11/21 0021.
 */

@Component("CrawlerService")
public class CrawlerServiceImpl implements CrawlerService {
    final static Logger logger= LoggerFactory.getLogger(CrawlerServiceImpl.class);
    private int id;
    private ThreadMark threadMark;
    long outDeep=0;
    @Autowired
    private ElasticsearchService elasticsearchService;

    private final WebsiteRepository websiteRepository;

    public CrawlerServiceImpl(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getOutDeep() {
        return outDeep;
    }

    public void setOutDeep(long outDeep) {
        this.outDeep = outDeep;
    }

    @Override
    public ThreadMark getThreadMark() {
        return threadMark;
    }

    @Override
    public void setThreadMark(ThreadMark threadMark) {
        this.threadMark = threadMark;
    }

    public void mainCrawler(URL url, long deep){
        System.out.println("===============================================");
        logger.info("开始爬取"+url.toString()+"的内容，当前递归深度："+deep);
        try {
            Website website = readUrl(url);
            String body = website.getBody();
            if(null!=website){
                website.setBody("");
                logger.info("将爬虫爬到的网站["+website.getUrl()+"]写入MySQL");
                websiteRepository.save(website);
                //elasticsearchService.insertOneRecord(website);
                //  TODO: 2016/11/25 0025  这边的Elasticsearch还是有点问题
            }

            //开始解析当前页面里有的HTML
            Document parse = Jsoup.parse(body);
            Elements as = parse.getElementsByTag("a");
            System.out.println(as.size());
            deep++;
            this.outDeep=deep;
            for(int i=0;i<as.size();i++){
                Element a = as.get(i);
                boolean hasHref = a.hasAttr("href");
                if(hasHref){
                    String href = a.attr("href");
                    System.out.println("找到一个地址："+href);
                    URL newUrl = null;
                    if(href.startsWith("http")){
                        //这是一个完整的http地址
                        newUrl = new URL(href);
                        if(!newUrl.getHost().equalsIgnoreCase(url.getHost())){
                            //这边跳转出去了，所以不爬了
                            continue;
                        }
                    }else if(href.startsWith("/")&&!href.equalsIgnoreCase("/")){
                        //这是一个相对地址
                        newUrl = new URL("http://"+url.getHost()+href);
                    }
                    if(null!=newUrl){
                        //开始递归下一个url，反复查找
                        mainCrawler(newUrl,deep);
                    }
                }
            }
        } catch (MalformedURLException e){
            logger.error("无法渲染Url,这个地址是错误的：",e.getMessage());
            return;
        } catch (IOException e) {
            logger.error("出现了IO错误：",e.getMessage());
            return;
        } catch (UrlRepeatException e) {
            System.err.println("要爬取的地址重复了："+e.getMessage());
            return;
        } catch (IllegalArgumentException e){
            logger.error("IllegalArgumentException错误",e.getMessage());
            return;
        } catch (Exception e){
            logger.error("未知错误，看日志：",e.getMessage());
            return;
        } finally {
            deep--;
            this.outDeep=deep;
            System.out.println("退出递归深度:"+deep);
        }
    }

    @Override
    public Website readUrl(URL url) throws IOException, UrlRepeatException,IllegalArgumentException,Exception {
        List<Website> byUrl = websiteRepository.findByUrl(url.toString());

        if(null!=byUrl&&byUrl.size()>0){
            throw new UrlRepeatException("url is already exist in mysql");
        }

        // HTTP请求，获得HTML
        HttpClient httpClient = new HttpClient();
        GetMethod method = new GetMethod(url.toString());
        httpClient.executeMethod(method);
        byte[] responseBodyAsString = method.getResponseBody();
        String html = new String(responseBodyAsString, "UTF-8");
        method.releaseConnection();

        //解析HTML
        Document parse = Jsoup.parse(html);
        String content = parse.text();
        String title = parse.title();
        Element head = parse.head();
        Element body = parse.body();
        Website website = new Website(url.getHost(),url.toString(), title, head.toString(), body.toString(),content);
        return website;
    }

    /*public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.lzx2005.com:80/");
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
    }*/
}
