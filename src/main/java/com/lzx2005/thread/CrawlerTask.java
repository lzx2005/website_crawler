package com.lzx2005.thread;

import com.lzx2005.entity.ThreadMark;
import com.lzx2005.repository.ThreadMarkRepository;
import com.lzx2005.service.CrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * 一个新的爬虫任务
 * Created by Li Zhengxian on 2016/11/24 0024.
 */
@Component("crawlerTask")
@Scope("prototype")
public class CrawlerTask  extends Thread{
    private final static Logger logger= LoggerFactory.getLogger(CrawlerTask.class);

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private ThreadMarkRepository threadMarkRepository;

    public long getDeep(){
        return crawlerService.getOutDeep();
    }

    @Override
    public void run() {
        try {
            URL url1 = new URL(url);
            ThreadMark threadMark = threadMarkRepository.findByHost(url1.getHost());
            if(threadMark==null){
                threadMark = new ThreadMark();
            }
            threadMark.setStatus((short) 0);
            threadMark.setHost(url1.getHost());
            Date date = new Date();
            threadMark.setCreateTime(date);
            threadMark.setStartTime(date);
            threadMark.setDoneTime(date);
            threadMark.setThreadId(Thread.currentThread().getId()+"");
            threadMark.setThreadName(Thread.currentThread().getName());
            ThreadMark saved = threadMarkRepository.save(threadMark);
            int id = saved.getMarkId();
            if(id>0){
                //标记开始
                saved.setStatus((short) 1);
                threadMarkRepository.save(saved);
                crawlerService.setThreadMark(saved);
                crawlerService.setId(saved.getMarkId());
                //保存成功，开始爬虫
                crawlerService.mainCrawler(url1,0);
                //爬虫结束，标记成功
                saved.setStatus((short) 2);
                saved.setDoneTime(new Date());
                threadMarkRepository.save(saved);
            }else{
                //保存失败，标记失败
                saved.setStatus((short) 3);
                threadMarkRepository.save(saved);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("输入的不是合法url，合法的URL类似:\"http://www.baidu.com\"");
            logger.error("输入的不是合法url",e);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("未知错误，请看日志");
            logger.error("未知错误，请看日志",e);
        }
    }
}
