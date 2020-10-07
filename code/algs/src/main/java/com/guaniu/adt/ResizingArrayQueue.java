package com.guaniu.adt;


import java.util.Iterator;

/**
 *  练习 1.3.14
 * 使用数组实现可以变化容量的队列
 * @param <T>
 */
public class ResizingArrayQueue<T> implements Iterable<T>{
    private T[] arr; // 数组
    private int size; // 已有元素数量
    private int head; // 队列头部位置
    private int tail; // 队列尾部位置（其实是下一元素插入位置）

    private static int Default_Capacity = 8;

    public ResizingArrayQueue(){
        this(Default_Capacity);
    }

    public ResizingArrayQueue(int initCapacity){
        arr = (T[]) new Object[initCapacity];
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public T enqueue(T item){
        if (size() == arr.length){
            resize(arr.length << 1); // 容量不够扩容两倍
        }
        arr[tail++] = item;
        if (tail == arr.length){
            tail = 0;
        }
        size++;
        return item;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        if (size() == 0){
            throw  new UnsupportedOperationException();
        }
        T item = arr[head];
        arr[head] = null; // 释放内存
        head++;
        size--;
        if (head == arr.length){
            head = 0;
        }
        if (size() > 0 && size() < arr.length >> 2){ // 元素数量为容量的1/4时，容量缩小两倍
            resize(arr.length >> 1);
        }
        return item;
    }

    /**
     * 扩容或者缩容
     * @param capacity
     */
    private void resize(int capacity){
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++){
            temp[i] = arr[(head + i) % arr.length]; // 保证队列队手从数组0重新开始
        }
        arr = temp;
        head = 0;
        tail = size();
    }

    /**
     * 已有元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return size() == 0;
    }


    public Iterator iterator() {
        return new ResizingArrayQueueIterator();
    }

    private class ResizingArrayQueueIterator implements Iterator{

        private int i;

        public boolean hasNext() {
            return i < size();
        }

        public T next() {
            T item = arr[(head + i) / arr.length];
            i++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
