package com.study.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: renjiahui
 * @date: 2021-06-09 22:48
 * @description: 资源管理者--管理图片的加载
 */
public class ResourceManager {

     public static BufferedImage tankL, tankU, tankR, tankD;
     public static BufferedImage bulletL, bulletU, bulletR, bulletD;

     static {
         try {
             // 四个方向的坦克的图片
             tankL= ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
             tankU= ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
             tankR= ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
             tankD= ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

             // 四个方向的子弹的图片
             bulletL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
             bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
             bulletR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
             bulletD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
}
