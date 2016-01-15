package com.alberto.arellano.JavaCollections; /**
 * Created by rome on 9/25/2015.
 */
import java.util.ArrayList;
import java.lang.reflect.Field;

public class findCapacity {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(3);
        for (int i = 0; i < 17; i++) {
            list.add(i);
            System.out.format("Size: %2d, Capacity: %2d%n",
                    list.size(), getCapacity(list));
        }
    }

    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
