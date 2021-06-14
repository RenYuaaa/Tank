package com.study.tank.designpatterns.factorymethod;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:11
 * @description: 工厂方法模式-Car工厂1
 */
public class CarFactory {

    public Moveable create() {
        System.out.println("a car created");
        return new Car();
    }
}
