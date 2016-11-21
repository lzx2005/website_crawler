package com.lzx2005.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by LiZhengxian on 2016/11/18 0018.
 */

@Entity
public class Website {

    @Id
    @GeneratedValue
    private long websiteId;
    @Column(nullable = false)
    private String host;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String head;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String content;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Website() {
    }

    public Website(String host, String url, String title, String head, String body, String content) {
        this.host = host;
        this.url = url;
        this.title = title;
        this.head = head;
        this.body = body;
        this.content = content;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(long websiteId) {
        this.websiteId = websiteId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Website{" +
                "websiteId=" + websiteId +
                ", host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
