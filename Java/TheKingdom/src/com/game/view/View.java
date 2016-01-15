package com.game.view;

import java.util.Scanner;

public abstract class View implements ViewInterface {
    
    String promptMessage;
    Scanner keyboard = new Scanner(System.in);
    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        String value;
        
        /*do {
            
            System.out.println(this.promptMessage); //Display the Prompt
            value = this.getInput(); //get the user's selection
            this.doAction(value); //do action based on selection
            
        } while (!value.equals("6"));*/
    }
}


