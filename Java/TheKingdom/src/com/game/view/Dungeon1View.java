package com.game.view;

import com.game.KingdomGame;
import com.game.model.Dungeon1;
import com.game.model.Game;
import com.game.model.Item;
import com.game.model.Location;
import com.game.model.Map;

public class Dungeon1View extends View {

    Game game = KingdomGame.getCurrentGame();
    Item[] inventoryList = game.getInventory();
    Map adjustMap = game.getMap();
    Location[][] adjustLocations = adjustMap.getLocations();
    Dungeon1 dungeon1 = new Dungeon1();

    final int BREAD = 1;
    final int CHICKEN = 0;
    final int POTION = 0;
    final int LIFE = 0;
    
    // Icy Caves
    public Dungeon1View() {
        super("\n"
                + "\n\t========================================="
                + "\n\t=               Icy Caves               =");
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
