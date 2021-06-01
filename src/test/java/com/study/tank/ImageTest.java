package com.study.tank;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: renjiahui
 * @date: 2021-06-02 0:42
 * @description:
 */
public class ImageTest {

    @Test
    public void testImage() {
        try {
            // 从绝对路径获取图片
            BufferedImage image = ImageIO.read(new File("D:\\ideaProject\\Tank\\src\\main\\resources\\images\\0.gif"));
            assert Objects.nonNull(image);

            // 从classpath中获取图片，idea中的Java项目，如果要将图片也编译到对应的classes中，要将图片放在resource文件加下
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/1.gif"));
            assert Objects.nonNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
