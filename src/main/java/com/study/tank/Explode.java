package com.study.tank;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-10 0:31
 * @description:
 */
public class Explode {

    /**
     * 爆炸图的宽度
     */
    public static int WIDTH = ResourceManager.explodes[0].getWidth();

    /**
     * 爆炸图的高度
     */
    public static int HEIGHT = ResourceManager.explodes[0].getHeight();

    /**
     * 爆炸图的位置
     */
    private int x, y;

    TankFrame tankFrame;

    /**
     * 第几步
     */
    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        // 画爆炸图
        g.drawImage(ResourceManager.explodes[step++], x, y, null);

        if (step >= ResourceManager.explodes.length) {
            step = 0;
        }
    }


}
