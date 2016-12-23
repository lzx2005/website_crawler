package com.lzx2005.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 线程记录类
 * Created by Li Zhengxian on 2016/12/9 0009.
 */
@Entity
public class ThreadMark {

    @Id
    @GeneratedValue
    private int markId;
    @Column(nullable = false)
    private String host;
    @Column(nullable = false)
    private String threadName;
    @Column(nullable = false)
    private String threadId;
    @Column(nullable = false)
    private short status;
    private Date createTime;
    private Date startTime;
    private Date DoneTime;

    public ThreadMark() {
    }

    public ThreadMark(String host, String threadName, String threadId, short status, Date createTime, Date startTime, Date doneTime) {
        this.host = host;
        this.threadName = threadName;
        this.threadId = threadId;
        this.status = status;
        this.createTime = createTime;
        this.startTime = startTime;
        DoneTime = doneTime;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getDoneTime() {
        return DoneTime;
    }

    public void setDoneTime(Date doneTime) {
        DoneTime = doneTime;
    }

    @Override
    public String toString() {
        return "ThreadMark{" +
                "markId=" + markId +
                ", host='" + host + '\'' +
                ", threadName='" + threadName + '\'' +
                ", threadId='" + threadId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", DoneTime=" + DoneTime +
                '}';
    }
}
