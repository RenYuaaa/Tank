package com.study.tank.builder;

/**
 * @author: renjiahui
 * @date: 2021-08-03 23:32
 * @description:
 */
public interface TerrainBuilder {

    /**
     * 构建墙
     *
     * @return
     */
    TerrainBuilder buildWall();

    /**
     * 构建碉堡
     *
     * @return
     */
    TerrainBuilder buildFort();

    /**
     * 构建地雷
     *
     * @return
     */
    TerrainBuilder buildMine();

    /**
     * 构建地形
     *
     * @return
     */
    Terrain build();
}
