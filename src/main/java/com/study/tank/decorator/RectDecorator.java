package com.study.tank.decorator;

import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-07-03 16:24
 * @description:
 */
public class RectDecorator extends GoDecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics graphics) {
        this.x = gameObject.x;
        this.y = gameObject.y;

        gameObject.paint(graphics);

        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawRect(super.gameObject.x, super.gameObject.y, super.gameObject.getWidth() + 2, super.gameObject.getHeight() + 2);
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
