package com.game.control;

import com.game.KingdomGame;
import com.game.control.MapControl.SceneType;
import com.game.model.Game;
import com.game.model.Item;
import com.game.model.Location;
import com.game.model.Map;
import com.game.model.Player;
import com.game.model.Scene;
import java.io.Serializable;

public class GameControl implements Serializable {

    public static void createNewGame(Player player) {

        Game game = new Game();
        KingdomGame.setCurrentGame(game); 

        game.setPlayer(player); 

        Item[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);

        Map map = MapControl.createMap();
        game.setMap(map);

        MapControl.moveActorsToStartingLocation(map);

    }

    private static Item[] createInventoryList() {
        final int NUM_OF_ITEMS = 4;
        Item[] inventory
                = new Item[NUM_OF_ITEMS];
        
        // :: ITEM :: Bread
        Item bread = new Item();
        bread.setDescription("Moldy Bread");
        bread.setActualAmount(0);
        bread.setRequiredAmount(0);
        bread.setSelected(false);
        inventory[InventoryItem.bread.ordinal()] = bread;
        
        // :: ITEM :: Chicken
        Item chicken = new Item();
        chicken.setDescription("Slimy Chicken");
        chicken.setActualAmount(0);
        chicken.setRequiredAmount(0);
        chicken.setSelected(false);
        inventory[InventoryItem.chicken.ordinal()] = chicken;
        
        // :: ITEM :: Potion
        Item potion = new Item();
        potion.setDescription("Potion of Health");
        potion.setActualAmount(0);
        potion.setRequiredAmount(0);
        potion.setSelected(false);
        inventory[InventoryItem.potion.ordinal()] = potion;
        
        // :: ITEM :: Life
        Item life = new Item();
        life.setDescription("Extra Lives");
        life.setActualAmount(0);
        life.setRequiredAmount(0);
        life.setSelected(false);
        inventory[InventoryItem.life.ordinal()] = life;
        
        return inventory;
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.begin.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.dungeon1.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.dungeon2.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.dungeon3.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.kingdom.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.end.ordinal()]);

    }

    public enum InventoryItem {

        bread,
        chicken,
        potion,
        life,
        
    }

    public static Item[] getSortedInventoryList() {
        Item[] originalInventoryList
                = KingdomGame.getCurrentGame().getInventory();

        Item[] inventoryList = originalInventoryList.clone();

        Item tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j].getDescription().compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }
    
}
