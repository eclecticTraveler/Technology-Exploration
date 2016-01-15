package com.alberto.arellano.ThreadsSandbox;

/**
 * Created by rome on 11/4/2015.
 */
// implement and override Cloneable interface
public class ClonedHandledEx  implements Cloneable{
    //    Threads were never designed to be cloned. Doing some reading sparked off one of the comments I found this summed it up quite well :
//   "But we either have to disallow cloning or give it meaningful semantics - and the latter isn't going to
//    happen." -- David Holmes
    public static void main(String[] args) {
//        // Unhandled
//        CloningThreadDemo t = new CloningThreadDemo();
//        t.cloned();

        try {
            ClonedHandledEx secondObject = new ClonedHandledEx();
            ClonedHandledEx clonedObj = (ClonedHandledEx) secondObject.clone();
        }catch (CloneNotSupportedException e)
        {
            //ERROR: Throws CloneNotSupportedException as a Thread can not be meaningfully cloned. Construct a new Thread instead
            e.printStackTrace();
            System.out.println("Ye shall not clone like this either");
        }
    }


    /**
     * Throws CloneNotSupportedException as a Thread can not be meaningfully
     * cloned. Construct a new Thread instead.
     *
     * @throws  CloneNotSupportedException
     *          always
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return (ClonedHandledEx) super.clone();
        }catch (CloneNotSupportedException ex)
        {
            System.out.println("Never clone Threads");
            ex.printStackTrace();
        }
        return null;
    }

}
