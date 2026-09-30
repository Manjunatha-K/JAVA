package com.basic.Java.threads.waitNotify;

import java.util.LinkedList;
import java.util.Queue;

import static com.basic.Java.threads.waitNotify.Producer.produce;

public class Client {

    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        Thread producer = new Thread(() -> {
            int counter = 0;
            while (true) {
                counter++;

                try {
                    produce(list, counter);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Consumer.consume(list);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        producer.start();
        consumer.start();
    }
}