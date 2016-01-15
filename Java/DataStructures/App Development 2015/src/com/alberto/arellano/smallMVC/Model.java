package com.alberto.arellano.smallMVC;

/**
 * Created by rome on 10/12/2015.
 */
public class Model {
    // Default Constructor which each class should have
    public Model(){
        // We initialize a variable right off the bat when this class gets instantiated.
        bankNum = "28457413251";
    }

    // Getter for the store value that will be used to displayed what was set by the user
    public int getStoredValue()
    {
        return storedValue;
    }
    // Setter for the store value that will be set by the Controller
    public void setStoredValue(int storedValue)
    {
        try {
            this.storedValue = storedValue;
            System.out.println("Model says: information stored successfully");
        }
        catch (Exception e)
        {
            System.out.println("Model says: ERROR information could not be stored in model");
            e.printStackTrace();
        }
    }
    // Getter for an initialized variable to be displayed
    public String getBankNum() {
        return bankNum;
    }


    private int storedValue;
    private String bankNum;
}
