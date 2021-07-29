package com.study.tank.proxy.v01;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-11 16:52
 * @description: 记录坦克移动时间
 */
public class Tank implements Movable {

    /**
     * 模拟tank移动了一段时间
     *
     * @throws InterruptedException
     */
    @Override
    public void move() throws InterruptedException {

        System.out.println("Tank moving claclacla...");
        Thread.sleep(new Random().nextInt(10000));
    }
}

interface Movable {
    void move() throws InterruptedException;
}
