package com.alberto.arellano.Testing;

/**
 * Created by rome on 10/29/2015.
 */
public class ProfessorBean extends PersonBean {
    private String specialty;
    private String phoneExtention;

    public ProfessorBean(String name, String last, int age, String specialty, String phoneExtention){
        super(name, last, age);
        this.specialty = specialty;
        this.phoneExtention = phoneExtention;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneExtention() {
        return phoneExtention;
    }

    public void setPhoneExtention(String phoneExtention) {
        this.phoneExtention = phoneExtention;
    }
}
