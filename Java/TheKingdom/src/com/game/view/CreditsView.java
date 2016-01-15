package com.game.view;

import java.util.Scanner;

public class CreditsView {
    Scanner user_input = new Scanner(System.in);

    private final String MENU = "\n"
            + "\n---------------------------------------"
            + "\n|       WELCOME TO THE CREDITS        |"
            + "\n---------------------------------------"
            + "\n Sterling Grant                        "
            + "\n Kayla Lindstrom                       "
            + "\n Derek Hodges                          "
            + "\n Dustin Judd                           "
            + "\n---------------------------------------"
            + "\nq - Exit to Main Menu                 |"
            + "\n---------------------------------------";
    
    void display() {
        char option = ' ';
        do {
            System.out.println(MENU);           
            
            String input = user_input.next();   
            option = input.charAt(0);           
            
            this.doAction(option);           
            
        } while (option != 'q');             
    }


    private void doAction(char option) {
        
        switch(option) {
         
            case 'q': //Go Back to Menu
                
                MenuView Menu = new MenuView();
                Menu.display();
                return;
                
            default:
                
                System.out.println("\n Invalid selection!");
                break;
                
        }
    }
}
