package com.madd.samples.thread.executor.custom;

public class Mytask implements Runnable {

    // Method 1 of this class
    // @Override
    public void run() {

        // Try block to check for exceptions
        try {

            // Making thread to pause for a second
            // using sleep() method
            Thread.sleep(1000);
        }

        // Catch block to check for exceptions
        catch (InterruptedException e) {

            // Print the exception scaling ith line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        // Print and display the current thread using
        // currentThread() method by getting thread name
        // using getName() method
        System.out.println(
                "Current Thread :-> "
                        + Thread.currentThread().getName());
    }
}