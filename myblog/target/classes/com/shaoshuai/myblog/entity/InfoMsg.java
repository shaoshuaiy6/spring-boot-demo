package com.shaoshuai.myblog.entity;

/**
 * @ClassName InfoMsg
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/915:58
 * @Version 1.0
 **/
public class InfoMsg {

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InfoMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
