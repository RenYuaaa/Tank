package com.study.tank.iterator.v3;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:48
 * @description:
 *  v1：构建一个容器，可以添加对象
 *  v2：用链表实现一个容器
 *  v3：添加容器的共同接口，实现容器的替换
 */
public class Main {

    public static void main(String[] args) {
        Collection_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());
    }
}
