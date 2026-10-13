package com.basic.Java.threads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenComposeExample {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        try {
            CompletableFuture<Integer> yearsFuture =
                    CompletableFuture.supplyAsync(() -> {
                        System.out.println(
                                "Fetching years of service: "
                                        + Thread.currentThread().getName()
                        );

                        sleep(1000);
                        return 20;
                    }, executor);

            CompletableFuture<String> benefitFuture =
                    yearsFuture.thenCompose(years -> {
                        System.out.println(
                                "Years of service: " + years
                        );

                        return fetchBenefitDetails(years, executor);
                    });

            System.out.println("Benefit Details: " + benefitFuture.join());

        } finally {
            executor.shutdown();
        }
    }

    private static CompletableFuture<String> fetchBenefitDetails(
            int years, ExecutorService executor) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching benefits: " + Thread.currentThread().getName()
            );

            sleep(1500);

            if (years >= 15) {
                return "Eligible for long-service benefits";
            }

            return "Eligible for standard benefits";

        }, executor);
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
