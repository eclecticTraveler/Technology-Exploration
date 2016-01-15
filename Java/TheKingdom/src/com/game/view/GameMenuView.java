package com.game.view;

import com.game.control.GameControl;
import com.game.control.InventoryControl;
import com.game.model.Item;
import com.game.model.Kingdom;

public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n\t---------------------------------------"
                + "\n\t    Map                               |"
                + "\n\t---------------------------------------"
                + "\n\t1 - Go to the Kingdom                 |"
                + "\n\t2 - Go to the General Store           |"
                + "\n\t3 - Go to the Icy Caves               |"
                + "\n\t4 - Go to the Fiery Depths            |"
                + "\n\t5 - Go to the Spooky Hollow           |"
                + "\n\t6 - Inventory                         |"
                + "\n\t                                      |"
                + "\n\ts - Save                              |"
                + "\n\tq - Exit to Main Menu                 |"
                + "\n\t--------------------------------------|"
                + "\n\t\tUse: ");}
    
    @Override
    public void doAction(String value) {
        char option = value.charAt(0);
        switch (option) {
            case '1': //Go to the Kingdom
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayKingdom();
                break;
                
            case '2': //Go to the General Store
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayGeneralStore();
                break;
                
            case '3': //Go to the Icy Caves
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayDungeon1();
                break;
                
            case '4': //Go to the Fiery Depths
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayDungeon2();
                break;
                
            case '5': //Go to the Spooky Hollow
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayDungeon3();
                return;
                
            case '6': //Inventory
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayInventory();
                return;
  
            case 's': //Save Game
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                System.out.println("Game Saved!");
                return;
                
            case 'q': //Exit to Menu
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                this.displayMenu();
                return;
                
            default:
                
                System.out.println("\n Invalid selection!");
                break;
        }
    }

    private void saveGame() {
        System.out.println("\n*** calling saveGame ***");
    }

    void viewInventory() {
        InventoryControl inventoryControl = new InventoryControl();
        Item[] printList = GameControl.getSortedInventoryList();
        int itemsAcquired = 0;
        itemsAcquired = inventoryControl.playerProgress();
        System.out.println("\n****************************************");
        System.out.println("* You have  " + itemsAcquired + " out of 3 necessary items.*");
        System.out.println("****************************************");

        for (int i = 0; i < printList.length; i++) {
            System.out.println(printList[i].getDescription());
            System.out.println("    Actual Amount: " + printList[i].getActualAmount());
            System.out.println("    Required Amount: " + printList[i].getRequiredAmount());
        }
    }

    void getInventoryQuery() {
        System.out.println(" Inventory ");
    }
    
    private void displayKingdom() {
        Kingdom kingdomView = new Kingdom();
                kingdomView.display();
    }

    private void displayGeneralStore() {
        GeneralStore genStore = new GeneralStore();
                genStore.display();
    }

    private void displayDungeon1() {
        Dungeon1View dungeon1 = new Dungeon1View();
                dungeon1.display();
    }

    private void displayDungeon2() {
        Dungeon2View dungeon2 = new Dungeon2View();
                dungeon2.display();
    }

    private void displayDungeon3() {
        Dungeon3View dungeon3 = new Dungeon3View();
                dungeon3.display();
    }

    private void displayInventory() {
        InventoryControl inventory = new InventoryControl();
                inventory.display();
    }

    public void displayMenu() {
        MenuView Menu = new MenuView();
                Menu.display();
    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
