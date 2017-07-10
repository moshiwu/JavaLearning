package com.msw;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by moqiaowen on 2017/7/7.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface MyAutowired {


}
