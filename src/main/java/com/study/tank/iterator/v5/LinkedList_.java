package com.study.tank.iterator.v5;

import java.util.Objects;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:50
 * @description:
 */
public class LinkedList_ implements Collection_ {

    /**
     * 头节点
     */
    Node head = null;

    /**
     * 尾节点
     */
    Node tail = null;

    private int size = 0;

    @Override
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {

        @Override
        public boolean hasNext() {
            if (Objects.isNull(tail.next)) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
