package com.study.tank.designpatterns.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:50
 * @description: 懒汉式单例-双检机制的懒汉单例
 */
public class Manager06 {

    private static volatile Manager06 INSTANCE;

    private Manager06() {
    }

    public static Manager06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Manager06.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Manager06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Manager06.getInstance().hashCode())).start();
        }
    }
}
