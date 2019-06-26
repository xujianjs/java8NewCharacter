package com.company.samples.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Benjamin Winterberg
 */
public class CompletableFuture1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Map> future = new CompletableFuture<>();

        ArrayList<Map> list = new ArrayList<>();
        Map source1=new HashMap<>(1);
        Map source2=new HashMap<>(1);
        Map source3=new HashMap<>(1);
        source1.put("a", 1);
        source2.put("b", 2);
        source3.put("c", 3);
        list.add(source1);
        list.add(source2);
        list.add(source3);

        list.forEach(item -> {
            CompletableFuture<Map> future = new CompletableFuture<>();
            boolean complete = future.complete(item);
            System.out.println(complete);

            future.thenAcceptAsync(last->{

                System.out.println(last);
            });
        });


//        future.complete(source);


//        future
//            .thenAccept(v->System.out.println(v))
//            .thenAccept(System.out::println)
//                .thenAccept(v -> System.out.println("done"));

    }

}
