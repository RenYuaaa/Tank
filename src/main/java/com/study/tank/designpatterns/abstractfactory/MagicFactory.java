package com.study.tank.designpatterns.abstractfactory;

/**
 * @author: renjiahui
 * @date: 2021-06-14 17:58
 * @description:
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
