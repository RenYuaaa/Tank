package com.study.tank.iterator.v7;

/**
 * @author: renjiahui
 * @date: 2021-08-01 19:00
 * @description:
 */
public class Main {


    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        Iterator_<String> iterator_ = list.iterator();
        while (iterator_.hasNext()) {
            String next = iterator_.next();
            System.out.println(next);
        }
    }
}
