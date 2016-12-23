package com.lzx2005.thread.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一个新的爬虫任务
 * Created by Li Zhengxian on 2016/11/24 0024.
 */
public class TestTask extends Thread{
    private final static Logger logger= LoggerFactory.getLogger(TestTask.class);
    @Override
    public void run() {
        while (true){
            for(int i=0;i<100000;i++){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
