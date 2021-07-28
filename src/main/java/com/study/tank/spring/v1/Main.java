package com.study.tank.spring.v1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: renjiahui
 * @date: 2021-07-29 0:19
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank) context.getBean("tank");
        tank.move();
    }
}
