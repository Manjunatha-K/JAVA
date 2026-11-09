package com.basic.Java.threads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        try {
            CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(userService::getUserDetails, executorService);
            CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(orderService::getOrders, executorService);
            CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(paymentService::getPayments, executorService);

            System.out.println("All tasks submitted.");

            CompletableFuture<Void> allTaskResult = CompletableFuture.allOf(userFuture, orderFuture, paymentFuture);
            allTaskResult.thenRun(() -> {
                System.out.println(userFuture.join());
                System.out.println(orderFuture.join());
                System.out.println(paymentFuture.join());
            });

            allTaskResult.join();
            System.out.println("Dashboard loading completed.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
