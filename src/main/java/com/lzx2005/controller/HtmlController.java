package com.lzx2005.controller;

import com.lzx2005.service.CrawlerService;
import com.lzx2005.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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

    @RequestMapping("/")
    public String index(Map<String, Object> model){
        return "index";
    }


    @RequestMapping("/crawler")
    public String crawler(Map<String, Object> model){
        return "crawler";
    }
}
