package com.basic.Java.threads.callableAndFutures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            Future<String> profileFuture =
                    executor.submit(new UserServiceTask("User profile"));

            Future<String> ordersFuture =
                    executor.submit(new UserServiceTask("Recent orders"));

            Future<String> balanceFuture =
                    executor.submit(new UserServiceTask("Account balance"));

            System.out.println("Tasks submitted.");
            System.out.println("Main thread can do other work here.");

            // Retrieve results
            System.out.println(profileFuture.get());
            System.out.println(ordersFuture.get());
            System.out.println(balanceFuture.get());

        } finally {
            executor.shutdown();
        }
    }
}

