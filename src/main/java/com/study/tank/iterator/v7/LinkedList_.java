package com.study.tank.iterator.v7;

import java.util.Objects;

/**
 * @author: renjiahui
 * @date: 2021-07-30 0:50
 * @description:
 */
public class LinkedList_<E> implements Collection_<E> {

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
    public void add(E o) {
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

    private class Node<E> {
        private E o;
        Node next;

        public Node(E o) {
            this.o = o;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator_<E> {

        @Override
        public boolean hasNext() {
            if (Objects.isNull(head.next)) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            return null;
        }
    }

}
