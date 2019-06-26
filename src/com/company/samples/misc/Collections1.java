package com.company.samples.misc;

import java.util.*;

/**
 * @ClassName Collections1
 * @Description TODO
 * @Author xujianThinkPad
 * @Date 2019/6/20 16:54
 * @ModifyDate 2019/6/20 16:54
 * @Version 1.0
 */
public class Collections1 {

    public static void main(String[] args) {
        List a = new ArrayList();
        List b = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        b.add(2);
        b.add(3);
        b.add(4);

        aMapWithInitialValue();
    }

    /**
     * @title aMapWithInitialValue
     * @description 创建一个待初始化值的map
     * @author 徐健
     * @updateTime 2019/6/26 10:57
     * @throws
     */
    public static void aMapWithInitialValue() {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(){{
            put(1, 1);
            put(2, 2);
        }};
        System.out.println(map);

    }
}