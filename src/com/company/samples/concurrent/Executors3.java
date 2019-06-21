package com.company.samples.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Benjamin Winterberg
 */
public class Executors3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        test1();
//        test2();
        test3();

//        test4();
//        test5();
    }

    private static void test5() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);

        executor.shutdown();
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    private static void test4() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        executor.shutdown();
    }

    private static void test3() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        //Creates and executes a periodic action that becomes enabled first
        //     * after the given initial delay, and subsequently with the
        //     * given delay between the termination of one execution and the
        //     * commencement of the next.  If any execution of the task
        //     * encounters an exception, subsequent executions are suppressed.
        //     * Otherwise, the task will only terminate via cancellation or
        //     * termination of the executor.
        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    private static void test2() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        int initialDelay = 0;
        int period = 1;
        //为了调度任务持续的执行，executors 提供了两个方法scheduleAtFixedRate()和scheduleWithFixedDelay()。第一个方法用来以固定频率来执行一个任务
        //Creates and executes a periodic action that becomes enabled first
        //     * after the given initial delay, and subsequently with the given
        //     * period; that is executions will commence after
        //     * {@code initialDelay} then {@code initialDelay+period}, then
        //     * {@code initialDelay + 2 * period}, and so on.
        //     * If any execution of the task
        //     * encounters an exception, subsequent executions are suppressed.
        //     * Otherwise, the task will only terminate via cancellation or
        //     * termination of the executor.  If any execution of this task
        //     * takes longer than its period, then subsequent executions
        //     * may start late, but will not concurrently execute.
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    private static void test1() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println(Thread.currentThread().getName()+"=》Scheduling: " + System.nanoTime());
        int delay = 3;
        ScheduledFuture<?> future = executor.schedule(task, delay, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf(Thread.currentThread().getName()+"=》Remaining Delay: %sms\n", remainingDelay);
    }

}
