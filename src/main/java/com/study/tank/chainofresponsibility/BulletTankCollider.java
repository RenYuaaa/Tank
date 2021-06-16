package com.study.tank.chainofresponsibility;

import com.study.tank.Bullet;
import com.study.tank.Tank;
import com.study.tank.mediator.GameObject;

/**
 * @author: renjiahui
 * @date: 2021-06-16 23:40
 * @description: 坦克和子弹的碰撞检测
 */
public class BulletTankCollider implements Collider {

    /**
     * 坦克和子弹的碰撞
     *
     * @param o1
     * @param o2
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;

            // 应该将collideWith方法的代码移到这里
            if (bullet.collideWith(tank)) {
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;

    }
}
