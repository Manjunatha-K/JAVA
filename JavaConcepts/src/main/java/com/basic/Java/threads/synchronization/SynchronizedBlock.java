package com.basic.Java.threads.synchronization;

public class SynchronizedBlock {
    private int counter = 0;

    private void increment() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++)
                counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock obj = new SynchronizedBlock();
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
