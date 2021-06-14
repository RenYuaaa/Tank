package com.study.tank.designpatterns.abstractfactory;

/**
 * @author: renjiahui
 * @date: 2021-06-14 16:59
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ModernFactory();
        Food food = abstractFactory.createFood();
        food.printName();
        Vehicle vehicle = abstractFactory.createVehicle();
        vehicle.go();
        Weapon weapon = abstractFactory.createWeapon();
        weapon.shoot();
    }
}
 