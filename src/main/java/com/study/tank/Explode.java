package com.study.tank;

import com.study.tank.facade.GameModel;
import com.study.tank.mediator.GameObject;

import java.awt.*;

/**
 * @author: renjiahui
 * @date: 2021-06-10 0:31
 * @description:
 */
public class Explode extends GameObject {

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

    GameModel gameModel = null;

    /**
     * 第几步
     */
    private int step = 0;

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
//        new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics g) {
        // 画爆炸图
        g.drawImage(ResourceManager.explodes[step++], x, y, null);

        if (step >= ResourceManager.explodes.length) {
            // 爆炸完之后直接去掉改爆炸
            gameModel.remove(this);
        }
    }


}
