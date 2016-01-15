package com.game.model;

import java.io.Serializable;
import java.util.Objects;

public class Scene implements Serializable{

    String description;
    String mapSymbol;
    
    
    public Scene() {
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
        return "Scene{" + "description=" + description + ", mapSymbol=" + mapSymbol + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.mapSymbol);
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        return true;
    }
    
}//END
