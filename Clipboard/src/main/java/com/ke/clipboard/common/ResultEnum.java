package com.ke.clipboard.common;

public enum ResultEnum {
    SUCCESS(200,"success"),

    ERROR(500,"error"),;

    private final Integer code;
    private final String msg;
    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
