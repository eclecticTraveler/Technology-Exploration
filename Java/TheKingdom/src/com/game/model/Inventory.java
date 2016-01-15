package com.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Inventory implements Serializable{
    
    String item;
    int itemCount = 0;

    public Inventory() {
    }

    public ArrayList<Item> inventory = new ArrayList<>();

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Inventory{" + "item=" + item + ", itemCount=" + itemCount + ", inventory=" + inventory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.item);
        hash = 89 * hash + this.itemCount;
        hash = 89 * hash + Objects.hashCode(this.inventory);
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
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (this.itemCount != other.itemCount) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }
    
}//END
