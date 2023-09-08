package com.madd.samples.thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable {

    BlockingQueue<String> queue = null;

    ConsumerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = this.queue.take();
                System.out.println(String.format("Consuming %s", message));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
