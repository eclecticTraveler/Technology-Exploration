package ApplicationControllerSandbox;

import java.util.HashMap;

public class ApplicationController {
    // Private Instance Variable Which key is a String and Value is a Handler Interface
    private HashMap<String,Handler> handlerMap = new HashMap();



    // Method which receives a String and a HashMap with a String and a Object
    public void handleRequest(String command, HashMap<String,Object> data){
        // Since Handler is an interface you cannot instantiate it
        // Rather you store the handlerMap HashMap's Key of type String
        // to the Handler
        Handler aCommandHandler = handlerMap.get(command);
        // If whatever was returned is not null, because its possible
        // Then get Handler's method which parameter is a HashMap
        // and pass the object to it.
        if (aCommandHandler != null){
            aCommandHandler.handleIt(data);
        }
    }


    public void mapCommand(String aCommand, Handler acHandler){

        // Add to the handler HashMap the string and the Handler
        handlerMap.put(aCommand,acHandler);
    }
}
