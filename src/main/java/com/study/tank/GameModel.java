package com.study.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-06-16 22:29
 * @description: facade-门面模式
 */
public class GameModel {

    /**
     * 己方坦克
     */
    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

    /**
     * 敌方坦克
     */
    List<Tank> tanks = new ArrayList<>();

    /**
     * 爆炸图的集合
     */
    List<Explode> explodes = new ArrayList();

    /**
     * 子弹
     */
    List<Bullet> bullets = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertiesManager.get("initTankCount"));

        // 创建敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }



    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量: " + bullets.size(), 10, 60);
        g.drawString("敌人的数量: " + tanks.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);

        // 子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        // 地方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        // 画出爆炸图
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }


        // 判断和子弹和坦克做碰撞
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    /**
     * 拿到己方tank
     *
     * @return
     */
    public Tank getMainTank() {
        return myTank;
    }


}
