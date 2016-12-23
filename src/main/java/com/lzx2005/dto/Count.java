package com.lzx2005.dto;

import java.math.BigInteger;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class Count {
    private String host;
    private int count;

    public Count(String s, BigInteger o) {
        this.host = s;
        this.count = o.intValue();
    }

    public Count(String host, int count) {
        this.host = host;
        this.count = count;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Count{" +
                "host='" + host + '\'' +
                ", count=" + count +
                '}';
    }
}
