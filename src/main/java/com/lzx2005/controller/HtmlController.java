package com.lzx2005.controller;

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

    @RequestMapping("/html")
    public String index(Map<String, Object> model){
        System.out.println("hello world");
        model.put("time", new Date());
        model.put("message", this.message);
        return "index";
    }
}
