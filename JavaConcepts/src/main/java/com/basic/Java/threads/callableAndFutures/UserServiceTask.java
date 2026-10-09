package com.basic.Java.threads.callableAndFutures;

import java.util.concurrent.Callable;

public class UserServiceTask implements Callable<String> {

    private final String serviceName;

    public UserServiceTask(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String call() throws Exception {
        System.out.println(serviceName + " started on " + Thread.currentThread().getName()
        );
        Thread.sleep(2000);

        return serviceName + " data received";
    }
}

