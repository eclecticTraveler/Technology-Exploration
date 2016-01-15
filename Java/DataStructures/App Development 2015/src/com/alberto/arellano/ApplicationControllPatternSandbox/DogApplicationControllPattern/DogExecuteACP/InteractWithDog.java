package com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.DogExecuteACP;

import com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog.Dog;
import com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog.DogsBrain;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rome on 12/1/2015.
 */
public class InteractWithDog {

    public static void main(String[] args)
    {
        // Instantiate yourself to get out of main
        InteractWithDog trainer = new InteractWithDog();
        // Ciao Main
        trainer.go();
    }

    // Here is our new Main it makes it nicer and better to run our code
    private void go() {
        // Generate Dog
        Dog fido = new Dog("Fido","German Shepherd", 55, 79,5);
        // Hashmap of dog commands
        HashMap<Integer, String> dogTricks = new HashMap<>();
        dogTricks.put(1,"Attack");
        dogTricks.put(2,"Eat"   );
        dogTricks.put(3,"Die"   );
        dogTricks.put(4,"Clone" );
        // Display to User Dog's features
        generateDog(fido);


       // Give it a delay effect to make it a bit more interesting
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Then display all available options
        displayInstructions(fido);

        while (true){
            try{
                // Obtain the wished command
                Scanner commandForUrDog = new Scanner(System.in);
                int wishedCommand = commandForUrDog.nextInt();
                // Validate user input
                if (wishedCommand < 1 || wishedCommand > 4){
                    System.out.println("Invalid Command please...\n");

                    // Give it a delay effect to make it a bit more nice
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Display Instructions again
                    displayInstructions(fido);
                }else {
                    // Send number with dog
                    executeDogCommand(wishedCommand, fido, dogTricks);
                    // Ask user again
                    if(askUserToRepeat() == false) {
                        try {
                            System.out.println("All Commands handled Through Application Control Pattern\n");
                            System.out.println("Instead of If/Else Statements\n");
                            System.out.println("Brought To you by Alberto Arellano\n");
                            Thread.currentThread().sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("See you soon\n");
                        break;
                    }
                    else
                        displayInstructions(fido);
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    private boolean askUserToRepeat() {
        // Obtain user decision
        Scanner wannaRepeat = new Scanner(System.in);
        System.out.println("(Yes or No) Would you like to Try another trick?");
        String answer = wannaRepeat.nextLine();
        // Make it lowercase
        String lowerCaseAnswer = answer.toLowerCase();
        // Grab its first Letter
        String firstLetter = String.valueOf(lowerCaseAnswer.charAt(0));
        // If the user say something other than yes return false else return true
        boolean finalAnswer = !firstLetter.equals("y")  ? false : true;;
        return finalAnswer;
    }

    private void generateDog(Dog fido) {
        System.out.println("Assigning you a New Dog.. Wait");
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is your new Dog");
        System.out.println("\tName: "   + fido.getName());
        System.out.println("\tBreed: "  + fido.getBreed());
        System.out.println("\tAge: "    + fido.getAge());
        System.out.println("\tHeight: " + fido.getHeight());
        System.out.println("\tWeight: " + fido.getWeight());
    }

    private void displayInstructions(Dog fido){
        System.out.println("What is the command you want your dog "+ fido.getName() + " to execute?");
        System.out.println("\tPress 1 for Attacking");
        System.out.println("\tPress 2 for Feeding it");
        System.out.println("\tPress 3 for Pulling the dying trick");
        System.out.println("\tPress 4 for Cloning your dog (Yes, Its possible)");
    }

    private void executeDogCommand(int commandNumber, Dog fido, HashMap<Integer,String> dogTricks) {
        // Map All the available Handlers before starting
        // By using the default constructor of the Controller named DogsBrains
        // I called it that way because it is in the Dog's brains where all the actions are placed
        DogsBrain dogsBrain = new DogsBrain();
        // Pass all the parameters to the control layer which in this case is the Dogs Brain

        // Send Command with the respective dog
        dogsBrain.executeCommand(commandNumber,fido,dogTricks);

    }
}
