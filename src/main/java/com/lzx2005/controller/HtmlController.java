package com.lzx2005.controller;

import com.lzx2005.entity.ThreadMark;
import com.lzx2005.repository.ThreadMarkRepository;
import com.lzx2005.service.CrawlerService;
import com.lzx2005.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Li Zhengxian on 2016/12/17 0017.
 */
@Controller
public class HtmlController {
    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private ThreadMarkRepository threadMarkRepository;

    @RequestMapping("/")
    public String index(Map<String, Object> model){
        return "index";
    }


    @RequestMapping("/crawler")
    public String crawler(Map<String, Object> model){
        return "crawler";
    }

    @RequestMapping("/job")
    public String job(Map<String, Object> model){
        List<ThreadMark> byStatus = threadMarkRepository.findByStatus((short) 1);
        model.put("jobs",byStatus);
        return "job";
    }
}
