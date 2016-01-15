package ServeletsExample;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

// Out class that will set a connection to Tomcat and send a servlet
public class JSONEchoClient {
    public static void main(String[] args){
        // Instance of itself
        JSONEchoClient theClient = new JSONEchoClient();
        // Get out of yucky main!
        theClient.go();
    }

    private void go() {
        // Infinite Loop!!
        while(true){
            try {
                // Instance of Scanner
                Scanner systemInScanner = new Scanner(System.in);
                // Print out the message to be sent
                System.out.printf("Enter the message to send to the server.\n");
                // Put it into a string
                String messageForServer = systemInScanner.nextLine();

                // Instance of URL which represents a Uniform Resource Locator or
                // a Pointer to a "resource" on the World Wide Web which can be as
                // simple as a file or a directory, we will navigate through
                // Port 7070 because my other default port 8080 is already in use
//                URL url = new URL("http://localhost:7070/json");


                // If I do it through an existing host but to a port that is blocked by the firewall that
                // simply drops TCP SyN packets
                // It will say ERROR: java.net.ConnectException: Connection timed out: connect
                URL url = new URL("http://www.google.com:81");

                // url has a method called openConnection that Returns a URL Connection instance
                // that represents a connection to the remote object referred to by the URL
                // This connection is casted to a HttpURLConnection and its saved in the var of its kind
                // why? so that you can do POST
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Sets the value of the doOutput flied for this URLConnection
                connection.setDoOutput(true);//allows POST
                // Returns a boolean for the value of this URL to see if it was successful
                JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());
                // Create a new HashMap
                HashMap<String, Object> request = new HashMap<>();
                // I add to it two strings but the one in the Value position is treated as object
                request.put("command", "Speak");
                // Then I add again but this time I associate the message with the String I got from the USER
                request.put("message", messageForServer);
                // Once finished I write the HashMap into the QCJson writeObject Method
                try{

                    outToServer.close();
                }catch (Exception e)
                {
                    System.out.println("Don't Close connection before Sending ");
                    e.printStackTrace();
                }
                outToServer.writeObject(request);

                // This code should be done through application control but its is a quick hack
                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());
                // Read what I got back from the server
                HashMap<String, Object> response = (HashMap<String, Object>) inFromServer.readObject();
                // if It evaluates to the following Strings then prints conditionally
                if (response.get("command").equals("Done")) {
                    System.out.println("Sent request: " + request + "and  got response  " + response);
                } else {
                    System.out.println("Oops. got " + response);
                }
            }
            catch (Exception e){
                e.printStackTrace();

                // If I interrupt the proccess abruptly by canceling the process From the client side the message
                // Is sometimes delivered successfully then it sends
                // java.util.NoSuchElementException: No line found
                // If I do a "outToServer.close();" Before sending the message it says
                // org.quickconnectfamily.json.JSONException: Invalid JSON String on both the server and the client

            }
        }

    }
}
