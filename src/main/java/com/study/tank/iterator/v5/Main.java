package com.study.tank.iterator.v5;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:54
 * @description:
 *  v1：构建一个容器，可以添加对象
 *  v2：用链表实现一个容器
 *  v3：添加容器的共同接口，实现容器的替换
 *  v5：对容器进行遍历
 */
public class Main {

    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        Iterator_ iterator_ = list.iterator();
        while (iterator_.hasNext()) {
            Object next = iterator_.next();
            System.out.println(next);
        }
    }
}
