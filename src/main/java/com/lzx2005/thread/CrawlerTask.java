package com.lzx2005.thread;

import com.lzx2005.service.CrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Li Zhengxian on 2016/11/24 0024.
 */
@Component("crawlerTask")
@Scope("prototype")
public class CrawlerTask  extends Thread{
    final static Logger logger= LoggerFactory.getLogger(CrawlerTask.class);

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Autowired
    private CrawlerService crawlerService;

    @Override
    public void run() {
        try {
            URL url1 = new URL(url);
            crawlerService.mainCrawler(url1,0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("输入的不是合法url，合法的URL类似:\"http://www.baidu.com\"");
            logger.error("输入的不是合法url",e);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("未知错误，请看日志");
            logger.error("未知错误，请看日志",e);
        }
    }
}
