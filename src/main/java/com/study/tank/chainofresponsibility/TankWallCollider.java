package com.study.tank.chainofresponsibility;

import com.study.tank.Tank;
import com.study.tank.Wall;
import com.study.tank.mediator.GameObject;

/**
 * @author: renjiahui
 * @date: 2021-06-28 23:31
 * @description:
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;

            if (tank.getRectangle().intersects(wall.getRectangle())) {
                tank.back();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            return collide(o2, o1);
        }
        return false;
    }
}
