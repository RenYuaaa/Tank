package com.study.tank.decorator;

import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-07-03 16:52
 * @description:
 */
public class TailDecorator extends GoDecorator {


    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics graphics) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        gameObject.paint(graphics);

        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawLine(gameObject.x, gameObject.y, gameObject.x + gameObject.getWidth(), gameObject.y + gameObject.getHeight());
        graphics.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }

}
