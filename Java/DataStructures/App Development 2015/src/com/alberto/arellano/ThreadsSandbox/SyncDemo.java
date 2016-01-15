package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/4/2015.
 Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors:
 if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods. (An important exception:
 final fields, which cannot be modified after the object is constructed, can be safely read through non-synchronized methods, once the object is constructed).


 */
public class SyncDemo {
private static int count = 0;

    public static synchronized void inCount(){
        // The keyword Synchronized will make it
        // So that the bottle neck goes away and
        // allows only one to access it at a time

        // In java every obj has its intrinsic lock
        // it locks the access until and unless does the operation
        // and can be access by one thread at a time
        // if two threads want to access one has to wait
        // So the Sync calls the lock in background
        // So allows the variable to
        count ++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    count++;
                    inCount();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    count++;
                    inCount();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            //Java Thread J
            // oin method can be used to pause the current thread execution until
            // and unless the specified thread is dead
            // join makes the thread to finish or o die when the other thread has caught up to
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        // Now I would hope that the result is 20000 because we go up to 10000 for both Threads
        // But the problem is that both threads are trying to access the same variable and that
        // is a bottle neck so one will win the other one won't, to solve this I used the keyword
        // Syncronize
        System.out.println("value : " + count);
    }
}
