package com.alberto.arellano.MyHibernateExample;

/**
 * Created by rome on 10/14/2015.
 */

//// @Entity to declare the Telephone class to be a Hibernate entity
//@Entity
//// Associates the Telephone with the telephone table in the DB
//@Table(name = "telephone");
public class Telephone {

    public Telephone(){

    }

    // Getter and Setter for Telephone PK
    public int getTelephonePK() {
        return telephonePK;
    }

    public void setTelephonePK(int telephonePK) {
        this.telephonePK = telephonePK;
    }

    // Getter and Setter for Telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private int telephonePK;
    private String telephone;
}
