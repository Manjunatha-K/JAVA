package com.basic.Java.threads.ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    List<Integer> sharedBuffer = new ArrayList<>();
    Integer bufferSize = 10;

    public synchronized void producer(Integer i) throws InterruptedException {
        System.out.println("Producer Thread Started");
        while (sharedBuffer.size() == bufferSize) {
            wait();
        }
        System.out.println("Adding an ele into sharedBuffer : "+ i);
        sharedBuffer.add(i);
        notify();
    }

    public synchronized void consumer() throws InterruptedException {
        System.out.println("Consumer Thread Started");
        while (sharedBuffer.isEmpty()) {
            wait();
        }
        System.out.println("Removing the last ele of the collection : " + sharedBuffer.getLast());
        sharedBuffer.remove(sharedBuffer.removeLast());
        notify();
    }
}
