package com.study.tank.facade;

import com.study.tank.*;
import com.study.tank.chainofresponsibility.ColliderChain;
import com.study.tank.mediator.GameObject;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-06-16 22:29
 * @description: facade-门面模式
 */
public class GameModel implements Serializable {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    /**
     * 己方坦克
     */
    Tank myTank;

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

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private GameModel() {
    }

    /**
     *
     */
    private void init() {
        // 初始化己方tank
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
        int initTankCount = Integer.parseInt((String) PropertiesManager.get("initTankCount"));

        // 创建敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        // 初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
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


    /**
     * 存盘
     * 通过输出流，将对象保存到硬盘中--相当于保存一个瞬时日志--备忘录模式
     */
    public void save() {
        File file = new File("d:/ideaProject/Tank");

        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(myTank);
            stream.writeObject(gameObjects);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取进度
     * 备忘录模式--通过输入流，读取硬盘中保存的瞬时文件，将tank变回文件中记录的位置
     */
    public void load() {
        File file = new File("d:/ideaProject/Tank");
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(file));
            myTank = (Tank) stream.readObject();
            gameObjects = (List<GameObject>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
