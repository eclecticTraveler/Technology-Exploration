package com.alberto.arellano.ThreadsSandbox;

import java.util.Objects;

/**
 * Created by rome on 11/4/2015.
 */
public class CloningThreadDemo{
//    Threads were never designed to be cloned. Doing some reading sparked off one of the comments I found this summed it up quite well :
//   "But we either have to disallow cloning or give it meaningful semantics - and the latter isn't going to
//    happen." -- David Holmes
    public static void main(String[] args) {
        // Unhandled
        CloningThreadDemo thredToBeCloned = new CloningThreadDemo();
        thredToBeCloned.cloned();
    }

    public CloningThreadDemo cloned()
    {
        try {
            return (CloningThreadDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            //ERROR: Throws CloneNotSupportedException as a Thread can not be meaningfully cloned. Construct a new Thread instead
            e.printStackTrace();
        }
        return null;
    }




}
