package com.peanut.datastructure;


import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数据
 */
public class DynamicArray implements Iterable<Integer>{


    //逻辑大小
    private int size;

    //容量
    private int capcity = 8 ;

    private int[] array = new int[]{};


    //向最后插入元素
    public void addLast(int element){
        add(size,element);
    }


    //在index 位置插入元素
    public void add(int index, int element){
        checkAndGrow();

        //添加逻辑
        if (index >= 0 && index < size){
            //从array的index位置开始拷贝size-index个元素 到     array的index+1的位置开始
            System.arraycopy(array,index,array,index+1,size - index);
        }
        array[index] = element;
        size++;
    }


    /**
     * 检查 和 扩容
     */
    private void checkAndGrow() {
        //容量检查
        if(size == 0){
            array = new int[capcity];
        }
        else if(size == capcity){
            //进行扩容，新容量是旧容量的 1.5 倍
            capcity += capcity >> 1 ;
            int[] newArray = new int[capcity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }


    /**
     * 移除元素
     * @param index
     * @return
     */
    public int remove (int index){
        int removed = array[index];
        if(index < size -1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }


    /**
     * 查询元素
     * @param index
     * @return
     */
    public int get(int index){
        return array[index];
    }


    //泛型不能使用基本类型  要使用包装类型
    public void forearch(Consumer<Integer> consumer){
        for(int i = 0 ; i < size ; i++){
            consumer.accept(array[i]);
        }
    }


    /**
     * 迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0 ;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }


    /**
     * stream流遍历
     * @return
     */
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }




}
