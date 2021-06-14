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



        int initTankCount = Integer.parseInt((String) PropertiesManager.get("initTankCount"));

        // 创建敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.tanks.add(tankFrame.gameFactory.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tankFrame));
        }

        while (true) {
            Thread.sleep(50);
            //repaint方法默认调用paint方法
            tankFrame.repaint();
        }
    }
}
