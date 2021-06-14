package com.study.tank.designpatterns.singleton;

/**
 * @author: renjiahui
 * @date: 2021-06-13 22:54
 * @description: 懒汉式单例-静态内部类的方式实现
 *  JVM保证单例
 *  加载外部类（Manager07）时不会加载内部类，只有在调用getInstance()方法时才会加载内部类（Manager07Holder），这样可以实现懒加载
 *
 */
public class Manager07 {

    private static class Manager07Holder {
        private static Manager07 INSTANCE;
    }

    private Manager07() {
    }

    public static Manager07 getInstance() {
        return Manager07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Manager07.getInstance().hashCode())).start();
        }
    }
}
