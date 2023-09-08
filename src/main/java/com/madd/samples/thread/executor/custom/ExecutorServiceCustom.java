package com.madd.samples.thread.executor.custom;

public class ExecutorServiceCustom {
    public static void main(String[] args) {
        // Getting the object of MyExcutorService by using
        //  the factory method myNewFixedThreadPool

        // Passing number of threads as 3
        MyExecutorService service
                = MyExecutors.myNewFixedThreadPool(3);

        for (int i = 0; i < 20; i++) {

            // Creating 20 tasks and passing them to execute
            service.execute(new Mytask());
        }
    }
}
