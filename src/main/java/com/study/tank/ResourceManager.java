package com.study.tank;

import com.study.tank.utils.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: renjiahui
 * @date: 2021-06-09 22:48
 * @description: 资源管理者--管理图片的加载
 */
public class ResourceManager {

     public static BufferedImage tankL, tankU, tankR, tankD;
     public static BufferedImage bulletL, bulletU, bulletR, bulletD;
     public static BufferedImage[] explodes = new BufferedImage[16];

     static {
         try {
             // 四个方向的坦克的图片
             tankU= ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
             tankL= ImageUtil.rotateImage(tankU, -90);
             tankR= ImageUtil.rotateImage(tankU, 90);
             tankD= ImageUtil.rotateImage(tankU, 180);

             // 四个方向的子弹的图片
             bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
             bulletL = ImageUtil.rotateImage(bulletU, -90);
             bulletR = ImageUtil.rotateImage(bulletU, 90);
             bulletD = ImageUtil.rotateImage(bulletU, 180);

             for (int i = 0; i < 16; i++) {
                 explodes[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
}
