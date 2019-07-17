package com.company.samples.lowVersion;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author 徐健
 * @version 1.0.0
 * @ClassName EnhancedForLoop.java
 * @Description 增强for循环
 * @createTime 2019年07月17日 14:29:00
 */
public class EnhancedForLoop {

    @Test
    public void test1() {
//        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> list = null;

        //list is null then produce NPE
        for (Object o : list) {
            System.out.println(o.hashCode());
        }
    }
}
