package com.study.tank.facade;

import com.study.tank.chainofresponsibility.ColliderChain;
import com.study.tank.Dir;
import com.study.tank.Group;
import com.study.tank.PropertiesManager;
import com.study.tank.Tank;
import com.study.tank.mediator.GameObject;

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
//    public List<Tank> tanks = new ArrayList<>();
//
//    /**
//     * 爆炸图的集合
//     */
//    public List<Explode> explodes = new ArrayList();
//
//    /**
//     * 子弹
//     */
//    public List<Bullet> bullets = new ArrayList<>();

    List<GameObject> gameObjects = new ArrayList<>();

    /**
     * 碰撞检测
     */
    ColliderChain colliderChain = new ColliderChain();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertiesManager.get("initTankCount"));

        // 创建敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    /**
     * 增加游戏物体
     *
     * @param gameObject
     */
    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    /**
     * 移除游戏物体
     *
     * @param gameObject
     */
    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量: " + bullets.size(), 10, 60);
//        g.drawString("敌人的数量: " + tanks.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        // 判断和子弹和坦克做碰撞
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }

        // 相互碰撞
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject o1 = gameObjects.get(i);
                GameObject o2 = gameObjects.get(j);

                colliderChain.collide(o1, o2);
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
