package ServerSideSandbox;

import java.util.HashMap;

public class ApplicationController {
    // Key String and Value Handler
    private HashMap<String, Handler> handlerMap = new HashMap();
    // Gets a String and a HashMap.
    // In this case the command is the Key
    public void handleRequest(String command, HashMap<String,Object> data){
        // Getting the Value from which the Key is specified from HandlerMap HashMap and I store it in a Handler
        // Method interface
        Handler aCommandHandler = handlerMap.get(command);
        // If this variable is not null then
        if (aCommandHandler != null){
            // Get HandleIt in Speak Handler Class
            aCommandHandler.handleIt(data);
        }
    }

    public void mapCommand(String aCommand, Handler acHandler){
        // Adds the aCommand as the key and Handler object as the value
        handlerMap.put(aCommand,acHandler);
    }
}
