package com.company.samples.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * @author 徐健
 * @version 1.0.0
 * @ClassName Stream14.java
 * @Description TODO
 * @createTime 2019年06月26日 11:15:00
 */
public class Stream14 {
    public static void main(String[] args) {
        test2();

    }

    public static void test1() {
        Random random = new Random();
        //stream是无限的  需要通过limit方法减少( 限制 ) 流中的元素数量
        random.ints().limit(2).forEach(System.out::println);

        int asInt = random.ints().limit(10).max().getAsInt();
        System.out.println(asInt);
    }

    public static void test2() {
        randomName();

    }

    /**
     * @title randomName
     * @description 生成随机姓名
     * @author 徐健
     * @updateTime 2019/6/26 11:42
     * @throws
     */
    private static void randomName() {
        List<String> nameList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "/", "[", "]", ";", ",", "<", ">", "_", "-", "=", "+");
        //利用java包自带的shuffle打乱nameList顺序
        Collections.shuffle(nameList);
        String randomName = nameList.parallelStream().limit(10).unordered().collect(Collectors.joining());
        System.out.println(randomName);
    }
}
