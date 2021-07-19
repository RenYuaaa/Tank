package com.study.tank.proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-19 23:22
 * @description: 问题1：想记录tank的移动时间
 * 最简单的办法：修改代码，记录时间
 * <p>
 * 问题2：如果无法改变方法源码怎么办？
 * 用继承？
 * v05：使用代理
 * v06：代理各种类型
 * <p>
 * 问题：如何实现代理的各种组合？继承？Decorator？
 * v07：代理的对象改成Movable类型-越来越像Decorator了
 * v08：如果有stop方法需要代理。。。
 * 如果想让logProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型Object
 * 毕竟日志记录，时间计算是很多方法都需要的东西，这是该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
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

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHander(tank));

        movable.move();
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


