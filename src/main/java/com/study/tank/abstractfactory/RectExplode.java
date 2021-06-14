package com.study.tank.abstractfactory;

import com.study.tank.ResourceManager;
import com.study.tank.TankFrame;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-14 23:35
 * @description:
 */
public class RectExplode extends BaseExplode {

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

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
//        new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics graphics) {
        // 画爆炸图
//        graphics.drawImage(ResourceManager.explodes[step++], x, y, null);
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 10 * step, 10 * step);
        step++;

        if (step >= 5) {
            tankFrame.explodes.remove(this);
        }

        graphics.setColor(color);
    }
}
