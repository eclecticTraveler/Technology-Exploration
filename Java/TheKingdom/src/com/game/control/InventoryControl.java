
package com.game.control;

import com.game.KingdomGame;
import com.game.model.Game;
import com.game.model.Inventory;
import com.game.model.Item;

public class InventoryControl {
    
    public int playerProgress() {
        Game game = KingdomGame.getCurrentGame();
        Item[] inventory = game.getInventory();
        Inventory itemList = new Inventory();
        int count = 0;
        for (Item inventory1 : inventory) {
            if (inventory1.getActualAmount() == 1) {
                count = itemList.getItemCount();
                count++;
                itemList.setItemCount(count);
            }
        }
        return count;
    }

    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
