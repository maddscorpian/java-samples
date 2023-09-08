package com.madd.samples.thread.executor.custom;

public class MyExecutors {

    // Passing the number of threads that
    // will be in the thread pool
    static MyExecutorService
    myNewFixedThreadPool(int capacity) {

        return new MyThreadPool(capacity);
    }
}
