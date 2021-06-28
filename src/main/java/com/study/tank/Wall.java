package com.study.tank;

import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-28 23:17
 * @description:
 */
public class Wall extends GameObject {

    int weight, height;

    public Rectangle rectangle;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Wall(int x, int y, int weight, int height) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;

        this.rectangle = new Rectangle(x, y, weight, height);
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(x, y, weight, height);
        graphics.setColor(color);
    }
}
