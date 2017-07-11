package com.msw;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/10.
 */
public class CommonTool {
    private HttpServletResponse response;

    public void addUserLog() {
        try {
            this.response.getWriter().write("日志：一条日志<br/>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUserOnline() {
        try {
            this.response.getWriter().write("日志：在线人数<br/>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


}
