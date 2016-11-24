package com.lzx2005.exception;

/**
 * 异常
 * Created by Li Zhengxian on 2016/11/21 0021.
 */
public class UrlRepeatException extends Exception {
    public UrlRepeatException() {
        super();
    }

    public UrlRepeatException(String message) {
        super(message);
    }
}
