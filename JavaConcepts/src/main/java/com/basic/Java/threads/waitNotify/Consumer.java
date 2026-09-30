package com.basic.Java.threads.waitNotify;

import java.util.Queue;

public class Consumer {

    public static void consume(Queue<Integer> list)
            throws InterruptedException {

        synchronized (list) {
            while (list.isEmpty()) {
                list.wait();
            }
            System.out.println("Polling element from the queue : "
                    + list.poll());

            list.notify();
        }
    }
}