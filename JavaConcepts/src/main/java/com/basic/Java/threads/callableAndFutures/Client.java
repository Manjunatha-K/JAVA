package com.basic.Java.threads.callableAndFutures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        CallableThread thread1 = new CallableThread(10);
        CallableThread thread2 = new CallableThread(20);
        CallableThread thread3 = new CallableThread(30);
        CallableThread thread4 = new CallableThread(40);
        CallableThread thread5 = new CallableThread(50);

        Future<Integer> task1 = threads.submit(thread1);
        Future<Integer> task2 = threads.submit(thread2);
        Future<Integer> task3 = threads.submit(thread3);
        Future<Integer> task4 = threads.submit(thread4);
        Future<Integer> task5 = threads.submit(thread5);

        System.out.println("All tasks submitted");
        System.out.println("Task - 1 : "+task1.get());
        System.out.println("Task - 2 : "+task2.get());
        System.out.println("Task - 3 : "+task3.get());
        System.out.println("Task - 4 : "+task4.get());
        System.out.println("Task - 5 : "+task5.get());

        threads.shutdown();
    }
}
