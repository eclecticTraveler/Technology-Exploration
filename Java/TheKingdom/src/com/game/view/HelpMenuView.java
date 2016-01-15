package com.game.view;

public class HelpMenuView extends View {

    public HelpMenuView() {
        super("\n"
            + "\n\t---------------------------------------"
            + "\n\t|            Help Menu                |"
            + "\n\t---------------------------------------"
            + "\n\t1 - Moving in The Kingdom             |"
            + "\n\t2 - The Numbers                       |"
            + "\n\t3 - The Syntax                        |"
            + "\n\t4 - The General Store                 |"
            + "\n\t5 - Fighting                          |"
            + "\n\t6 - Health                            |"
            + "\n\t7 - Food                              |"
            + "\n\t                                      |"   
            + "\n\tq - Go to the Main Menu               |"
            + "\n\t---------------------------------------");
    }

    @Override
    public void doAction(String value) {
        char option = value.charAt(0);
        switch (option) {
         
            case '1': //MENU OPTION [1]:: Moving in The Kingdom
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tTo move in the kingdom, you select which"
                               + "\n\tplace you want to move to. For example, "
                               + "\n\ton your map, there will be the choice to"
                               + "\n\tgo to the Castle, the General Store, the"
                               + "\n\tHoly Citadel, and a dungeon. You type"
                               + "\n\tthe number on the map that you want to go"
                               + "\n\tto and it moves you there.");
                System.out.println("\n\t==================================================");
                waitTime(65000);
                return;
                
            case '2': //MENU OPTION [2]:: The Numbers
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tThere are numbers on the screen. These"
                               + "\n\tare very special, as they are your"
                               + "\n\toptions. Select the option by choosing"
                               + "\n\tthe number associated with it and press"
                               + "\n\tenter.");
                System.out.println("\n\t==================================================");
                waitTime(55000);
                return;
                
            case '3': //MENU OPTION [3]:: The Syntax
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tCurrently, there are no special numbers"
                                 + "\n\tor characters in the game, so you don't"
                                 + "\n\tneed to worry about this.");
                System.out.println("\n\t==================================================");
                waitTime(45000);
                return;
                
            case '4': //MENU OPTION [4]:: The General Store
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tThe General Store is your life line."
                               + "\n\tThe store contains food, potions and"
                               + "\n\tlives for you to purchase. Without"
                               + "\n\tthese options to purchase food, your"
                               + "\n\tcharacter will otherwise die and lose"
                               + "\n\tprogress. Don't die! Buy today!");
                System.out.println("\n\t==================================================");
                waitTime(65000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tExperience, won by fighting, is the"
                               + "\n\tcurrency of the game. The General Store"
                               + "\n\talso saves your game upon entering it.");
                System.out.println("\n\t==================================================");
                waitTime(45000);
                return;
                
            case '5': //MENU OPTION [5]:: Fighting
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tWhen you get into a dungeon, your battle"
                               + "\n\tbegins. One of these mobs contains the"
                               + "\n\tmagic sphere that you are collecting."
                               + "\n\tThere are three dungeons, with three very"
                               + "\n\tvery different magical spheres.");
                System.out.println("\n\t==================================================");
                waitTime(75000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tWhen you begin a fight, it will show your"
                               + "\n\thealth, your enemies health, and your"
                               + "\n\tenemies name. Each fight has randomized"
                               + "\n\ta monster, a monsters health, a monsters"
                               + "\n\tdrop table and experience.");
                System.out.println("\n\t==================================================");
                waitTime(65000);
                return;
                
            case '6': //MENU OPTION [6]:: Health
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tRun out of health in The Kingdom, and it's"
                               + "\n\tall over for your hero. If you do happen to"
                               + "\n\tdie, you will lose all of your hard earned"
                               + "\n\texperience. Remember, experience is the"
                               + "\n\tcurrency of the game and is very valuable.");
                System.out.println("\n\t==================================================");
                waitTime(75000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tAfter you die, you will have the opportunity"
                                 + "\n\tto return to life via a save point. Save"
                                 + "\n\tpoints only happen when you enter a General"
                                 + "\n\tStore, so be sure to save there often!");
                System.out.println("\n\t==================================================");
                waitTime(65000);
                return;
                
            case '7': //MENU OPTION [7]:: Food
                
                System.out.println("\n\n");
                System.out.println("\n\t==================================================");
                System.out.println("\tThere are three types of foods in the game."
                                 + "\n\tMoldy Bread, Slimy Chicken and Potions of "
                                 + "\n\tHealth are available at the General Store.");
                System.out.println("\n\t==================================================");
                waitTime(60000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tThe Moldy Bread heals you for a maximum of"
                                 + "\n\t3 health points (or HP) but your inventory"
                                 + "\n\tcan carry up to five of them.");
                System.out.println("\n\t==================================================");
                waitTime(50000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tThe Slimy Chicken heals you for a maximum"
                                 + "\n\tof 15 health points (or HP) but your"
                                 + "\n\tinventory can carry up to two of them.");
                System.out.println("\n\t==================================================");
                waitTime(50000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tThe Potions of Health heals you for a"
                                 + "\n\tmaximum of 30 health points (or HP). Be"
                                 + "\n\tcareful though, you can only carry one!");
                System.out.println("\n\t==================================================");
                waitTime(60000);
                System.out.println("\n\t==================================================");
                System.out.println("\n\tThe last item sold at the General Store is"
                                 + "\n\tthe Extra Life. These will save you from "
                                 + "\n\tdeath when you are faced with it. There is"
                                 + "\n\tno maximum of how many you can carry, but"
                                 + "\n\tthey are very expensive. That might deter"
                                 + "\n\tfrom stockpiling this precious item.");
                System.out.println("\n\t==================================================");
                waitTime(95000);
                return;
                
            case 'q': //MENU OPTION [8]:: GO BACK TO MENU
                
                MenuView Menu = new MenuView();
                Menu.display();//was displayMenu()
                return;
                
            default:
                System.out.println("\n\t==================================================");
                System.out.println("\n\t\t\t Invalid selection!");
                System.out.println("\n\t==================================================");
                break;
                
        }
    }
    
    public static void waitTime(long millisecond) {
        long max = millisecond;
        for(long i = 0; i < max; i++) {
            for(long j = 0; j < max; j++) {}
        }
    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
