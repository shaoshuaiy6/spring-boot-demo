package com.shaoshuai.myblog.entity;

import java.io.Serializable;

/**
 * @ClassName Tuser
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/312:04
 * @Version 1.0
 **/
public class Tuser implements Serializable {

    private static final long serialVersionUID = 1968845816565626330L;

    private Integer userId;

    private String userName;

    private String password;

    @Override
    public String toString() {
        return "Tuser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
