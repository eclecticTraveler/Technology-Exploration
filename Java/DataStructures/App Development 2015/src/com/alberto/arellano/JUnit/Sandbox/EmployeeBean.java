package com.alberto.arellano.JUnit.Sandbox;

/**
 * Created by rome on 10/28/2015.
 */
public class EmployeeBean extends PersonBean{
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    private String employeeId;

    public EmployeeBean( String firstName,  String lastName, int age,  String phoneNumber, String employeeId){
        // Make sure to call the PersonBean Constructor
        // Pass the appropriate variables to it
        super(firstName, lastName, age);
        // The rest are ours
        this.phoneNumber = phoneNumber;
        this.employeeId  = employeeId;


    }
}
