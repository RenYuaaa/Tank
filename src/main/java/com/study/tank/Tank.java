package com.study.tank;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-04-21 21:54
 * @description: 坦克类
 */
public class Tank {

    /**
     * 坦克的左右位置
     */
    private int x;

    /**
     * 坦克的上下位置
     */
    private int y;

    private Dir dir = Dir.DOWN;

    /**
     * 坦克的速度
     */
    private static final int SPEED = 5;

    /**
     * 坦克的宽度
     */
    public static int WIDTH = ResourceManager.tankD.getWidth();

    /**
     * 坦克的高度
     */
    public static int HEIGHT = ResourceManager.tankD.getHeight();

    /**
     * 坦克是否移动
     */
    private Boolean moving = false;

    private TankFrame tankFrame = null;

    private Boolean living = true;


    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) {
            // 将坦克移除
            tankFrame.tanks.remove(this);
        }

        // 加载四个方向的坦克
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
        }


        move();
    }

    private void move() {
        if (!moving) {
            return;
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

    public Boolean getMoving() {
        return moving;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", moving=" + moving +
                '}';
    }

    /**
     * 打出一发子弹
     */
    public void fire() {

        // TODO：根据方向改变子弹的位置
        int bulletX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bullecY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.bullets.add(new Bullet(bulletX, bullecY, this.dir, this.tankFrame));
    }

    /**
     * 坦克销毁
     */
    public void die() {
        this.living = false;
    }
}
