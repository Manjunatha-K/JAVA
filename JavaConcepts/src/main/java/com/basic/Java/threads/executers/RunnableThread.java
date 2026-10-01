package com.basic.Java.threads.executers;

public class RunnableThread implements Runnable {
    int i;

    public RunnableThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Task : " + i + " is being executed by thread : " + Thread.currentThread().getName());
    }
}
