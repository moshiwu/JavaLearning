package com.msw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/7.
 */
public class BaseService implements UserService {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void register() throws IOException {

    }

    public void login() throws IOException {

    }
}
