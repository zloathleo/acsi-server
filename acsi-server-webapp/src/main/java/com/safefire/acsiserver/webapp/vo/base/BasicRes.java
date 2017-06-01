package com.safefire.acsiserver.webapp.vo.base;

import java.io.Serializable;

/**
 * Created by Leo on 2017/5/18.
 */
public class BasicRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    public BasicRes() {
        this.code = "000000";
        this.msg = "成功";
    }

    public BasicRes(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
        return "BasicRes{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
