package com.study.tank.designpatterns.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:41
 * @description: 懒汉式单例-通过synchronized解决线程安全问题
 *  通过枷锁的方式解决线程问题，效率降低了
 */
public class Manager04 {

    private static Manager04 INSTANCE;

    private Manager04() {
    }

    public static synchronized Manager04 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Manager04.getInstance().hashCode())).start();
        }
    }
}
