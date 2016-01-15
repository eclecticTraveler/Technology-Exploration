package com.game.model;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable{
    
    private String playerName;

    public Player() {
    }
    
    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.playerName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        return true;
    }

}
