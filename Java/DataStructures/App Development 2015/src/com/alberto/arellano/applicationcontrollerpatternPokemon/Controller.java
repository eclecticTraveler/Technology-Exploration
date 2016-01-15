package com.alberto.arellano.applicationcontrollerpatternPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jonathan
 */
public class Controller {
    
    private HashMap<String, Handler> controlHash = new HashMap<>();
    
    public Controller() {
        
        AddPokemonHandler addPokemonHandler = new AddPokemonHandler();
        controlHash.put("Add Pokemon", addPokemonHandler);
        
        RemovePokemonHandler removePokemonHandler = new RemovePokemonHandler();
        controlHash.put("Remove Pokemon", removePokemonHandler);
        
    }
    
    public void handle(String command, Integer position, ArrayList<String>... lists) {
        
        Handler task = controlHash.get(command);
        
        task.handleIt(position, lists);
        
    }
    
    
}
