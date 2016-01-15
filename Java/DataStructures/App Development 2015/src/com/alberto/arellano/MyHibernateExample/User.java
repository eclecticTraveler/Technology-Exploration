package com.alberto.arellano.MyHibernateExample;

/**
 * Created by rome on 10/14/2015.
 */

// @Entity to declare the User class to be a Hibernate entity
//@Entity
//// Associates the User with the user table in the DB
//@Table(name = "user");
public class User {

    public  User(){

    }

    // Getter and Setter for PK
    public int getUserPK() {
        return userPK;
    }

    public void setUserPK(int userPK) {
        this.userPK = userPK;
    }

    // Getter and Setter for User Name
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter and Setter for User Password
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // Getter and Setter for User Email
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Getter and Setter for User Gender
    public char getUserGender() {
        return userGender;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

//    @userPK
//    @GeneratedValue
    private int    userPK;
    private String userName;
    private String userPassword;
    private String userEmail;
    private char   userGender;
}
