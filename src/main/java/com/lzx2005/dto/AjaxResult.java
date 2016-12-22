package com.lzx2005.dto;

/**
 * Created by LiZhengxian on 2016/12/22 0022.
 */
public class AjaxResult<T> {
    private boolean success;
    private String msg;
    private T data;

    public AjaxResult(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
