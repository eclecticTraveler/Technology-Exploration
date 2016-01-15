package ServerSideSandbox;

import ServerSideSandbox.ApplicationController;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

// Anotation that replaces the XML and tells tomcat to look for a servlet with the name must mach class
// Associate the name and the urlPatter with the JSONEchoServlet
@WebServlet(name = "JSONEchoService", urlPatterns = {"/json"})
// Extend to HttpServelet abstract class
public class JSONEchoServlet extends HttpServlet {
    // Instance of Application Controller
    private ApplicationController theAppController = new ApplicationController();

    // Init is a method in tomcat HttpServlet Super Class
    public void init(){
        theAppController.mapCommand("Speak", new SpeakHandler());
    }

    // Does a post via service method allowing the servlet to handle a Post request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //Gets Json Input from sender
            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
            // Outputs the message once processed to be visible to the client in the "server"
            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
            // ERROR : java.net.SocketException: Connection reset
            //Thread.currentThread().sleep(100000);
            // Casts Json Input into a HashMap because JSON is in a form of a HashMap
            HashMap<String, Object> dataMap = (HashMap) inFromClient.readObject();
            // Adds the key to Client with the Value of the message that is going to be outputed
            dataMap.put("toClient", outToClient);
            // First Gets the Value of Key "command" then casts it into String and stores it into another String
            String aCommand = (String) dataMap.get("command");
            // Stores this HashMap with a key of a string
            theAppController.handleRequest(aCommand, dataMap);

        } catch (Exception e) {
            e.printStackTrace();
            // From the server side if there is not a answer back it throws to the server
            // ERROR: org.quickconnectfamily.json.JSONException: Invalid JSON String
        }
    }

    //Method if you request information
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}



