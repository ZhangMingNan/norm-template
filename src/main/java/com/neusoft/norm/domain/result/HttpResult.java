package com.neusoft.norm.domain.result;


public class HttpResult<T> {
    public static final String SUCCESS_MSG = "OK";
    public static final int SUCCESS_STATUS = 0;
    // 接口数据
    private T data;
    // 接口返回状态 0-操作成功
    private int status;
    // 错误信息，状态为0是返回空串
    private String msg;

    public static HttpResult success() {
        return HttpResult.success(null);
    }

    public static <T> HttpResult success(T data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        result.setStatus(SUCCESS_STATUS);
        result.setMsg(SUCCESS_MSG);
        return result;
    }

    public static HttpResult fail(int status, String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult fail(String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(-1);
        result.setMsg(msg);
        return result;
    }

    public static String getSuccessMsg() {
        return SUCCESS_MSG;
    }

    public static int getSuccessStatus() {
        return SUCCESS_STATUS;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
