package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/2/2015.
 */
public class ThreadImplementationRunnable {

    // Another way to execute a thread is through its runnable interface
    // a runnable can be passed to a thread pool for execution while you
    // cannot pass a Thread to a thread pool for execution

    //    When having the Runnable's executed by a thread pool it is easy
    //    to queue up the Runnable instances until a thread from the pool is idle.
    //    This is a little harder to do with Thread subclasses.

    public static class MyRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println("Hello World Runnable");
            // Want to know what thread is executing
            Thread thread = Thread.currentThread();
            thread.getName();
        }
    }

    public static void main(String[] args){
        // You cannot execute a runnable but you can pass it to
        // the Default Thread Constructor like down below
        Thread myThreadWithRunnable = new Thread(new MyRunnable());

        // You can give a name to a thread when you start it and you
        // do it from the constructor
        Thread myThreadWithAlias = new Thread(new MyRunnable(), "Hansol");

        try {

            Thread myThreadRunnableWithNull = new Thread(new MyRunnable(), null);
            myThreadRunnableWithNull.start();
        }catch (Exception ex)
        {
            // Exception in thread "main" java.lang.NullPointerException: name cannot be null
            System.out.println("Can pass a null as a name");
            ex.printStackTrace();

        }

        // This name can be accessed by calling the get method of the thread
        // like so and you can see what thread is executing
        System.out.println(myThreadWithAlias.getName());


        // Don't Forget to start the thread
        myThreadWithRunnable.start();
        myThreadWithAlias.start();
    }
}
