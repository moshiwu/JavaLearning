package com.msw;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moqiaowen on 2017/7/10.
 */


@Controller
public class IndexController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void loadIndex(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-type", "text/html;charset=utf-8");


        BeanFactory factory = new ClassPathXmlApplicationContext("AOP_Config.xml");


        CommonTool toolInstance = (CommonTool) factory.getBean("commonTool");

        UserService studentService = (UserService) factory.getBean("studentServiceBean");
        UserService teacherService = (UserService) factory.getBean("studentServiceBean");


        try {
            toolInstance.setResponse(response);


            studentService.setRequest(request);
            studentService.setResponse(response);
            teacherService.setRequest(request);
            teacherService.setResponse(response);

            studentService.register();
            studentService.login();

            teacherService.register();
            teacherService.login();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
