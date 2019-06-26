package com.company.samples.lowVersion;


import java.util.*;

/**
 * ArrayList
 * public class ArrayList<E> extends AbstractList<E>
 *         implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 *         ArrayList实现了标记接口：RandomAccess
 *
 * LinkedList
 * public class LinkedList<E>
 *     extends AbstractSequentialList<E>
 *     implements List<E>, Deque<E>, Cloneable, java.io.Serializable
 *     LinkedList未实现RandomAccess接口
 *
 *     猜想：RandomAccess作用，用来帮助提高算法性能的
 *     理由：ArrayList底层是基于数组实现；LinkedList是基于链表；而数组的特点是查询快，增删慢；链表的特点是查询慢，增删快
 *     思考:实现了RandomAccess的接口，是为了提供随机访问能力的，也就是查询用。有了这个能力就要用起来。我们肯定得善于用其长处，规避其短处
 *     做法：例证==对实现了RandomAccess接口的对象遍历采用for循环，未实现接口的采用迭代（利用instance of就可以判断是否实现改接口 ）
 */
public class RandomAccessTimeTest {

    //使用for循环遍历
    public static long traverseByLoop(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < list.size();i++){
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    //使用迭代器遍历
    public static long traverseByIterator(List list){
        Iterator iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (iterator.hasNext()){
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public static void main(String[] args) {
        //加入数据
        List<String> arrayList = new ArrayList<>();
        for (int i = 0;i < 30000;i++){
            arrayList.add("" + i);
        }
        long loopTime = RandomAccessTimeTest.traverseByLoop(arrayList);
        long iteratorTime = RandomAccessTimeTest.traverseByIterator(arrayList);
        System.out.println("ArrayList:");
        System.out.println("for循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);

        List<String> linkedList = new LinkedList<>();
        //加入数据
        for (int i = 0;i < 30000;i++){
            linkedList.add("" + i);
        }
        loopTime = RandomAccessTimeTest.traverseByLoop(linkedList);
        iteratorTime = RandomAccessTimeTest.traverseByIterator(linkedList);
        System.out.println("LinkedList:");
        System.out.println("for循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);
    }
}
