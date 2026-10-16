package com.basic.Java.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapDemo {

    public static void main(String[] args)
            throws InterruptedException {

        ConcurrentHashMap<String, Integer> counts =
                new ConcurrentHashMap<>();

        ExecutorService executor =
                Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100_000; i++) {
            executor.submit(() ->
                    counts.merge("SUCCESS", 1, Integer::sum)
            );
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(counts.get("SUCCESS"));
    }
}
