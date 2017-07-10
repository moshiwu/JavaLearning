package com.msw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by moqiaowen on 2017/7/5.
 */

@WebServlet(name = "com.msw.MyServlet", urlPatterns = "/s1")

public class MyServlet extends HttpServlet {

    @Autowired()
    public MyBean bean1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("com.msw.MyServlet init2");

        //在Servlet中使用Autowired，需要使用以下代码，并在web.xml中配置<context-param>和<listener>标签
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html,charset=utf-8");


        System.out.println("com.msw.MyServlet do get");

        System.out.println(bean1);

        //以下这样写是没问题，可以拿到bean的
//        BeanFactory factory = new ClassPathXmlApplicationContext("../mvc-dispatcher-servlet.xml");
//        MyBean bean2 = (MyBean) factory.getBean("bean1");
//        System.out.println(bean2);


        System.out.println(req.getRequestURI());


        try {
            Class c = Class.forName("com.msw.MyClass");

            Object obj = c.newInstance();

            Method[] methods = c.getMethods();

            //遍历方法和调用
            for (Method method : methods) {
                System.out.println("method : " + method.getName());

                if (method.getName() == "getName") {
                    System.out.println(method.invoke(obj, req, resp).toString());

                    //遍历注解
                    Annotation[] anlist = method.getAnnotations();

                    for (Annotation annotation : anlist) {
                        System.out.println("method annotation : " + annotation.toString());
                    }
                }
            }

            //遍历注解
            Annotation[] anlist = c.getAnnotations();

            for (Annotation annotation : anlist) {
                System.out.println("class annotation : " + annotation.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
