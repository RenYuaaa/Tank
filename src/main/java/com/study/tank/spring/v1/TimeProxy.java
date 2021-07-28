package com.study.tank.spring.v1;

/**
 * @author: renjiahui
 * @date: 2021-07-29 0:26
 * @description:
 */
public class TimeProxy {

    public void before() {
        System.out.println("method start..." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method end..." + System.currentTimeMillis());
    }
}
