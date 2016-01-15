package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/2/2015.
 */
public class ThreadsInteraction {

    public static void main(String[] args)
    {
        // One way of creating it
        MyThread aThread = new MyThread();

        // Another name of assigning it a name
        aThread.setName("Thread Alpha");
        aThread.start();

        // Instance of Thread with Runnable
        MySecondThread mainThreadWithRunner = new MySecondThread();
        // Passing it thread to main thread
        Thread normalThread = new Thread(mainThreadWithRunner);

        // Create other 3 Threads
        Thread normalThread2 = new Thread(mainThreadWithRunner);
        Thread normalThread3 = new Thread(mainThreadWithRunner);
        Thread normalThread4 = new Thread(mainThreadWithRunner);
        Thread normalThread5 = new Thread(mainThreadWithRunner);

        // Start them
        normalThread.start();
        normalThread2.start();
        normalThread3.start();
        normalThread4.start();
        normalThread5.start();
        try {
            normalThread.interrupt();
        }catch (Exception e)
        {
            // ERROR: java.lang.InterruptedException: sleep interrupted
            // sleep interrupted
            System.out.println("Thread Interrupted");
            e.printStackTrace();
        }
        try{
            normalThread5.destroy();
        }catch (Exception ex)
        {
//            That means you shouldn't be using it in new code typically
//            because it is dangerous, or because a better alternative exists.
//            Compilers warn when a deprecated program element is used or
//            overridden in non-deprecated code.
            System.out.println("There are better ways, too dangerous");
            ex.printStackTrace();
        }

    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println("Executing");
    }
}

class MySecondThread implements Runnable{
    @Override
    public synchronized void run(){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + "Thread is Running");
    }

}

