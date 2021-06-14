package com.study.tank.abstractfactory;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-14 23:18
 * @description:
 */
public abstract class BaseBullet {

    public abstract void paint(Graphics graphics);

    public abstract void collideWith(BaseTank tank);
}
