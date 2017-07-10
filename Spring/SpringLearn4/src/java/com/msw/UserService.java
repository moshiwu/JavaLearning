package com.msw;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/7.
 */
public interface UserService {

    void setRequest(HttpServletRequest request);
    void setResponse(HttpServletResponse response);
    void register() throws IOException;
    void login() throws IOException;
}
