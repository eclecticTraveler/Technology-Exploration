package AlbertoQCJasonSandBox;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;


@SuppressWarnings("serial")
public class TestObjectSandBox implements Serializable {
    private String name;
    private String password;
    private String email;
//    private char gender;
    private String gender;
    private int age;

    public TestObjectSandBox(String name, String password, String email, String gender, int age) {
        this.name     = name;
        this.password = password;
        this.email    = email;
        this.gender   = gender;
        this.age      = age;
    }

    public TestObjectSandBox(HashMap aMapRepresentation){
        // Get the values from the hashmap
        this.name = (String)aMapRepresentation.get("name");
        this.password = (String)aMapRepresentation.get("password");
        this.email = (String)aMapRepresentation.get("email");
        this.gender = (String)aMapRepresentation.get("gender");
//        this.gender = AGender.charAt(0);
        //numbers are stored as longs or doubles.
        Long asLong = (Long)aMapRepresentation.get("age");
        this.age = asLong.intValue();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestObjectSandBox other = (TestObjectSandBox) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name)){
            System.out.println("failed: "+name+" "+ other.name);
            return false;
        }
        if (password != other.password)
            return false;
        if (age != other.age)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
