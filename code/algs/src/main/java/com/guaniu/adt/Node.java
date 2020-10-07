package com.guaniu.adt;

/**
 * 链表节点
 * @param <T> 节点元素参数化类型
 */
public class Node<T> {
    public T item;
    public Node next;

    public Node(T item){
        this(item, null);
    }

    public Node(T item, Node next){
        this.item = item;
        this.next = next;
    }

    public Node() {

    }
}
