package com.study.tank;

/**
 * @author: renjiahui
 * @date: 2021-04-20 1:19
 * @description: 主类
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 创建自己的坦克
        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(25);
            //repaint方法默认调用paint方法
            tankFrame.repaint();
        }
    }
}
