package ApplicationControllerSandbox;

import org.quickconnectfamily.json.JSONOutputStream;

import java.util.HashMap;

// A type of handler that uses the same method signature as the interface Handler
public class SpeakHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        try{
            JSONOutputStream outToClient = (JSONOutputStream)dataMap.remove("toClient");
            System.out.println("Just got:" + dataMap + " from client");
            dataMap.put("command", "Done");
            outToClient.writeObject(dataMap);
            System.out.println("just sent "+dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
