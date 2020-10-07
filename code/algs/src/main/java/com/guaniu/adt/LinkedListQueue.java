package com.guaniu.adt;

/**
 * 链表实现先入先出（FIFO）队列
 * @param <T>
 */
public class LinkedListQueue<T> {
    private Node<T> head; // 头结点
    private Node<T> tail; // 尾结点
    private int size;

    /**
     * 入队
     * @param item
     * @return
     */
    public T enqueue(T item){
        Node<T> oldTail = tail;
        tail = new Node<T>(item);
        if (isEmpty()){
            head = tail;
        }else {
            oldTail.next = tail;
        }
        size++;
        return item;
    }


    public T dequque(){
        if (isEmpty()){
            throw new UnsupportedOperationException();
        }else {
            T item = head.item;
            head = head.next;
            size--;
            if (isEmpty()){
                tail = null; // tail = head;
            }
            return item;
        }
    }

    /**
     * 已有元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty(){
        return size() == 0; // 或者 head == null
    }
}
