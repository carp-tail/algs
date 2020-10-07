package com.guaniu.adt;

import java.util.Iterator;

/**
 * 动态变化数组容量的栈
 * 支持迭代遍历（由栈顶至栈底）
 */
public class ResizingArrayStack<T> implements Iterable<T>{

    private T[] arr; // 主体数组
    private int size; // 已存储元素的数量(size < arr.length)

    private static int Default_Capacity = 8;

    public ResizingArrayStack() {
        this(Default_Capacity);
    }

    public ResizingArrayStack(int initCapacity) {
        arr = (T[]) new Object[initCapacity];
    }

    /**
     * 元素压栈
     * @param item
     * @return
     */
    public T push(T item){
        if (size == arr.length){ // 容量达到极限的时候，二倍扩容
            resize(size << 1);
        }
        arr[size++] = item;
        return item;
    }

    private void resize(int capacity){
        T[] newArr = (T[]) new Object[capacity]; // 新建容量为新容量的数组
        for (int i = 0;i < size;i ++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        newArr = null;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop(){
        T top = arr[--size];
        if (size > 0 && size < arr.length >> 2){ // 元素数量 < 容量/4
            resize(arr.length >> 1);
        }
        return top;
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
        return size() == 0;
    }

    /**
     * 实现 Iterable接口必须实现的方法，返回的是 Iterator实现类
     * 在本实现内容中是内部类
     * @return
     */
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator{

        private int index = size - 1; // 即将遍历的索引位置

        public boolean hasNext() {
            return index >= 0;
        }

        public Object next() {
            return arr[index--];
        }

        public void remove() {
            throw new UnsupportedOperationException(); // 不支持迭代器删除
        }
    }
}
