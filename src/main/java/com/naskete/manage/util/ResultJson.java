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
}
