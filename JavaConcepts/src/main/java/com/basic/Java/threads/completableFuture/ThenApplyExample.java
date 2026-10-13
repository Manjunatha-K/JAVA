package com.basic.Java.threads.completableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenApplyExample {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        try {
            CompletableFuture<Integer> monthlySalaryFuture =
                    CompletableFuture.supplyAsync(() -> {
                        System.out.println("Fetching salary on: " + Thread.currentThread().getName()
                        );

                        sleep(2000);
                        return 83000;
                    }, executor);

            CompletableFuture<Integer> annualSalaryFuture =
                    monthlySalaryFuture.thenApply(monthlySalary -> {
                        System.out.println("Calculating annual salary on: " + Thread.currentThread().getName()
                        );

                        return monthlySalary * 12;
                    });

            // Step 3: Main thread can continue doing other work
            System.out.println("Main thread is doing other work");

            // Step 4: Get the final result
            System.out.println("Annual Salary: ₹" + annualSalaryFuture.join()
            );

        } finally {
            executor.shutdown();
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

