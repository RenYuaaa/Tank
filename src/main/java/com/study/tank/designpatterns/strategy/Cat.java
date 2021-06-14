package com.study.tank.designpatterns.strategy;

/**
 * @author: renjiahui
 * @date: 2021-06-13 23:48
 * @description:
 */
public class Cat implements Comparable<Cat> {

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat cat) {
        if (this.weight < cat.weight) {
            return -1;
        } else if (this.weight > cat.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
