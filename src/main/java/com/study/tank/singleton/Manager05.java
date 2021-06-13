package com.study.tank.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:45
 * @description: 懒汉式单例-通过同步代码块的方式解决线程安全问题
 */
public class Manager05 {

    private static Manager05 INSTANCE;

    private Manager05() {
    }

    public static Manager05 getInstance() {
        if (INSTANCE == null) {
            /**
             * 通过减小同步代码块的方式提高效率
             * 当第一个线程指定到下面同步代码块处，但还未创建新对象时
             * 第二个线程到了该判读处，发现INSTANCE为空，则进入了判断内部。
             * 当第一个创建完对象释放锁后，第二个线程又创建了对象。
             * 根本上没有解决线程安全问题
             */
            synchronized (Manager05.class) {
                INSTANCE = new Manager05();
            }
        }
        return INSTANCE;
    }
}
