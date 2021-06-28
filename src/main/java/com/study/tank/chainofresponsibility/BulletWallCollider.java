package com.study.tank.chainofresponsibility;

import com.study.tank.Bullet;
import com.study.tank.Wall;
import com.study.tank.mediator.GameObject;

/**
 * @author: renjiahui
 * @date: 2021-06-28 23:24
 * @description: 子弹与墙体的碰撞
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;

            if (bullet.getRectangle().intersects(wall.getRectangle())) {
                bullet.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
