package com.study.tank.fire;

import com.study.tank.Tank;

import java.io.Serializable;

/**
 * @author: renjiahui
 * @date: 2021-06-14 16:05
 * @description: 开火策略
 */
public interface FireStrategy extends Serializable {

    void fire(Tank tank);
}
