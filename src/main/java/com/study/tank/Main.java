package com.study.tank;

/**
 * @author: renjiahui
 * @date: 2021-04-20 1:19
 * @description:
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Frame frame = new Frame();
//
//        //设置窗口大小
//        frame.setSize(800, 600);
//        //设置标题
//        frame.setTitle("Main War");
//        //设置开启窗口
//        frame.setVisible(true);
//
//        //设置关闭窗口的监听器
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

        TankFrame tankFrame = new TankFrame();
        while (true) {
            Thread.sleep(50);
            //repaint方法默认调用paint方法
            tankFrame.repaint();
        }
    }
}
