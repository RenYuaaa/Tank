package com.study.tank.spring.v2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: renjiahui
 * @date: 2021-07-29 0:38
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank) context.getBean("tank");
        tank.move();
    }
}
