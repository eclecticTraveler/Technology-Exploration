package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/2/2015.
 */
public class ThreadExperimentation {

    public  static class MyThread extends Thread{

        // Overriding the method run from the superclass so that
        // it knows what to execute
        @Override
        public void run(){
            System.out.println("Hello World");
        }
    }

    // Start a simple thread that will finish immediately
    public static  void main(String[] args) {
        // Creating a new Thread but if you want to run the overidden version of the
        // Thread class you need now to use the new one so

        // Before
        Thread aThread = new Thread();
        // After
        Thread myThread = new MyThread();

        // Start the thread by using
        myThread.start();
        try {
            // If you start it again
            // ERROR: Exception in thread "main" java.lang.IllegalThreadStateException
            myThread.start();
        }catch (Exception e)
        {
            // ERROR: Exception in thread "main" java.lang.IllegalThreadStateException
            e.printStackTrace();
            System.out.println("You cannot start the thread again");

        }
    }
}
