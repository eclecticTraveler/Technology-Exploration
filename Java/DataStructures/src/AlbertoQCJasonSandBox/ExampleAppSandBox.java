
package AlbertoQCJasonSandBox;

import com.arellano.alberto.JsonExperimentation.TestObject;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;


public class ExampleAppSandBox {


    public static void main(String[] args){

        try {
        	/*
        	 * JSON file IO example.  Socket IO would be done the same way 
        	 * except that the output and input streams would be retrieved 
        	 * from a socket rather than created.
        	 */
            // Get the Json String from the file, lets say we got across the internet
            // with fout we are pointing to the file that should write into
            FileOutputStream fout = new FileOutputStream("userInfo2.json");
            // and fin is where we will retrieve info
            FileInputStream fin = new FileInputStream("userInfo.json");

            // we will pass these objects to the QCJason Library to be parsed out
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);
			
			/*
			 * An example serializable to be written out.  This could be 
			 * any Java Collection or Map if you want to write out groups x
			 * of serializables.
			 */
//            Date exampleDate = new Date();
//            TestObject anObject = new TestObject("an example string", 876543, exampleDate);

            UserBean anObjectUser = new UserBean("Emma Goldman","HardWork01","emmaGold@exist.edu","F", 180);
//            TestObjectSandBox anObjectUser = new TestObjectSandBox("Emma Goldman","HardWork01","emmaGold@exist.edu",'F', 180);
            // Write to the FILE!!
            jsonOut.writeObject(anObjectUser);

            //After executed by the JsonOut methods I will get a HashMap back
            HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
            // Read From file that has a JSon String ready to be read
            // An it will be passed to the class that will allocate the content
            // Respectively
            TestObjectSandBox readObject = new TestObjectSandBox(parsedJSONMap);
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
