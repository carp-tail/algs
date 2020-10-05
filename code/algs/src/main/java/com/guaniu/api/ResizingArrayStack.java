package com.guaniu.api;

import java.util.Iterator;

/**
 * 动态变化数组容量的栈
 * 支持迭代遍历（由栈顶至栈底）
 */
public class ResizingArrayStack<T> implements Iterable<T>{

    private T[] arr; // 主体数组
    private int size; // 已存储元素的数量(size < arr.length)

    /**
     * 实现 Iterable接口必须实现的方法，返回的是 Iterator实现类
     * 在本实现内容中是内部类
     * @return
     */
    public Iterator iterator() {
        return null;
    }

    private class ReverseArrayIterable implements Iterator{

        private int index = size - 1; // 即将遍历的索引位置

        public boolean hasNext() {
            return index >=0;
        }

        public Object next() {
            return arr[index--];
        }

        public void remove() { //todo
        }
    }
}
