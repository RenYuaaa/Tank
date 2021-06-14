package com.study.tank.designpatterns.factorymethod;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:05
 * @description: 扫把
 */
public class Broom implements Moveable {
    @Override
    public void go() {
        System.out.println("broom fly chuachuachua");
    }
}
