package com.study.tank.proxy.v04;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-11 17:05
 * @description: 使用继承的方式记录tank移动的时间
 */
public class Tank implements Movable {
    /**
     * 模拟tank移动了一段时间
     *
     * @throws InterruptedException
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

class Tank2 extends Tank {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move() throws InterruptedException;
}
