package com.lzx2005.repository;

import com.lzx2005.Application;
import com.lzx2005.dto.Count;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.math.BigInteger;
import java.util.List;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class WebsiteRepositoryTest {

    @Autowired
    private WebsiteRepository websiteRepository;

    @Test
    public void test(){
        List<Object[]> count = websiteRepository.getCount();
        for(Object[]  os: count){
            String s = (String)os[0];
            BigInteger o = (BigInteger) os[1];
            System.out.println(s+o);
        }
    }
}