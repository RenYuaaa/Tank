package com.study.tank.strategy;


import java.util.Arrays;

/**
 * @author: renjiahui
 * @date: 2021-06-13 23:40
 * @description:
 */
public class Main {

    public static void main(String[] args) {
//        int[] a = {9, 2, 3, 5, 7, 1, 4};
//        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Dog[] a = {new Dog(3), new Dog(6), new Dog(1)};

//        Sorter sorter = new Sorter();
//        sorter.sort(a);

        Sorter<Dog> sorter = new Sorter<>();
        sorter.sort(a, new DogComparator());


        System.out.println(Arrays.toString(a));
    }
}
