package com.study.tank.factorymethod;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:31
 * @description: 扫把工厂
 */
public class BroomFactory {

    public Moveable craete() {
        System.out.println("a broom created");
        return new Broom();
    }
}
