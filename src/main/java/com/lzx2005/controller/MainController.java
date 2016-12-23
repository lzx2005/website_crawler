package com.lzx2005.controller;

import com.lzx2005.content.ApplicationContextProvider;
import com.lzx2005.dto.AjaxResult;
import com.lzx2005.entity.ThreadMark;
import com.lzx2005.entity.Website;
import com.lzx2005.exception.UrlRepeatException;
import com.lzx2005.repository.ThreadMarkRepository;
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


    @Autowired
    private ThreadMarkRepository threadMarkRepository;

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
    public AjaxResult<String> read(@RequestParam(value = "url",required = false,defaultValue = "www.baidu.com") String url){
        List<ThreadMark> byStatus = threadMarkRepository.findByStatus((short) 1);
        if(byStatus.size()>=10){
            return new AjaxResult<String>(false,"正在进行10个爬虫任务，请等待他们完成",null);
        }
        URL url1;
        try {
            url1 = new URL(url);
        } catch (MalformedURLException e) {
            return new AjaxResult<String>(false,"网址格式不正确",null);
        }
        ThreadMark byHost = threadMarkRepository.findByHost(url1.getHost());
        if(byHost!=null&&byHost.getStatus()==1){
            //正在爬取
            return new AjaxResult<String>(false,"网站正在被爬取，请耐心等待",null);
        }
        CrawlerTask crawlerTask = ApplicationContextProvider.getBean("crawlerTask", CrawlerTask.class);
        crawlerTask.setUrl(url);
        crawlerTask.start();
        System.out.println("线程启动");
        return new AjaxResult<String>(true,"爬虫任务已经开始",null);
    }
}
