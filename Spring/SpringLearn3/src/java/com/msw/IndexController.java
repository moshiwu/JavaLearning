package com.msw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by moqiaowen on 2017/7/5.
 */

@Controller
public class IndexController {

    @Autowired
    MyBean bean1;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index()
    {
        System.out.println(bean1);
        return "index";
    }

    @RequestMapping(value="/index2unmapping",method = RequestMethod.GET)
    public String index2()
    {
        System.out.println("index2");
        return "index2";
    }


}
