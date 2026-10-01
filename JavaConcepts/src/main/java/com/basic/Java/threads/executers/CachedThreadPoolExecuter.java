package com.basic.Java.threads.executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecuter {
    public static void main(String[] args) {
        ExecutorService cachedThreads = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            cachedThreads.execute(() -> {
                System.out.println("i : " + finalI + " from thread : " + Thread.currentThread().getName());
            });
        }
        for (int i = 100; i < 200; i++) {
            cachedThreads.execute(new RunnableThread(i));
        }
        cachedThreads.shutdown();
    }
}
