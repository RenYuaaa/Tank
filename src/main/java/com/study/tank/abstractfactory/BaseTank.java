package com.study.tank.abstractfactory;

import com.study.tank.Group;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-14 23:17
 * @description:
 */
public abstract class BaseTank {

    public Group group = Group.BAD;

    public Rectangle rectangle = new Rectangle();

    public abstract void paint(Graphics graphics);

    public Group getGroup() {
        return this.group;
    };

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
