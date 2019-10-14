package com.shaoshuai.myblog.entity;

import java.io.Serializable;

/**
 * @ClassName HttpResponseBean
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/421:47
 * @Version 1.0
 **/
public class HttpResponseBean implements Serializable {

    private String httpStatus;
    private String message;

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
