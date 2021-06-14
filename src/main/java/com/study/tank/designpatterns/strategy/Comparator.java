package com.study.tank.designpatterns.strategy;

/**
 * @author: renjiahui
 * @date: 2021-06-14 0:23
 * @description:
 */
public interface Comparator<T> {

    int compare(T o1, T o2);
}
