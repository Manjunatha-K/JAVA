package com.basic.Java.threads.callableAndFutures;

import java.util.concurrent.Callable;

public class CallableThread implements Callable {
    private int number;

    public CallableThread(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println(
                "Calculating " + number +
                        " on " +
                        Thread.currentThread().getName()
        );

        Thread.sleep(2000);

        return number * number;
    }
}
