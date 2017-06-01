package com.safefire.acsiserver.webapp.controller.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Leo on 2017/5/18.
 */
public class ReqUserLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 20, message = "{ReqLogin.loginName.Size}")
    @NotNull(message = "{ReqLogin.loginName.NotNull}")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,20}$", message = "{ReqLogin.loginName.Pattern}")
    private String loginName;

    @NotNull(message = "{ReqLogin.password.NotNull}")
    private String password;

    public ReqUserLogin() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
