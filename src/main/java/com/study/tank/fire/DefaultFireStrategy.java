package com.study.tank.fire;

import com.study.tank.Bullet;
import com.study.tank.Tank;
import com.study.tank.decorator.RectDecorator;
import com.study.tank.decorator.TailDecorator;
import com.study.tank.facade.GameModel;

/**
 * @author: renjiahui
 * @date: 2021-06-14 16:05
 * @description: 默认开火策略
 */
public class DefaultFireStrategy implements FireStrategy {


    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bullecY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        // TODO: BUG--new Bullet() 把自己又加了一遍
        GameModel.getInstance().add(new RectDecorator(new TailDecorator((new Bullet(bulletX, bullecY, tank.getDir(), tank.getGroup())))));

    }
}
