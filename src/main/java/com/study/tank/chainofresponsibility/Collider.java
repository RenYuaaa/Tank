package com.study.tank.chainofresponsibility;

import com.study.tank.mediator.GameObject;

/**
 * @author: renjiahui
 * @date: 2021-06-16 23:37
 * @description: 碰撞器
 */
public interface Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true--停止，false--继续
     */
    boolean collide(GameObject o1, GameObject o2);
}
