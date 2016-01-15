package com.game.model;

import java.io.Serializable;

public enum Actor implements Serializable{
    
    Mystical_Hero("Hero that saves the land","Mystical Hero");
    
    private final String name;
    private final String description;
    
    Actor(String description, String name) {
        this.name = name;
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "name = " + name + ", description = " + description;
    }
    
}
