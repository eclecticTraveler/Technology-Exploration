package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/5/2015.
 */
public class FunctionalImplementationOfRunnable {


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

//            Since Runnable is a functional interface we can utilize Java 8 lambda
//            expressions to print the current threads name to the console.
//            First we execute the runnable directly on the main thread before starting a new thread.
            Runnable task = () -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            };

            task.run();
            // You cannot execute a runnable but you can pass it to
            // the Default Thread Constructor like down below
            Thread myThreadWithRunnable = new Thread(task, "Alberto's Task");

            // You can give a name to a thread when you start it and you
            // do it from the constructor
            Thread myThreadWithAlias = new Thread(new MyRunnable(), "Hansol");



            // This name can be accessed by calling the get method of the thread
            // like so and you can see what thread is executing
            System.out.println(myThreadWithAlias.getName());


            // Don't Forget to start the thread
            myThreadWithRunnable.start();
            myThreadWithAlias.start();
        }


}
