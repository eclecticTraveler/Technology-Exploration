package com.game.view;

import java.util.Scanner;

public class OptionsView {
    Scanner user_input = new Scanner(System.in);
    
    private final String MENU = "\n"
            + "\n\t---------------------------------------"
            + "\n\t|              Options                |"
            + "\n\t---------------------------------------"
            + "\n\t1 - Fullscreen                        |"
            + "\n\t2 - Sound                             |"
            + "\n\t3 - Color                             |"
            + "\n\t                                      |"
            + "\n\tq - Go to the Main Menu               |"
            + "\n\t---------------------------------------";
    
    void display() {
        char option = ' ';
        do {
            System.out.println(MENU);  //display the main menu //was MENU
            
            String input = user_input.next();     //String input = this.getInput(); <= Jacksons =>Mine: String input = user_input.next(); get the user's selection
            option = input.charAt(0);
            
            this.doAction(option);           //do action based on selection
            
        } while (option != 'q');             //the selection is not "exit"
    }


    private void doAction(char option) {
        
        switch(option) {
         
            case '1': //MENU OPTION [1]:: FULLSCREEN
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                System.out.println("The screen is now in a very tiny window!");
                return;
                
            case '2': //MENU OPTION [2]:: SOUND
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                System.out.println("The sound is now off!");
                return;
                
            case '3': //MENU OPTION [3]:: COLOR
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                System.out.println("You've turned off the color, "
                                 + "\nnow it's all black and white!");
                return;
                
            case 'q': //MENU OPTION [4]:: GO BACK TO MAIN MENU
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                MenuView Menu = new MenuView();
                Menu.display();
                return;
                
            default:
                
                System.out.println("\n Invalid selection!");
                break;
                
        }
    }
}
