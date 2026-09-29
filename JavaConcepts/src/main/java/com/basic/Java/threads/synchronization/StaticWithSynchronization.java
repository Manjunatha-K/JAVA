package com.basic.Java.threads.synchronization;

public class StaticWithSynchronization {
    private static int counter = 0;

    private static synchronized void increment() {
        for (int i = 0; i < 1000; i++)
            counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            increment();
        });

        Thread t2 = new Thread(() -> {
            increment();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter after 2 threads executing and incrementing 2000 times : " + counter);
    }
}
