package com.study.tank.proxy.v06;

import com.study.tank.proxy.v05.Tank;

import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-11 17:23
 * @description: 增加了tank移动日志的代理
 *                  该方法的弊端是：不能将时间和日志组合起来
 */
public class tank implements Movable {
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
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }


    @Override
    public void move() {
        System.out.println("start moving...");
        tank.move();
        System.out.println("Tank stopped!");
    }
}

interface Movable {
    void move() throws InterruptedException;
}