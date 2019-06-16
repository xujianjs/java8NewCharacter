package com.company.samples.misc;


/**
 * java中有三种移位运算符
 *
 * <<      :     左移运算符，num << 1,相当于num乘以2
 *
 * >>      :     右移运算符，num >> 1,相当于num除以2
 *
 * >>>    :     无符号右移，忽略符号位，空位都以0补齐
 *
 * description  移位操作
 * @author xujianghrx@gmail.com
 * @version 1.0
 * @date 2019/6/16 10:01 
 * @className Shift1
 */
public class Shift1 {

  public static void main(String[] args) {

    int src = 10;
    int left = src << 1;
    int right = left >> 1;
    printBinaryInfo(src);
    printBinaryInfo(left);
    printBinaryInfo(right);

    AndOper();

  }

  /*
   * description  &0xff
   * 记得在学计算机原理的时候，了解到计算机内的存储都是利用二进制的补码进行存储的。
   * 原码反码补码这三个概念
   * 对于正数（00000001）原码来说，首位表示符号位，反码 补码都是本身
   * 对于负数（100000001）原码来说，反码是对原码除了符号位之外作取反运算即（111111110），补码是对反码作+1运算即（111111111）
   * 当byte要转化为int的时候，高的24位必然会补1，这样，其二进制补码其实已经不一致了，&0xff可以将高的24位置为0，低8位保持原样。这样做的目的就是为了保证二进制数据的一致性
   * @param
   * @return void
   * @date 2019/6/16 10:29
   * @author xujianghrx@gmail.com
   */
  private static void AndOper() {
    byte[] a = new byte[10];
    a[0]= -127;
    printBinaryInfo(a[0]);
    int c = a[0]&0xff;
    printBinaryInfo(0xff);
    printBinaryInfo(c);
  }


  /*
 * @param       input
 * @return void
 * @date 2019/6/16 10:19
 * @author xujianghrx@gmail.com
 */
  private static void printBinaryInfo(int input) {
    System.out.printf("输入十进制数：%d，对应二进制为：%s",input,Integer.toBinaryString(input));
    System.out.println();

  }


}
