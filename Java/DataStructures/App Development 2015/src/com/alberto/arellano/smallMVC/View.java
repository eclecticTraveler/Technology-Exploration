package com.alberto.arellano.smallMVC;

/**
 * Created by rome on 10/12/2015.
 */
public class
        View {
    public static void main(String[] args){
        // Representation of data that will be stored and retrieved
        int userValue = 5;
        int userStoredValue = 0;
        String bankNumber;

        // Create Instance of Controller so that I can have access to all its methods
        Controller myController = new Controller();

        // Pass to the controller userValue which will be later passed by the Controller to the Model
        try{
            myController.storeUserValue(userValue);
            System.out.print("View says: User value passed to Controller successfully");
        }
        catch (Exception e)
        {
            System.out.print("View says:  ERROR User Data could not be passed to controller");
            e.printStackTrace();
        }

        // If userValue was stored correctly then when I retrieve the data will be not be show 0 rather 5
        try{

            userStoredValue = myController.obtainUserValue();
            System.out.println("The stored value is " + userStoredValue);

        }
        catch (Exception e)
        {
            System.out.print("View says:  ERROR User Data could not be RETRIEVED to controller");
            e.printStackTrace();
        }

        // Request of information already stored in the Model that will be handed by me by the Controller
        try{
            bankNumber = myController.obtainBankNumber();
            System.out.println("The bank number stored is " + bankNumber);
        }
        catch (Exception e)
        {
            System.out.println("View says: ERROR could not RETRIEVE bankInfo from Controller");
            e.printStackTrace();
        }
    }
}
