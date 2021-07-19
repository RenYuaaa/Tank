package com.study.tank.proxy.v03;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-11 17:00
 * @description:
 */
public class Tank implements Movable {
    /**
     * 模拟tank移动了一段时间
     *
     * @throws InterruptedException
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable {
    void move() throws InterruptedException;
}
