package com.study.tank.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:31
 * @description: 懒汉式单例
 *  使用到了才实例化。
 *  缺点：带来了线程不安全的问题
 */
public class Manager03 {

    private static Manager03 INSTANCE;

    private Manager03() {
    }

    public static Manager03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Manager03.getInstance().hashCode())).start();
        }
    }
}
