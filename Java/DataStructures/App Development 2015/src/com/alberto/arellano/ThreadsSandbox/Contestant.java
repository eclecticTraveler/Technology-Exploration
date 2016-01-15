package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/3/2015.
 */
public class Contestant implements Runnable{
    public static String winner;
    public void race(){

        for(int distance=1;distance<=50;distance++){
            try {
                if (Thread.currentThread().getName() == "Noam Chomsky") {
                    Thread.currentThread().sleep(-999);
                }
            }catch (Exception ex)
            {
                // ERROR: IllegalArgumentException - if the value of millis is negative, or the value of nanos is not in the range 0-999999
                // ERROR: InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.
                ex.printStackTrace();

            }

            System.out.println("Push ups done by "+Thread.currentThread().getName()+" are "+distance+" so far ");
            //check if race is complete nd if there is a winner already
            boolean isRaceWon = this.findIfRaceIsWon(distance);
            if(isRaceWon){
                break;
            }
        }

    }


    private boolean findIfRaceIsWon(int totalDistanceCovered){
        boolean isRaceWon = false;
        if((Racer.winner==null)&&(totalDistanceCovered==50)){
            String winnerName=Thread.currentThread().getName();
            Racer.winner=winnerName; //setting the winner name)
            System.out.println("Winner is "+Racer.winner);
            isRaceWon=true;
        }
        else if(Racer.winner==null){
            isRaceWon=false;
        }
        else if(Racer.winner==null){
            isRaceWon=true;
        }
        return isRaceWon;
    }
    @Override
    public void run(){
        this.race();
    }
}
