package AlbertoQCJasonNastyPaths;

import java.util.HashMap;

/**
 * Created by rome on 10/26/2015.
 */
public class TestObjectNastyPaths {
    private String name;
    private String password;
    private String email;
//    private char[] gender;
    private String gender;
    private int age;

    public TestObjectNastyPaths(String name, String password, String email, String gender, int age) {
        this.name     = name;
        this.password = password;
        this.email    = email;
        this.gender   = gender;
        this.age      = age;
    }

    public TestObjectNastyPaths(HashMap aMapRepresentation){
        // Get the values from the hashmap
        this.name = (String)aMapRepresentation.get("name");
        this.password = (String)aMapRepresentation.get("password");
        this.email = (String)aMapRepresentation.get("email");
        this.gender =(String)aMapRepresentation.get("gender");
        // From a string to a Char
//        String userGgender = (String)aMapRepresentation.get("gender");
//        this.gender = userGgender.charAt(0);

        // Not oveloaded for Array of Chars
//        String userGender = (String)aMapRepresentation.get("gender");
//        gender = userGender.toCharArray();

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
        TestObjectNastyPaths other = (TestObjectNastyPaths) obj;
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
