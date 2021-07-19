package com.study.tank.proxy.v02;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-11 16:59
 * @description: 记录tank移动的时间
 */
public class Tank implements Movable {
    /**
     * 模拟tank移动了一段时间
     *
     * @throws InterruptedException
     */
    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving claclacla...");
        Thread.sleep(new Random().nextInt(10000));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move() throws InterruptedException;
}