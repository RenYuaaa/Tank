package com.study.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-04-20 21:12
 * @description: 监听
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 400, Dir.DOWN, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet bullet = new Bullet(300, 300, Dir.DOWN, this);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Image offScreenImage = null;
    List<Tank> tanks = new ArrayList<>();


    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Main War");
        setVisible(true);

        //对键盘的监听处理
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 双缓冲解决闪烁问题
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 画笔
     */
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量: " + bullets.size(), 10, 60);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

    }

    /**
     * 键盘的监听处理类
     */
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /**
         * 按下键盘按键的响应
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        /**
         * 抬起键盘按键的响应
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        /**
         * 创建主战坦克的方向
         */
        private void setMainTankDir() {

            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);

                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }

                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }

                if (bU) {
                    myTank.setDir(Dir.UP);
                }

                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
            }
        }
    }
}
