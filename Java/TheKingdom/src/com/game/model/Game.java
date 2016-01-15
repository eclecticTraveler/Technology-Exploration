package com.game.model;

import java.io.Serializable;
import java.util.*;
import java.util.Objects;
import java.util.stream.*;

public class Game implements Serializable{

    private String lastSave;
    private double totalTime;
    private double bestTime;
    
    private Item[] inventory;
    private Player player;
    private String[] actors;
    private Map map;
    
    public Game() {
    }
    
    public String getLastSave() {
        return lastSave;
    }

    public void setLastSave(String lastSave) {
        this.lastSave = lastSave;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Game{" + "lastSave=" + lastSave + ", totalTime=" + totalTime + ", bestTime=" + bestTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.lastSave);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.bestTime) ^ (Double.doubleToLongBits(this.bestTime) >>> 32));
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.lastSave, other.lastSave)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bestTime) != Double.doubleToLongBits(other.bestTime)) {
            return false;
        }
        return true;
    }
    
    public class duplicatedWords {
        public static void main(String[] args) {
            Set<String> distinctWords = Arrays.asList(args).stream()
                    .collect(Collectors.toSet());
            System.out.println(distinctWords.size()+
                                " distinct words: " +
                                distinctWords);
        }
        
    }

}
    
    
    
