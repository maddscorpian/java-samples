package com.madd.samples.thread;

import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class ProducerThread implements Runnable {

    BlockingQueue<String> queue = null;

    ProducerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            long ts = System.currentTimeMillis();
            try {
                this.queue.put(ts + "hi");
            } catch (InterruptedException e) {
                System.out.println("Something went wrong in ProducerThread");
            }
            System.out.println("I am ProducerThread");

            sleep(1000);
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong in ProducerThread.sleep");
        }
    }
}
