package com.company.samples.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Benjamin Winterberg
 */
public class Threads1 {

    public static void main(String[] args) {
        test0();
//        test1();
//        test2();
//        test3();
    }

    private static void test3() {
        Runnable runnable = () -> {
            try {
                System.out.println("Foo " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void test2() {
        Runnable runnable = () -> {
            try {
                System.out.println("Foo " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Bar " + Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void test1() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Done!");
    }

    private static void test0(){
        //定义线程该做的工作，一般命名为task
        Runnable task=()->{
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("Foo " + threadName);
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Bar " + threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //主线程调用run
        //run只是Runnable的一个普通方法  主线程调用会阻塞执行
        task.run();
        task.run();

        //只有Thread才会真正启动多线程
        Thread thread = new Thread(task);
        //start启动之后会触发run
        thread.start();
        System.out.println("done!");
    };
}
