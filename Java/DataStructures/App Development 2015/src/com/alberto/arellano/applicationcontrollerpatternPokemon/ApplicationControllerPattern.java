package com.alberto.arellano.applicationcontrollerpatternPokemon;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class ApplicationControllerPattern {

    public static void main(String[] args) {
        
        Controller controller = new Controller();
    
        ArrayList<String> pokemonList = new ArrayList<>();
        ArrayList<String> myPokemonCollection = new ArrayList<>();
        String command;
        Integer pokemonListPosition, myPokemonCollectionPosition;
        
        pokemonList.add("001 Bulbasaur");
        pokemonList.add("002 Ivysaur");
        pokemonList.add("003 Venusaur");
        pokemonList.add("004 Charmander");
        pokemonList.add("005 Charmeleon");
        pokemonList.add("006 Charizard");
        pokemonList.add("007 Squirtle");
        pokemonList.add("008 Wartortle");
        pokemonList.add("009 Blastoise");
        
        // Add Ivysaur to my collection
        System.out.println("Add Ivysaur to our collection");
        command = "Add Pokemon";
        pokemonListPosition = 1;
        controller.handle(command, pokemonListPosition, pokemonList, myPokemonCollection);
        
        // Add Charizard to my collection
        System.out.println("Add Charizard to our collection");
        command = "Add Pokemon";
        pokemonListPosition = 5;
        controller.handle(command, pokemonListPosition, pokemonList, myPokemonCollection);
        
        // Add Squirtle to my collection
        System.out.println("Add Squirtle to our collection");
        command = "Add Pokemon";
        pokemonListPosition = 6;
        controller.handle(command, pokemonListPosition, pokemonList, myPokemonCollection);
        
        // Remove Squirtle from my collection
        System.out.println("Remove Squirtle from our selection");
        command = "Remove Pokemon";
        myPokemonCollectionPosition = 2;
        controller.handle(command, myPokemonCollectionPosition, myPokemonCollection);
        
        // Attempt to use a controller command that doesn't exist
        System.out.println("Attempt to use an invalid command");
        command = "Duplicate Pokemon";
        myPokemonCollectionPosition = 2;
        controller.handle(command, pokemonListPosition, myPokemonCollection);
        
    }
    
}
