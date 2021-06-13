package com.study.tank.strategy;

/**
 * @author: renjiahui
 * @date: 2021-06-14 0:34
 * @description:
 */
public class CatHeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height > o2.height) {
            return -1;
        } else if (o1.height < o2.height) {
            return 1;
        } else {
            return 0;
        }
    }
}
