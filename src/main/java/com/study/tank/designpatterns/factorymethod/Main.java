package com.study.tank.designpatterns.factorymethod;

/**
 * @author: renjiahui
 * @date: 2021-06-14 16:59
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        Moveable moveable = new CarFactory().create();
        moveable.go();
    }
}
