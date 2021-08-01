package com.study.tank.iterator.v2;


import java.util.Objects;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:37
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_ {
    Node head = null;
    Node tail = null;

    private int size = 0;

    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;

        if (Objects.isNull(head)) {
            head = node;
            tail = node;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    public int size() {
        return size;
    }
}
