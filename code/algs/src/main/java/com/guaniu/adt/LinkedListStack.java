package com.guaniu.adt;

/**
 * 以链表的方式实现栈
 * 每次压栈使用“头插法”添加元素,弹栈删除头结点
 * @param <T>
 */
public class LinkedListStack<T> {

    private Node<T> head; // 链表头结点
    private int size; // 元素的数量

    /**
     * 压栈
     * @param item
     * @return
     */
    public T push(T item){
        Node node = new Node();
        node.item = item;
        node.next = head; // 使用头插法
        head = node;
        size++;
        return item;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop(){
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

//    public Iterator iterator() {
//        return new LinkedListStackIterator();
//    }

//    private class LinkedListStackIterator implements Iterator{
//        private Node node =; // 当前指向的节点
//
//        public boolean hasNext() {
//            return node != null;
//        }
//
//        public Object next() {
//            return null;
//        }
//
//        public void remove() {
//
//        }
//    }
}
