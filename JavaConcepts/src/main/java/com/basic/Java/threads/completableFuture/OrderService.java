package com.basic.Java.threads.completableFuture;

public class OrderService {
    public String getOrders() {
        System.out.println("Fetching orders: " + Thread.currentThread().getName());
        sleep(2000);
        return "Orders: Laptop, Mobile";
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
