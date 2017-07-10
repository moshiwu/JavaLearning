package com.msw;

import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/7.
 */
public class StudentService extends BaseService {

    @Override
    public void register() throws IOException {
        this.response.getWriter().write("学生注册成功<br/>");
    }

    @Override
    public void login() throws IOException {
        this.response.getWriter().write("学生登录成功<br/>");
    }
}
