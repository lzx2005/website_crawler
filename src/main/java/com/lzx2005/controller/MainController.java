package com.lzx2005.controller;

import com.lzx2005.content.ApplicationContextProvider;
import com.lzx2005.entity.Website;
import com.lzx2005.exception.UrlRepeatException;
import com.lzx2005.service.CrawlerService;
import com.lzx2005.service.WebsiteService;
import com.lzx2005.service.impl.CrawlerServiceImpl;
import com.lzx2005.thread.CrawlerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private CrawlerService crawlerService;



    @RequestMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String welcome(@RequestParam(value = "id",required = false,defaultValue = "1000") Long websiteId){
        Website website = websiteService.findWebsite(websiteId);
        return "hello world:"+website.getTitle();
    }

    @RequestMapping("/find")
    @ResponseBody
    public String findByUrl(@RequestParam(value = "url",required = false,defaultValue = "www.baidu.com") String url){
        List<Website> website = websiteService.findUrl(url);
        if(null!=website&&website.size()>0){
            return website.get(0).toString();
        }else{
            return "没有找到website";
        }
    }

    @RequestMapping("/read")
    @ResponseBody
    public String read(@RequestParam(value = "url",required = false,defaultValue = "www.baidu.com") String url){

        CrawlerTask crawlerTask = ApplicationContextProvider.getBean("crawlerTask", CrawlerTask.class);
        crawlerTask.setName(url);
        crawlerTask.setUrl(url);
        crawlerTask.start();
        System.out.println("线程启动");
        return "crawler thread is started!";
    }
}
