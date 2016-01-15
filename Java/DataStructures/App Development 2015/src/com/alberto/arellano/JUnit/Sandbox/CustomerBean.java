package com.alberto.arellano.JUnit.Sandbox;

/**
 * Created by rome on 10/28/2015.
 */
public class CustomerBean extends PersonBean {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerBean(String firstName,  String lastName, int age, String phoneNumber){
        // Make sure to call the PersonBean Constructor
        // Pass the appropriate variables to it
        super(firstName, lastName, age);
        this.phoneNumber = phoneNumber;
    }


}
