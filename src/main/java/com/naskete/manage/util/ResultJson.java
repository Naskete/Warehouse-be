package com.naskete.manage.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultJson {
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public ResultJson(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultJson(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
