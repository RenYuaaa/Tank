package com.study.tank.chainofresponsibility;

import com.study.tank.Tank;
import com.study.tank.mediator.GameObject;

/**
 * @author: renjiahui
 * @date: 2021-06-16 23:40
 * @description: 坦克和坦克的碰撞检测
 */
public class TankTankCollider implements Collider {

    /**
     * 坦克和子弹的碰撞
     *
     * @param o1
     * @param o2
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;

            // 应该将collideWith方法的代码移到这里
            if (tank1.getRectangle().intersects(tank2.getRectangle())) {
                tank1.setMoving(false);
                tank2.setMoving(false);
            }
        }
        return true;
    }
}
