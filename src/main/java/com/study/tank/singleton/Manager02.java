package com.study.tank.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:29
 * @description: 饿汉式单例-静态代码块形式
 */
public class Manager02 {
    private static final Manager02 INSTANCE;

    static {
        INSTANCE = new Manager02();
    }

    private Manager02() {

    }

    public static Manager02 getInstance() {
        return INSTANCE;
    }
}
