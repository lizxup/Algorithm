package com.peanut.datastructure;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer> {

    //头指针,指向哨兵节点（value：666，next：null）
    private Node head = new Node(666,null);




    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类 -> 带名字的内部类
        return new NodeIntegerIterator();
    }
    private class NodeIntegerIterator implements Iterator<Integer> {

        Node point = head.next;

        //询问是否有下一个元素
        @Override
        public boolean hasNext() {

            return point != null;

        }

        //返回当前元素的值  并指向下一个元素
        @Override
        public Integer next() {
            int value = point.value;
            point = point.next;

            return value;
        }
    }


    /**
     * 节点类
     */
    private static class Node{

        //值
        int value;

        //下一个节点指针
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 头插法添加
     * @param value
     */
    public void addFirst(int value){
        insert(0,value);
    }


    /**
     * 遍历链表
     */
    public void loop1(Consumer<Integer> consumer){
        Node point = head.next;
        while (point != null){
            consumer.accept(point.value);
            point = point.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for(Node point = head.next ; point != null ; point=point.next){
            consumer.accept(point.value);
        }
    }


    /**
     * 寻找尾节点
     */
    private Node findLast(){
        Node point =head ;
        while(point.next != null){
            point = point.next;
        }
        return point;
    }

    /**
     * 尾插入法
     */
    public void addLast(int value){
        Node node = findLast();
        node.next = new Node(value,null);
    }


    /**
     * 根据index 查找节点
     */
    private Node findNode(int index){
        int i = -1 ;
        for(Node point = head.next ; point!=null ; point = point.next,i++){
            if(i == index){
                return point;
            }
        }
        return null;
    }


    //根据index 查找值
    public int get(int index){
        Node node = findNode(index);
        if (node == null){
            throw illegalIndex(index);
        }
        return node.value;
    }


    /**
     * 向索引位置插入
     */
    public void insert(int index,int value){
        Node insertPoint = findNode(index-1);
        if (insertPoint == null){
            throw illegalIndex(index);
        }
        Node node = new Node(value,insertPoint.next);
        insertPoint.next = node;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }


    /**
     * 删除第一个元素
     */
    public void removeFirst(){
        if (head == null){
            throw illegalIndex(0);
        }
        head = head.next;
    }


    /**
     * 根据索引index删除节点
     * @param index
     */
    public void remove(int index){

        Node prev = findNode(index-1);

        //找不到需要删除节点的前一个节点
        if (prev == null){
            throw illegalIndex(index);
        }
        Node point = prev.next;

        //需要删除的节点的前一个节点找到了 ，需要删除的节点没有找到
        if(point == null ){
            throw illegalIndex(index);
        }
        prev.next = point.next;
    }


}


