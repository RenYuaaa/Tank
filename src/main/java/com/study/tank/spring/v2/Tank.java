package com.study.tank.spring.v2;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-29 0:38
 * @description:
 */
public class Tank {

    public void move() {
        System.out.println("Tank moving claclacla...");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
