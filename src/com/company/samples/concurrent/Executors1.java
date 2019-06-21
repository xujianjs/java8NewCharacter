package com.company.samples.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Benjamin Winterberg
 */
public class Executors1 {

    public static void main(String[] args) {
        test1(3);
//        test1(7);
    }

    private static void test1(long seconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: " + name);
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });
        stop(executor);
    }

    static void stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            //* Blocks until all tasks have completed execution after a shutdown
            //     * request, or the timeout occurs, or the current thread is
            //     * interrupted, whichever happens first.
            executor.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
