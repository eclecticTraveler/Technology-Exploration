package com.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Location implements Serializable{
    
    private int row;
    private int column;
    private boolean visited;
    private String completed;
    private Scene scene; 
    private ArrayList<Actor> actors;
    private String description;
    private String mapSymbol;

    public Location() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", completed=" + completed + ", scene=" + scene + ", actors=" + actors + ", description=" + description + ", mapSymbol=" + mapSymbol + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.row;
        hash = 59 * hash + this.column;
        hash = 59 * hash + (this.visited ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.completed);
        hash = 59 * hash + Objects.hashCode(this.scene);
        hash = 59 * hash + Objects.hashCode(this.actors);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.mapSymbol);
        return hash;
        
    }//End hashCode()

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Location other = (Location) obj;
        
        if (this.row != other.row) {
            return false;
        }
        
        if (this.column != other.column) {
            return false;
        }
        
        if (this.visited != other.visited) {
            return false;
        }
        
        if (!Objects.equals(this.completed, other.completed)) {
            return false;
        }
        
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        
        return true;
        
    }//End equals() 
    
}//END
