package com.guaniu.adt;


/**
 * 数组实现的固定初始化容量的栈
 * @param <T> 参数化类型
 */

public class FixedCapacityStack<T> {
    private T[] arr; // 主体数组
    private int size; // 已存储元素的数量(size < arr.length)

    public FixedCapacityStack(int initCapicity) {
//        arr = new T[initCapicity]; 不允许
        arr = (T[]) new Object[initCapicity];
    }

    /**
     * 元素压栈
     * @param item
     * @return
     */
    public T push(T item){
        arr[size++] = item;
        return item;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        T top = arr[--size];
        arr[size + 1] = null; // 避免对象游离
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
        return size == 0;
    }

    /**
     * 栈是否已满
     * @return
     */
    public boolean isFull(){
        return size == arr.length;
    }

}
