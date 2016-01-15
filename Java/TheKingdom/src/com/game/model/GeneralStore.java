package com.game.model;

import com.game.view.GameMenuView;
import com.game.view.View;

public class GeneralStore extends View {
    //
    public GeneralStore() {
        super("\n"
                + "\n\t======================================="
                + "\n\t|          The General Store          |"
                + "\n\t======================================="
                + "\n\t1 - Moldy Bread               @5XP    |"
                + "\n\t2 - Slimy Chicken             @7XP    |"
                + "\n\t3 - Potions of Health         @10XP   |"
                + "\n\t4 - Extra Life                @30XP   |"
                + "\n\t                                      |"
                + "\n\tq - Exit to Map                       |"
                + "\n\t=======================================");}
    @Override
    public void doAction(String value) {
        char option = value.charAt(0);
        switch (option) {
            case '1': //create and start a new game
                
                System.out.println("\n\n");
                System.out.println("You've purchased [1] Moldy Bread"
                                 + "\nfor 5XP.");
                break;
                
            case '2': //load an existing game
                
                System.out.println("\n\n");
                System.out.println("You've purchased [1] Slimy Chicken for"
                                  +"\n7XP.");
                break;
                
            case '3': //display the options menu
                
                System.out.println("\n\n");
                System.out.println("You've purchased [1] Potions of Health for"
                                  +"\n10XP.");
                break;
                
            case '4': //display the help menu
                
                System.out.println("\n\n");
                System.out.println("You've purchased [1] Extra Life"
                                 + "\nfor 30XP.");
                break;
                
            case 'q': //exit to in-game Map View
                
                GameMenuView mapView = new GameMenuView();
                mapView.display();
                return;
                
            default:
                
                System.out.println("\n Invalid selection!");
                break;
                
        }
    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
