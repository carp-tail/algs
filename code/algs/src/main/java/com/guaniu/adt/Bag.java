package com.guaniu.adt;

import java.util.Iterator;

/**
 * Bag 以链表形式实现，类似于 LinkedListStack
 * @param <T>
 */
public class Bag<T> implements Iterable {
    private Node<T> head;
    private int size;

    public T add(T item){
        Node<T> node = new Node<T>(item);
        node.next = head;
        head = node;
        size++;
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public Iterator iterator() {
        return iterator();
    }

    private class ListIterator implements Iterator{

        private Node curr = head;

        public boolean hasNext() {
            return curr != null;
        }

        public Node next() {
            return curr.next;
        }

        public void remove() {
            // todo
        }
    }
}
