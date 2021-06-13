package com.study.tank.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:58
 * @description: 懒汉式单例-枚举方式实现
 *  不仅可以解决线程同步，还可以防止反序列化
 */
public enum Manager08 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Manager08.INSTANCE.hashCode())).start();
        }
    }

}
