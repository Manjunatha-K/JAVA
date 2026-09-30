package com.basic.Java.threads.waitNotify;

import java.util.Queue;

public class Producer {

    public static void produce(Queue<Integer> list, int value)
            throws InterruptedException {
        synchronized (list) {
            while (list.size() == 10) {
                list.wait();
            }
            System.out.println("Inserting into queue : " + value);
            list.offer(value);
            list.notify();
        }
    }
}