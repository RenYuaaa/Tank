package com.study.tank.proxy.v10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-27 23:41
 * @description: 通过反射
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
        Tank tank = new Tank();

//        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
//                new Class[]{Movable.class},
//                (proxy, method, args1) -> {
//                    System.out.println("method: " + method.getName() + " start...");
//                    Object invoke = method.invoke(tank, args1);
//                    System.out.println("method: " + method.getName() + "end!");
//                    return invoke;
//                });

        // 动态生成Proxy类--反编译的类（jdk8以前用下面这种，jdk8以上用--System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");）
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank));

        movable.move();
    }
}

class TimeProxy implements InvocationHandler {

    Movable movable;

    public TimeProxy(Movable movable) {
        this.movable = movable;
    }

    public void before() {
        System.out.println("method start==========");
    }

    public void after() {
        System.out.println("method end==========");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(movable, args);
        after();
        return invoke;
    }
}

class LogHander implements InvocationHandler {

    Tank tank;

    public LogHander(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method: " + method.getName() + " start...");
        Object invoke = method.invoke(tank, args);
        System.out.println("method: " + method.getName() + "end!");
        return invoke;
    }
}

interface Movable {
    void move();
}