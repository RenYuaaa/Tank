package com.study.tank;

import com.study.tank.abstractfactory.BaseExplode;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-10 0:31
 * @description:
 */
public class Explode extends BaseExplode {

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

    @Override
    public void paint(Graphics g) {
        // 画爆炸图
        g.drawImage(ResourceManager.explodes[step++], x, y, null);

        if (step >= ResourceManager.explodes.length) {
            // 爆炸完之后直接去掉改爆炸
            tankFrame.explodes.remove(this);
        }
    }


}
