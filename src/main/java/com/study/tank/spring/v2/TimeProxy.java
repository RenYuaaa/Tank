package com.study.tank.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: renjiahui
 * @date: 2021-07-29 0:26
 * @description:
 */
@Aspect
public class TimeProxy {

    @Before("execution(void com.study.tank.spring.v2.Tank.move())")
    public void before() {
        System.out.println("method start..." + System.currentTimeMillis());
    }

    @After("execution(void com.study.tank.spring.v2.Tank.move())")
    public void after() {
        System.out.println("method end..." + System.currentTimeMillis());
    }
}
