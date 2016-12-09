package com.lzx2005.repository;

import com.lzx2005.Application;
import com.lzx2005.entity.ThreadMark;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Li Zhengxian on 2016/12/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class ThreadMarkRepositoryTest {

    @Autowired
    private ThreadMarkRepository threadMarkRepository;

    public ThreadMarkRepositoryTest() {
    }


    @Test
    public void test(){
        Date date = new Date();
        ThreadMark threadMark = new ThreadMark("www.baidu.com","threadName","threadId",(short)1,date,date,date);
        threadMarkRepository.save(threadMark);
    }

    @Test
    public void delete(){
        threadMarkRepository.delete(1);
    }
}