package com.study.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: renjiahui
 * @date: 2021-06-12 23:43
 * @description: 原生java中哩用反射获取配置
 */
public class PropertiesManager {

    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (properties == null) {
            return null;
        } else {
            return properties.get(key);
        }
    }


    public static void main(String[] args) {
        System.out.println(PropertiesManager.get("initTankCount"));
    }
}
