package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/3/2015.
 */
public class Race {

    public static void main(String[]args){

        Racer racer = new Racer();
        Thread noamThread = new Thread(racer,"Noam");
        Thread emmaThread = new Thread(racer,"Emma");

        //Race to start, tell threads to start
        noamThread.start();
        emmaThread.start();
    }
}
