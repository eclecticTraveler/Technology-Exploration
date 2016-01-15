package com.alberto.arellano.applicationcontrollerpatternPokemon;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class RemovePokemonHandler implements Handler {
    
    @Override
    public void handleIt(Integer position, ArrayList<String>... lists) {
        
        Integer myPokemonCollectionPosition = position;
        ArrayList<String> myPokemonCollection = lists[0];
        
        System.out.println(myPokemonCollection.get(myPokemonCollectionPosition) + " has been removed");
        myPokemonCollection.remove(myPokemonCollection.get(myPokemonCollectionPosition));
        
        System.out.println(myPokemonCollection + "\n");
        
    }
    
}
