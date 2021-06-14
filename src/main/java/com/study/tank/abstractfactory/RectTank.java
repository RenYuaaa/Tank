package com.study.tank.abstractfactory;

import com.study.tank.*;
import com.study.tank.fire.DefaultFireStrategy;
import com.study.tank.fire.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @author: renjiahui
 * @date: 2021-04-21 21:54
 * @description: 坦克类
 */
public class RectTank extends BaseTank {

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
    private static final int SPEED = 5;

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

    private TankFrame tankFrame = null;

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


    public RectTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

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

    @Override
    public void paint(Graphics g) {
        if (!living) {
            // 将坦克移除
            tankFrame.tanks.remove(this);
        }

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);

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

        if (this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - RectTank.WIDTH - 2;
        }

        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;
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

    @Override
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
        RectTank.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        RectTank.HEIGHT = HEIGHT;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
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

    @Override
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
//        fireStrategy.fire(this);
        int bulletX = this.x + RectTank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bullecY = this.y + RectTank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            this.getTankFrame().gameFactory.createBullet(bulletX, bullecY, dir, this.group, this.tankFrame);
        }
    }

    /**
     * 坦克销毁
     */
    @Override
    public void die() {
        this.living = false;
    }
}
