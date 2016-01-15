package com.game.control;

import com.game.KingdomGame;
import com.game.model.Player;

public class ProgramControl {

    public static Player createPlayer(String playersName) {
        
        Player player = new Player();
        player.setPlayerName(playersName);
        
        KingdomGame.setPlayer(player);
        
        return player;
        
    }//End createPlayer()
    
}//END
