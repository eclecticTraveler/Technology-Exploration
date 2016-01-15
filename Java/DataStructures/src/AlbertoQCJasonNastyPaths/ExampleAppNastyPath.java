package AlbertoQCJasonNastyPaths;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by rome on 10/26/2015.
 */
public class ExampleAppNastyPath {


    public static void main(String[] args){

        try {


            // Get the Json String from the file, lets say we got across the internet
            // with fout we are pointing to the file that should write into
            // It writes to whatevet extension you give it
            // It creates onw when you do the OUT
            // A file path where I can have write priviledges
            FileOutputStream fout = new FileOutputStream("C:\\Users\\rome\\Desktop\\10th Semester Final\\CIT 360\\results.img");
            // Can't Put it twice
//                             fout = new FileOutputStream("C:\\Users\\rome\\Desktop\\10th Semester Final\\CIT 360\\results.txt");

            //  java.io.FileNotFoundException: C:\Program Files\nodejs\results.txt (Access is denied)
//            FileOutputStream fout = new FileOutputStream("C:\\Program Files\\nodejs\\results.txt");


            // But if you did not have one then
            // ERROR: if filed not specified ->java.io.FileNotFoundException: userInfo3In.json (The system cannot find the file specified)
            // and fin is where we will retrieve info
            // Get Read -> java.io.FileNotFoundException: C:\Program Files\nodejs\results.txt (Access is denied)
//            FileInputStream fin = new FileInputStream("userInfoOut.txt");
            FileInputStream fin = new FileInputStream("C:\\Users\\rome\\Desktop\\10th Semester Final\\CIT 360\\results.txt");
//            FileInputStream fin = new FileInputStream("C:\\Program Files\\nodejs\\results.txt");

            // we will pass these objects to the QCJason Library to be parsed out
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);



            // With Char Array and with an Single Char it throws the following error:
            // String gender = "F";
            //  char[] userGender = gender.toCharArray();
            //   UserProfileBean anObjectUser = new UserProfileBean("Emma Goldman","HardWork01", "emmaGold@exist.edu",userGender,180);
            UserProfileBean anObjectUser = new UserProfileBean("Emma Goldman","HardWork01","emmaGold@exist.edu","F", 180);
            // Write to the FILE!!
            try {
                // It will overwrite it
                jsonOut.writeObject(anObjectUser);
                jsonOut.writeObject(anObjectUser);
            }catch (Exception ex)
            {
                //ERROR: Exception in thread "main" java.lang.ClassCastException: java.util.HashMap cannot be cast to java.lang.String
                System.out.println("Char or Array of chars are not handled");
                ex.printStackTrace();
            }
            //After executed by the JsonOut methods I will get a HashMap back
            HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
            // Read From file that has a JSon String ready to be read
            // An it will be passed to the class that will allocate the content
            // Respectively

            // If its empty it throws
            // ERROR: Invalid JSON String
            TestObjectNastyPaths readObject = new TestObjectNastyPaths(parsedJSONMap);
            System.out.println("stream same? "+readObject.equals(anObjectUser));


			/*
			 * Stringify and parse example.  Use this if you are not using streams
			 * or you need to encrypt the JSON strings.
			 */

            String jsonString = JSONUtilities.stringify(anObjectUser);
            System.out.println("JSON: "+jsonString);
//
//            parsedJSONMap = (HashMap)JSONUtilities.parse(jsonString);
//            readObject = new TestObject(parsedJSONMap);
//            System.out.println("stringify same? "+readObject.equals(anObject));

            //this is the quickconnectfamily JSONException not the standard one.
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
