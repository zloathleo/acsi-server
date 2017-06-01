package com.safefire.acsiserver.webapp.controller.user;

import com.safefire.acsiserver.webapp.vo.base.BasicRes;

/**
 * Created by Leo on 2017/5/18.
 */
public class ResUserLogin extends BasicRes {

    private String accessToken;
    private String expiresIn;
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "ResUserLogin{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                "} " + super.toString();
    }
}
