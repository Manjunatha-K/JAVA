package com.basic.Java.threads;

public class ThreadClass extends Thread{
    @Override
    public void run(){
        System.out.println("Thread : "+ Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ThreadClass thread1 = new ThreadClass();
        thread1.setName("Thread-1");
        System.out.println("in main() : Before calling Thread - 1");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("in main() : After calling Thread - 1");
        ThreadClass thread2 = new ThreadClass();
        thread2.setName("Thread-2");
        System.out.println("in main() : Before calling Thread 2 start method");
        thread2.start();
        System.out.println("in main() : After calling thread-2 start method but before join() method ");
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("in main() : After calling Thread-2 join method ");
    }
}
