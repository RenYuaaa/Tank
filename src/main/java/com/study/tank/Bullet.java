package com.study.tank;

import com.study.tank.facade.GameModel;
import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-04-21 22:29
 * @description: 子弹类
 */
public class Bullet extends GameObject {

    /**
     * 子弹的速度
     */
    private static final int SPEED = 10;

    /**
     * 子弹的宽度
     */
    public static final int WIDTH = ResourceManager.bulletD.getWidth();

    /**
     * 子弹的高度
     */
    public static final int HEIGHT = ResourceManager.bulletD.getHeight();

    /**
     * 子弹的位置
     */
    private int x, y;

    /**
     * 枚举类：方向
     */
    private Dir dir;

    /**
     * 子弹是否存活，为了规避子弹创建出来不被销毁
     */
    private boolean living = true;


    /**
     * 分组，区分敌我坦克用
     */
    private Group group = Group.BAD;

    Rectangle rectangle = new Rectangle();


    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        GameModel.getInstance().add(this);

    }

    @Override
    public void paint(Graphics g) {
        // 加载四个方向的子弹
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        rectangle.x = this.x;
        rectangle.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 子弹销毁
     */
    public void die() {
        this.living = false;
    }
}
