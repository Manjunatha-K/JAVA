package com.basic.Java.threads.executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecuter {
    public static void main(String[] args) {
        ExecutorService fixedThreads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 5);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            fixedThreads.execute(() -> {
                System.out.println("i : " + finalI + " from thread : " + Thread.currentThread().getName());
            });
        }
        for (int i = 100; i < 200; i++) {
            fixedThreads.execute(new RunnableThread(i));
        }
        fixedThreads.shutdown();
    }
}
