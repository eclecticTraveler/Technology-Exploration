package com.game;

import com.game.model.Game;
import com.game.model.Player;
import com.game.view.StartProgramView;
import java.io.Serializable;
import java.util.*;

public class KingdomGame implements Serializable {

    private static Game currentGame = null;
    private static Player player = null;
    
    public static void main(String[] args) {

        StartProgramView startProgramView;
        startProgramView = new StartProgramView();
        startProgramView.startProgram();
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        KingdomGame.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        KingdomGame.player = player;
    }
    
    public class Countdown {
        public void main(String[] args) throws InterruptedException {
            int time = Integer.parseInt(args[0]);
            Queue<Integer> queue = new LinkedList<Integer>();
    
            for (int i = time; i >= 0; i--)
                queue.add(i);
    
            while (!queue.isEmpty()) {
                System.out.println(queue.remove());
                Thread.sleep(1000);
            }
        }
    }
    
    
    

} //End
