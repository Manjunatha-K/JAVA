package com.basic.Java.threads.completableFuture;

public class PaymentService {
    public String getPayments() {

        System.out.println("Fetching payments: " + Thread.currentThread().getName());
        sleep(2000);
        return "Payments: Successful";
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
