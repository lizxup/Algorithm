package com.peanut.datastructure;


import java.util.Iterator;

//双向链表（带哨兵）
public class DoublyLinkedListSentinel implements Iterable<Integer>{



    static class Node{

        //上一个节点
        Node prev;

        int value;

        //下一个节点
        Node next;

        public Node(Node prev,int value ,Node next ){
            this.next = next;
            this.value = value;
            this.next = next;
        }
    }


    //头哨兵 index为-1
    private Node head;


    //尾哨兵
    private Node tail;

    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,888,null);
        head.next = tail;
        tail.prev = head;
    }


    /**
     * 根据index寻找节点
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i = -1;
        for(Node point = head; point != tail ; point = point.next , i++){
            if (i == index){
                return point;
            }
        }
        return null;
    }

    /**
     * 在双向链表的头部添加节点
     * @param value
     */
    public void addFirst(int value){
        insert(0,value);
    }

    /**
     * 在双向链表的头部删除节点
     */
    public void removeFirst(){
        remove(0);
    }


    /**
     * 在双向链表的尾部添加节点
     * @param value
     */
    public void addLast(int value){
        Node prev = tail.prev;
        Node node = new Node(prev,value,tail);
        tail.prev = node;
        prev.next = node;
    }

    /**
     * 在双向链表的尾部删除节点
     */
    public void removeLast(){
        Node removed = tail.prev;
        Node prev = removed.prev;
        //当双向链表为空的时候 prev 为head  报错
        if(prev == head){
            throw illegalIndex(0);
        }
        prev.next = tail;
        tail.prev = prev;
    }


    /**
     * 根据index ，value 插入新节点
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        //找上一个节点
        Node prev = findNode(index-1);
        //如果prev查找不到
        if(prev == null){
            throw illegalIndex(index);
        }

        //找下一个节点
        Node next = prev.next;

        //建立插入节点
        Node node = new Node(prev,value,next);

        //修改后一个节点的prev指针
        next.prev = node;
        //修改后一个节点的next指针
        prev.next = node;

    }


    /**
     * 根据index删除节点
     * @param index
     */
    public void remove(int index){
        //找到前一个节点
        Node prev = findNode(index-1);

        //如果index的大小 > 双向链表的长度  或者 要删除的节点为头节点
        if (prev == null){
            throw illegalIndex(index);
        }

//        当前需要删除的节点
        Node removed = prev.next;

        //要删除的节点为尾节点tail
        if (removed == tail){
            throw illegalIndex(index);
        }

        //要删除节点的下一个节点
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }


    /**
     * 实现forEach循环的迭代器
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node point = head.next;
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public Integer next() {
                int value = point.value;
                point = point.next;
                return value;
            }
        };
    }



    /**
     * 抛出的异常
     * @param index
     * @return
     */
    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }
}
