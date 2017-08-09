package com.hc.admc.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alex on 2017/8/9.
 */
@Root
public class LoginResult {
    @Element
    private String UserLoginResult;


    public LoginResult() {

    }


    public LoginResult(String userLoginResult) {
        UserLoginResult = userLoginResult;
    }

    public String getUserLoginResult() {
        return UserLoginResult;
    }

    public void setUserLoginResult(String userLoginResult) {
        UserLoginResult = userLoginResult;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "UserLoginResult='" + UserLoginResult + '\'' +
                '}';
    }
}
