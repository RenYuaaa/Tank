package com.study.tank.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:20
 * @description: 饿汉式单例：
 *  类加载到内存后，就实例化一个单例，JVM保证线程安全
 *  简单使用，推荐使用！
 *  唯一缺点： 不管用到与否，类加载时就完成实例化
 */
public class Manager01 {

    private static final Manager01 INSTANCE = new Manager01();

    private Manager01() {

    }

    public static Manager01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Manager01 instance01 = Manager01.getInstance();
        Manager01 instance02 = Manager01.getInstance();
        System.out.println(instance01 == instance02);
    }
}
