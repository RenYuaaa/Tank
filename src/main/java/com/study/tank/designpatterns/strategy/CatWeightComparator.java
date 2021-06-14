package com.study.tank.designpatterns.strategy;

/**
 * @author: renjiahui
 * @date: 2021-06-14 0:32
 * @description:
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight < o2.weight) {
            return -1;
        } else if (o1.weight > o2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}
