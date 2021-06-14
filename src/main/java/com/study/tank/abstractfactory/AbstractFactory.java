package com.study.tank.abstractfactory;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:49
 * @description: 抽象工厂
 */
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}
