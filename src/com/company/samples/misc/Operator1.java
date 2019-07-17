package com.company.samples.misc;

import org.junit.Test;

/**
 * @author 徐健
 * @version 1.0.0
 * @ClassName Operator1.java
 * @Description 运算操作符
 * @createTime 2019年07月17日 11:06:00
 */
public class Operator1 {

    @Test
    public void test1() {
        int hash = 5;
        int length = (int) Math.pow(2, 5);

        // & 按位与
        // m & (2的n次方-1)的按位与运算结果
        int result=hash & (length-1);

        System.out.println(result);
    }
}
