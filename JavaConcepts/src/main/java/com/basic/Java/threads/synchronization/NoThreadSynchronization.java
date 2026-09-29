package com.basic.Java.threads.synchronization;

public class NoThreadSynchronization {
    private int counter = 0;

    private void increment() {
        for (int i = 0; i < 1000; i++)
            counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        NoThreadSynchronization obj = new NoThreadSynchronization();
        Thread t1 = new Thread(() -> {
            obj.increment();
        });

        Thread t2 = new Thread(() -> {
            obj.increment();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter after 2 threads executing and incrementing 2000 times : " + obj.counter);
    }
}
