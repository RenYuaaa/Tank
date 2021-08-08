package com.study.tank.iterator.v7;


/**
 * @author: renjiahui
 * @date: 2021-07-30 0:49
 * @description:
 */
public class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[]) new Object[10];

    /**
     * E[]中下一个空的位置在哪，或者说，目前容器中又多少个元素
     */
    private int index = 0;

    @Override
    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[]) new Object[objects.length + 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator_<E> {
        private int currentIndex = 0;


        @Override
        public boolean hasNext() {
            if (currentIndex >= index) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E o = (E) objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}