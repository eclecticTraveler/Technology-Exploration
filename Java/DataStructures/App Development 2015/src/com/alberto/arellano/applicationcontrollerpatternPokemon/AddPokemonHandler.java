package com.alberto.arellano.applicationcontrollerpatternPokemon;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class AddPokemonHandler implements Handler {
   
    
    @Override
    public void handleIt(Integer position, ArrayList<String>... lists) {
        
        Integer pokemonListPosition = position;
        ArrayList<String> pokemonList = lists[0];
        ArrayList<String> myPokemonCollection = lists[1];
        
        myPokemonCollection.add(pokemonList.get(pokemonListPosition));
        
        System.out.println(pokemonList.get(pokemonListPosition) + " has been added to your collection");
        
        System.out.println(myPokemonCollection + "\n");
        
    }
    
}
