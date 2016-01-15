package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/5/2015.
 */
public class RunnableThreadEx {
    public static void main(String[] args){

//      Before starting a new thread you have to specify the code to be executed by this thread, often called the task.
//      This is done by implementing Runnable - a functional interface defining a single void no-args method run()
//      as demonstrated in the following example:
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task, "Noam Chomsky");
        thread.start();
//        Due to concurrent execution we cannot predict if
//        the runnable will be invoked before or after printing 'done'.
//        The order is non-deterministic, thus making concurrent programming a
//        complex task in larger applications.
        System.out.println("Done!");

    }
}
