package com.lzx2005.repository;

import com.lzx2005.Application;
import com.lzx2005.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by LiZhengxian on 2016/12/23 0023.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        User user = new User();
        user.setUsername("lzx2005");
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setUserType((short) 0);
        User save = userRepository.save(user);
        System.out.println(save);
    }
}