package com.study.tank.fire;

import com.study.tank.Bullet;
import com.study.tank.Dir;
import com.study.tank.Tank;

/**
 * @author: renjiahui
 * @date: 2021-06-14 16:19
 * @description: 四个方向的开火策略
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bullecY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bulletX, bullecY, dir, tank.getGroup());
        }
    }
}
