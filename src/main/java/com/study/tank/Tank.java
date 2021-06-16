package com.study.tank;

import com.study.tank.fire.DefaultFireStrategy;
import com.study.tank.fire.FireStrategy;
import com.study.tank.fire.FourDirFireStrategy;

import java.awt.*;
import java.util.Random;

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

    /**
     * 枚举类：方向
     */
    private Dir dir = Dir.DOWN;

    /**
     * 坦克的速度
     */
    private static final int SPEED = 2;

    /**
     * 坦克的宽度
     */
    public static int WIDTH = ResourceManager.goodTankD.getWidth();

    /**
     * 坦克的高度
     */
    public static int HEIGHT = ResourceManager.goodTankD.getHeight();

    /**
     * 坦克是否移动
     */
    private Boolean moving = true;


    /**
     * 坦克是否存活
     */
    private Boolean living = true;

    /**
     * 随机数
     */
    private Random random = new Random();

    private Group group = Group.BAD;

    Rectangle rectangle = new Rectangle();

    /**
     * 默认开火策略
     */
    FireStrategy fireStrategy;

    /**
     * 游戏模型-facade
     */
    GameModel gameModel = null;


    public Tank(int x, int y, Dir dir, Group group, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gameModel = gameModel;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        if (group == Group.GOOD) {
            String goodFireStrategy = (String) PropertiesManager.get("goodFireStrategy");
            try {
                fireStrategy = (FireStrategy) Class.forName(goodFireStrategy).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            fireStrategy = new DefaultFireStrategy();
        }
    }

    public void paint(Graphics g) {
        if (!living) {
            // 将坦克移除
            gameModel.tanks.remove(this);
        }


        // 加载四个方向的坦克
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceManager.goodTankL : ResourceManager.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceManager.goodTankR : ResourceManager.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceManager.goodTankU : ResourceManager.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceManager.goodTankD : ResourceManager.badTankD, x, y, null);
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

        // 地方坦克开火--大于5的时候开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        // 地方坦克随机向一个方向移动
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        // 边界检测
        boundsCheck();

        // 更新rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    /**
     * 坦克的边界检测
     */
    private void boundsCheck() {
        if (this.x < 0) {
            x = 2;
        }

        if (this.y < 28) {
            y = 28;
        }

        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }

        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    /**
     * 敌人坦克随机向一个方向转动
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Tank.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Tank.HEIGHT = HEIGHT;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public FireStrategy getFireStrategy() {
        return fireStrategy;
    }

    public void setFireStrategy(FireStrategy fireStrategy) {
        this.fireStrategy = fireStrategy;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public Boolean getLiving() {
        return living;
    }

    public void setLiving(Boolean living) {
        this.living = living;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        fireStrategy.fire(this);
    }

    /**
     * 坦克销毁
     */
    public void die() {
        this.living = false;
    }
}
