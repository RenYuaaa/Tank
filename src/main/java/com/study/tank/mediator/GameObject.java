package com.study.tank.mediator;

import java.awt.*;
import java.io.Serializable;

/**
 * @author: renjiahui
 * @date: 2021-06-16 23:08
 * @description: 游戏物体-mediator（调停者模式）
 */
public abstract class GameObject implements Serializable {

    /**
     * 位置
     */
    public int x, y;

    public abstract void paint(Graphics graphics);
    public abstract int getWidth();
    public abstract int getHeight();


}
