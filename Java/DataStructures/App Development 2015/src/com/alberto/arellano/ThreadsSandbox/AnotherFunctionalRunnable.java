package com.alberto.arellano.ThreadsSandbox;

import java.util.concurrent.TimeUnit;

/**
 * Created by rome on 11/5/2015.
 */
public class AnotherFunctionalRunnable {

    public static void main(String[] args) {
//
//        Threads can be put to sleep for a certain duration.
//        This is quite handy to simulate long running tasks in
//        the subsequent code samples of this article:
//        Runnable runnable = () -> {
//            try {
//                String name = Thread.currentThread().getName();
//                System.out.println("Foo " + name);
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Bar " + name);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };


        Thread thread = new Thread(() -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Bro Barney");
        thread.start();
    }
}
