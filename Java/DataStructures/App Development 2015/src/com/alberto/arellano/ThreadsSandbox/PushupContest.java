package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/3/2015.
 */
public class PushupContest {
    public static void main(String[]args) {
        Contestant contestant = new Contestant();
        Thread barneyThread = new Thread(contestant, "Bro Barney");
        Thread albertoThread = new Thread(contestant, "Alberto");
//        Thread noamChomskyThread = new Thread(contestant, "Noam Chomsky");
//        Thread emmaGoldmanThread = new Thread(contestant, "Emma Goldman");

        try {
            Thread anonymusContestantThread = new Thread(contestant, null);
            anonymusContestantThread.start();
        }
        catch (Exception e)
        {
            // ERROR: java.lang.NullPointerException: name cannot be null
            e.printStackTrace();
            System.out.println("Cannot pass null");
        }


        // Want to make Bro Barney win every time you set its priority to maximum
        // Default The default priority that is assigned to a thread.
        barneyThread.setPriority(barneyThread.MAX_PRIORITY);

        //Race to start, tell threads to start
        barneyThread.start();
        albertoThread.start();
//        noamChomskyThread.start();
//        emmaGoldmanThread.start();

    }
}
