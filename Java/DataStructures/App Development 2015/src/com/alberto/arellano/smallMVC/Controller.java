package com.alberto.arellano.smallMVC;

/**
 * Created by rome on 10/12/2015.
 */
public class Controller {
    // On the constructor instantiate an instance of Model
    public Controller(){
         myModel = new Model();
    }

    // Middle man method to get the value from View and pass it to the Controller
    public void storeUserValue(int userValue)
    {
        try{

            // Pass information to be stored in the Model
            myModel.setStoredValue(userValue);

            System.out.println("Controller says: information passed to Model successfully");
        }
        catch (Exception e)
        {
            System.out.println("Controller says: ERROR Information could not be passed to Model");
            e.printStackTrace();
        }
    }

    // Pass back data stored by user
    public int obtainUserValue()
    {
        return myModel.getStoredValue();
    }
    // Pass back the variable from Model
    public String obtainBankNumber()
    {
        return myModel.getBankNum();

    }

    // Private Variable Model
    private Model myModel;
}
