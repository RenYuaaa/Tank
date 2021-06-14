package com.study.tank.abstractfactory;

import com.study.tank.*;

/**
 * @author: renjiahui
 * @date: 2021-06-14 23:35
 * @description:
 */
public class RectFactory extends GameFactory {




    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, dir, group, tankFrame);
    }
}
