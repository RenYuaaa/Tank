package com.study.tank.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-07-28 23:50
 * @description: CGLIB实现动态代理不需要借口
 *  CGLIB缺陷：如果一个类是final的，则不能使用CGLIB动态代理
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        // 生成Tank类的子类
        enhancer.setSuperclass(Tank.class);


        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result;
        result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

