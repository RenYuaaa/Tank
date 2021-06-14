package com.study.tank.designpatterns.abstractfactory;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:57
 * @description:
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
