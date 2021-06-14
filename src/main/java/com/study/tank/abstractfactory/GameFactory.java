package com.study.tank.abstractfactory;

import com.study.tank.*;

/**
 * @author: renjiahui
 * @date: 2021-06-14 23:14
 * @description:
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);
}
