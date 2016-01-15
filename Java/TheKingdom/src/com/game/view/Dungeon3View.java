package com.game.view;

import com.game.KingdomGame;
import com.game.model.Dungeon3;
import com.game.model.Game;
import com.game.model.Item;
import com.game.model.Location;
import com.game.model.Map;

public class Dungeon3View extends View {

    Game game = KingdomGame.getCurrentGame();
    Item[] inventoryList = game.getInventory();
    Map adjustMap = game.getMap();
    Location[][] adjustLocations = adjustMap.getLocations();
    Dungeon3 dungeon3 = new Dungeon3();

    final int BREAD = 1;
    final int CHICKEN = 0;
    final int POTION = 0;
    final int LIFE = 0;
    
    // Spooky Hollow
    public Dungeon3View() {
        super("\n"
                + "\n\t========================================="
                + "\n\t=            Spooky Hollow              =");
        CombatControlView startCombat = new CombatControlView();
        startCombat.startCombat();
    }

    @Override
    public void doAction(String value) {

    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}//END