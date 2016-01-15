package com.game.model;

import java.io.Serializable;
import java.util.Objects;

public class HolyCitadel implements Serializable {
    private String description;
    boolean dead;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public HolyCitadel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Holy Citadel{" + "description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.description);
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
        final HolyCitadel other = (HolyCitadel) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
}
