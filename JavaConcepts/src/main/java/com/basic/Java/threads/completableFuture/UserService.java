package com.basic.Java.threads.completableFuture;

public class UserService {

    public String getUserDetails() {
        System.out.println("Fetching user details: " + Thread.currentThread().getName());
        sleep(2000);
        return "User: Manjunath";
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
