package com.study.tank.decorator;

import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-07-03 16:23
 * @description: 装饰者模式
 */
public abstract class GoDecorator extends GameObject {

    GameObject gameObject;

    public GoDecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public abstract void paint(Graphics graphics);

}
