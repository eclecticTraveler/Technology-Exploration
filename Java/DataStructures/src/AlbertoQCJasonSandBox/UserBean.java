package AlbertoQCJasonSandBox;

import java.io.Serializable;

/**
 * Created by rome on 10/9/2015.
 */
public class UserBean implements Serializable {

    // My Member Variables
    private String name;
    private String password;
    private String email;
    private String gender;
    private int age;

    // Default Constructor
    public UserBean(){

    }

    // Non-Default Constructor
    public UserBean(String name, String password, String email, String gender, int age) {
        this.name     = name;
        this.password = password;
        this.email    = email;
        this.gender   = gender;
        this.age      = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter for Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for Gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Email
    public String getEmail() {
        return email;
    }

    // Getter for Gender
    public String getGender() {
        return gender;
    }



}
