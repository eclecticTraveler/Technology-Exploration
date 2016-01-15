package com.game.model;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    
    private String description;
    private int requiredAmount;
    private int actualAmount;
    boolean selected;

    public Item() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public int getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(int actualAmount) {
        this.actualAmount = actualAmount;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Item{" + "description=" + description + ", requiredAmount=" + requiredAmount + ", actualAmount=" + actualAmount + ", selected=" + selected + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + this.requiredAmount;
        hash = 59 * hash + this.actualAmount;
        hash = 59 * hash + (this.selected ? 1 : 0);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.requiredAmount != other.requiredAmount) {
            return false;
        }
        if (this.actualAmount != other.actualAmount) {
            return false;
        }
        if (this.selected != other.selected) {
            return false;
        }
        return true;
    }
    
}//END
