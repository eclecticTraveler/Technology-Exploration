package com.game.view;

public class Time {
    
    public static void waitTime(long millisecond) {
        long max = millisecond;
        
        for(long i = 0; i < max; i++) {
            
            for(long j = 0; j < max; j++) {
                try{

                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
}
