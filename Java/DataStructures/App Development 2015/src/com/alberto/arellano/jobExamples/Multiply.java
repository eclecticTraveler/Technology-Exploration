package com.alberto.arellano.jobExamples;


/**
 * Created by rome on 10/8/2015.
 */
public class Multiply {
    public static void main(String[] args) {
        // For the Column
        for (int i = 1; i <= 12; i++) {
            // For the Row
            for (int j = 1; j <= 12; j++) {
                System.out.print(String.format("%4d", j * i));
            }
            System.out.println();
        }
    }
}
