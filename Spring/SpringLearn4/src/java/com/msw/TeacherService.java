package com.msw;

import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/7.
 */
public class TeacherService extends BaseService {

    public void register() throws IOException {
        this.response.getWriter().write("老师注册成功<br/>");
    }

    public void login() throws IOException {
        this.response.getWriter().write("老师登录成功<br/>");
    }
}
