package com.alberto.arellano.jobExamples;

/**
 * Created by rome on 11/16/2015.
 */
public class SwapTwoStringsWithoutThreeVars {

    public static void main(String[] args)
    {
        String a="Alberto";
        String b="Israel";

        a= a+b;
        b = a.substring(0,(a.length()-b.length()));
        a = a.substring(b.length(),(a.length()));

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
