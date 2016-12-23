package com.lzx2005.service;

import com.lzx2005.entity.ThreadMark;
import com.lzx2005.entity.Website;
import com.lzx2005.exception.UrlRepeatException;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Li Zhengxian on 2016/11/21 0021.
 */
public interface CrawlerService {
    public void mainCrawler(URL url,long deep);
    public Website readUrl(URL url) throws IOException, UrlRepeatException,IllegalArgumentException, Exception;
    public void setId(int id);
    public int getId();
    public ThreadMark getThreadMark();
    public void setThreadMark(ThreadMark threadMark);


    public long getOutDeep();
    public void setOutDeep(long outDeep);
}
