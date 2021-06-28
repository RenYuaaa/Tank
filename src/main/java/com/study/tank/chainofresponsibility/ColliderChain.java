package com.study.tank.chainofresponsibility;

import com.study.tank.mediator.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-06-17 0:07
 * @description:
 */
public class ColliderChain implements Collider {


    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider collider) {
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }

        return true;
    }
}
