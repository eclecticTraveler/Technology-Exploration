package com.game.view;

import com.game.KingdomGame;
import com.game.model.Game;
import com.game.model.Item;

public class InventoryMenuView extends View {
    
    public InventoryMenuView() {
        super("\n" 
                + "\n\t---------------------------------------"
                + "\n\t             Inventory                 "
                + "\n\t---------------------------------------"
                + "\n\t- Level: " 
                + "\n\t---------------------------------------"
                + "\n\t1- Moldy Bread: " 
                + "\n\t2- Slimy Chicken: " 
                + "\n\t3- Potion of Health: "
                + "\n\t4- Extra Lives: " 
                + "\n\t---------------------------------------"
                + "\n\t- Experience: " 
                + "\n\t- Magical Spheres: "
                + "\n\t---------------------------------------"
                + "\n\tq - Go to the Map                     |"
                + "\n\t---------------------------------------"
                + "\n\t\tUse: ");
    }
    

    //Double spheres, Double xp, Double lives, Double potionsFood, Double chickensFood, Double breadFood, Double lvl

    @Override
    public void doAction(String value) {
        Item[] inventoryList = game.getInventory();
        switch (value) {
            
            case "1":
                
                if (inventoryList[BREAD].getActualAmount() == 0) {
                    
                    URL InventrySoundUrl = new URL("https://www.freesound.org/people/modularsamples/sounds/289866/");
                    AudioClip InventorySound = Applet.newAudioClip(InventorySoundUrl);
                    InventorySound.play();
                    
                    System.out.println("\n\tYou don't have enough experience to buy this.");
                    
                    break;
                    
                } else {
                    
                    inventoryList[BREAD].setSelected(true);
                    
                    break;
                }
            
            case "2":
                
                if (inventoryList[CHICKEN].getActualAmount() == 0) {
                    
                    URL InventrySoundUrl = new URL("https://www.freesound.org/people/modularsamples/sounds/289866/");
                    AudioClip InventorySound = Applet.newAudioClip(InventorySoundUrl);
                    InventorySound.play();
                    
                    System.out.println("\n\tYou don't have enough experience to buy this.");
                    
                    break;
                    
                } else {
                    
                    inventoryList[CHICKEN].setSelected(true);
                    
                    break;
                }
            
            case "3":
                
                if (inventoryList[POTION].getActualAmount() == 0) {
                    
                    URL InventrySoundUrl = new URL("https://www.freesound.org/people/modularsamples/sounds/289866/");
                    AudioClip InventorySound = Applet.newAudioClip(InventorySoundUrl);
                    InventorySound.play();
                    
                    System.out.println("\n\tYou don't have enough experience to buy this.");
                    
                    break;
                    
                } else {
                    
                    inventoryList[POTION].setSelected(true);
                    
                    break;
                }
            
            case "4":
                
                if (inventoryList[LIFE].getActualAmount() == 0) {
                    
                    URL InventrySoundUrl = new URL("https://www.freesound.org/people/modularsamples/sounds/289866/");
                    AudioClip InventorySound = Applet.newAudioClip(InventorySoundUrl);
                    InventorySound.play();
                    
                    System.out.println("\n\tYou don't have enough experience to buy this.");
                    
                    break;
                    
                } else {
                    
                    inventoryList[LIFE].setSelected(true);
                    
                    break;
                }
            
            case "q": //Go to the Map
                
                GameMenuView mapView = new GameMenuView();
                mapView.display();
                
                return;
                
            default:
                
                System.out.println("\n\t You fail at this, don't you? Give a new choice.");
                
                break;
                
        }//END switch
        
    }//END doAction
        
    Game game = KingdomGame.getCurrentGame();
    GameMenuView gameMenuView = new GameMenuView();

    final int BREAD = 1;
    final int CHICKEN = 0;
    final int POTION = 0;
    final int LIFE = 0;
    //Qued for Found
    final int SPHERES = 0;

    public void displayMenu() {
        
        Item[] inventoryList = game.getInventory();
        
        //Items For Sale
        String breadFood    =   inventoryList[BREAD].getActualAmount() 
                + " : " 
                +               inventoryList[BREAD].getRequiredAmount();
        String chickensFood =   inventoryList[CHICKEN].getActualAmount() 
                + " : " 
                +               inventoryList[CHICKEN].getRequiredAmount();
        String potionsFood  =   inventoryList[POTION].getActualAmount() 
                + " : " 
                +               inventoryList[POTION].getRequiredAmount();
        String lives        =   inventoryList[LIFE].getActualAmount() 
                + " : " 
                +               inventoryList[LIFE].getRequiredAmount();
        
        //Item Not For Sale
        String spheres      =   inventoryList[SPHERES].getActualAmount() 
                + " : " 
                +               inventoryList[SPHERES].getRequiredAmount();
    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
