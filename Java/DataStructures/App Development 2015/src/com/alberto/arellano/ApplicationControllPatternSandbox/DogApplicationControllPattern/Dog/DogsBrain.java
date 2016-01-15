package com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog;

import com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.DogHandlers.*;

import java.util.HashMap;

/**
 * Created by rome on 12/2/2015.
 */
public class DogsBrain {

    // I put is as a Brain because here is where the "Dog" will distinguish the commands given
    // through application Control Pattern
    private HashMap<String, DogHandler> neuronHash = new HashMap<>();

    public DogsBrain(){
        // Here are the commands that the dog has learned on its brain
        AttackHandler attackHandler = new AttackHandler();
        CreateHandler createHandler = new CreateHandler();
        DieHandler dieHandler       = new DieHandler();
        FeedHandler feedHandler     = new FeedHandler();

        // In technical words here is where we map the specific commands
        neuronHash.put("Attack", attackHandler);
        neuronHash.put("Eat"   , feedHandler  );
        neuronHash.put("Die"   , dieHandler   );
        neuronHash.put("Clone" , createHandler);

    }

    public void executeCommand(Integer aCommandKey, Dog aDog, HashMap<Integer,String> dogTricksList){
        try{
            // Find what command the user wanted the dog to do
            String commandToExecute = (String)dogTricksList.get(aCommandKey);

            //Get the respective Handler associated with the given command
            DogHandler dogCommand = neuronHash.get(commandToExecute);
            // By now the ACP knows what handler to go to so
            // I can, now, pass the tools that the respective handler will need to do its job through its parameters
            dogCommand.handleCommand(aDog);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
