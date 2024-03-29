package com.shaoshuai.myblog.entity;

/**
 * @ClassName ErrorInfo
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/714:23
 * @Version 1.0
 **/
public class ErrorInfo {
    // 错误类别码
    public Integer code;
    // 错误信息
    public String message;
    // 映射路径
    public String url;

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
