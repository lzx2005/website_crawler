package com.lzx2005;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Lizhengxian 2016.11.9
 */

@SpringBootApplication
@Configuration
@ImportResource(locations={"classpath:config/application-bean.xml"})
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}