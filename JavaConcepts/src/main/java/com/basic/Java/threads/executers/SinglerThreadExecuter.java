package com.basic.Java.threads.executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglerThreadExecuter {
    public static void main(String[] args) {
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        for (int i =0;i<100;i++){
            int finalI = i;
            singleThread.execute(()->{
                System.out.println("i : "+finalI+" from thread : "+Thread.currentThread().getName());
            });
        }
        for (int i = 100; i < 200; i++) {
            singleThread.execute(new RunnableThread(i));
        }
        singleThread.shutdown();
    }
}
