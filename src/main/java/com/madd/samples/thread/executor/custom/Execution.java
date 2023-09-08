package com.madd.samples.thread.executor.custom;

public class Execution implements Runnable {

    public void run() {

        // Till it is true
        while (true) {

            // Here we are fetching the tasks from the
            // linkedblocking queue
            // which we have submitted using execute method
            // and executing them
            if (MyThreadPool.linkedTaskBlockingQueue.size()
                    != 0) {
                MyThreadPool.linkedTaskBlockingQueue.poll()
                        .run();
            }
        }
    }

    void executeMyMethod() {

        // At start the current capacity will be 0
        // The another capacity is the number of threads we
        // want to create so we will increase the current
        // capacity count after creating each thread it
        // means that we will create the threads if the
        // current capacity is less than capacity passed by
        // us i.e number of threads we want to create.

        // In this case 3 threads will get created
        if (MyThreadPool.currentCapacity
                < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;

            // Creating object of Thread class
            Thread t = new Thread(new Execution());

            // Starting the thread
            t.start();
        }
    }
}
