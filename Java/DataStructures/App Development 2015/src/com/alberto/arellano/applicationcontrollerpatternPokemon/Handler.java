package com.alberto.arellano.applicationcontrollerpatternPokemon;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public interface Handler {
    
    public void handleIt(Integer position, ArrayList<String>... lists);
    
}
