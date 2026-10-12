package com.basic.Java.threads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {
        ExecutorService threads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            CompletableFuture<String> customerData = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                    return "Customer data";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, threads);

            CompletableFuture<String> orderData = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1500);
                    return " Order Data";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, threads);

            CompletableFuture<String> dashboard = customerData.thenCombine(orderData, (customer, order) ->
                    customer + " --- " + order
            );

            System.out.println(dashboard.join());
        } finally {
            threads.shutdown();
        }
    }

}
