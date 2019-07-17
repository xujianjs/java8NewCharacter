package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<Object, String> map = new HashMap<>();
        map.put(1, "1a");
        map.put(2, "2b");
        List<Integer> keys = Arrays.asList(1, 2);
        keys.forEach(key->{
            map.computeIfPresent(key, (k, v) -> k + v);
        });
        System.out.println(map);

    }
}
