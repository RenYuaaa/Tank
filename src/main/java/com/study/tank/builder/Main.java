package com.study.tank.builder;

/**
 * @author: renjiahui
 * @date: 2021-08-03 23:37
 * @description:
 *  建造者模式--将一个复杂对象的构建和表示分离
 */
public class Main {

    public static void main(String[] args) {
        ComplexTerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain terrain = builder.buildFort().buildMine().buildWall().build();

        Person person = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 10)
                .weight(200)
                .build();
    }
}
