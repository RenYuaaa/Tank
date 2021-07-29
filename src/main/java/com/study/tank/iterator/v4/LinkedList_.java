package com.study.tank.iterator.v4;

import java.util.Objects;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:50
 * @description:
 */
public class LinkedList_ implements Collection_ {
    
    Node head = null;
    Node tail = null;

    private int size = 0;

    @Override
    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;

        if (Objects.isNull(head)) {
            head = node;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return null;
    }


}
