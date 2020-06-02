package org.cloud.face.enums;

public enum ResponseCodeEnum {

    SUCCESS("响应成功",200),
    BAD_REQUEST("错误请求",400),
    UNAUTHORIZED("需要身份验证",401),
    FORBIDDEN("禁止访问",401),
    NOT_fOUND("未找到)",404),
    ERROR("内部服务器错误",500),
    GATEWAY_TIMEOUT("网关超时",504);

    private String message;

    private int code;

    ResponseCodeEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
