package com.study.tank.chainofresponsibility;

import com.study.tank.Bullet;
import com.study.tank.Explode;
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


            if (this.collideWith(bullet, tank)) {
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;

    }

    /**
     * 判断子弹和坦克是否相交
     *
     * @param bullet 子弹对象
     * @param tank   坦克对象
     * @return true/false1
     */
    private boolean collideWith(Bullet bullet, Tank tank) {
        // 如果属性相同则不检测
        if (bullet.getGroup() == tank.getGroup()) {
            return false;
        }

        // rectangle1和rectangle2是否相撞
        if (bullet.getRectangle().intersects(tank.getRectangle())) {
            tank.die();
            bullet.die();

            int explodeX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int explodeY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            new Explode(explodeX, explodeY);
            return true;
        }
        return false;
    }
}
