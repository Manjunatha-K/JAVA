package com.basic.Java.threads;

public class MainThread {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        System.out.println("Main Started");

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    resource.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    resource.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        th1.start();
        System.out.println("Producer Thread Started");
        th2.start();
        System.out.println("Consumer Thread Started");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Ended");

    }
}
