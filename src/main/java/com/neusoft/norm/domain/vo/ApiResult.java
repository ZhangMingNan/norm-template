package com.neusoft.norm.domain.vo;



/**
 * 作者: 张明楠 创建于 16/12/9.
 */
public class ApiResult<T> {

    private String code;

    private T data;

    private boolean successResponse = true;

    private String message;

    public static ApiResult success(String message){
        ApiResult apiResult = new ApiResult();
        apiResult.setMessage(message);
        return apiResult;
    }
    public static ApiResult error(String message){
        ApiResult apiResult = new ApiResult();
        apiResult.setMessage(message);
        apiResult.setSuccessResponse(false);
        return apiResult;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public boolean isSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(boolean successResponse) {
        this.successResponse = successResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
