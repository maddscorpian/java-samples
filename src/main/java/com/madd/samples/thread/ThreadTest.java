package com.madd.samples.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =  new LinkedBlockingQueue<>(3);
        ProducerThread producer = new ProducerThread(blockingQueue);
        ConsumerThread consumer = new ConsumerThread(blockingQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();



//        Runnable producer = new ProducerThread(blockingQueue);
//        System.out.println("Starting producer");
//        producer.run();
//        System.out.println("Starting Consumer");
//        Runnable consumer = new ConsumerThread(blockingQueue);
//        consumer.run();

    }
}
