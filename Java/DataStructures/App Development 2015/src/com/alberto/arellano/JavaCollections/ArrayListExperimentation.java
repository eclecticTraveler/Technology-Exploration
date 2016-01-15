package com.alberto.arellano.JavaCollections; /**
 * Created by (Rome) Alberto Arellano on 9/23/2015.
 */
import java.util.ArrayList;
public class ArrayListExperimentation {
    public static void main(String[] args) {
        // Lets instantiate an ArrayList of Strings Object
        ArrayList<String> lst = new ArrayList<String>();

        // Elements added to Array List Normally
        lst.add("Cat"  );
        lst.add("Dog"  );
        lst.add("Chair");
        lst.add("Floor");
        lst.add("Food" );

        // Displaying Array list normally
        System.out.println("First Stage of Array List:" + lst);
        System.out.println("-------------------------------------------\n");

        // Now if I add elements with an specific index then the rest of the elements
        // will be pushed off
        // Add element at the given index
        lst.add(0, "Wall" );
        lst.add(1, "Couch");
        lst.add(2, "Foo");

        // But if I later add another one where an item is alredy there it gets pushed off as well
        // if I explicitly declare it
        lst.add(2, "Kolob");

        System.out.println("After Adding 3 of them the Current array list is:" + lst);
        System.out.println("-------------------------------------------\n");

        // If I remove elements that don't exist in the list no exception is thrown and nothing happens
        lst.remove("Floor");
        lst.remove("Noam");

        System.out.println("After Deleting 2 of them the Current array list is:" + lst);
        System.out.println("-------------------------------------------\n");

        // Print size of current array it should have 8 spots
        System.out.println("Current size of list is: " + lst.size());

        // Lets add 1 more
        lst.add("One More");
        // Now lets see if the size increased by one or by more than one
        System.out.println("Size after adding 1 item in list is: " + lst.size());
        System.out.println("Capacity after adding 1 item in list is: ") ;


        // Lets add 2 more
        lst.add("Two");
        lst.add("Three");

        // Now lets see if the size increased by one or by more than one
        System.out.println("Size after adding 2 item in list is: " + lst.size());

        // Lets add something in index 13 when we only have 11 spots
        // An exception will be thrown saying Yo! we only have 11 Spots
        try
        {
            lst.add(13, "13");
        }
        catch (Exception e)
        {
            System.out.println("Yo! we only have 11 Spots");
        }
        // I can remove elements from the given index
        lst.remove(0);

        // but If I remove elements with a negative index
        // An exception is thrown
        try
        {
            lst.remove(-2);
        }
        catch (Exception e)
        {
            System.out.println("You cannot remove from a negative number because there are not negative spots");
        }
        // If I try to insert on a negative index and exception is thrown
        try
        {
            lst.add(-2, "Hello");
        }
        catch (Exception e)
        {
            System.out.println("You cannot allocate using a negative number because there are not negative spots");
        }
        // If I try to add an element in an index that is way off like 1000
        // It throws and exception saying that the size is not even that big just yet
        try
        {
            lst.add(1000, "Hello");
        }
        catch (Exception e)
        {
            System.out.println("You cannot allocate on an index where arraylist has not available size of capacity");
            e.printStackTrace();
        }
        // If I send an item to the maximum spot in the list
        lst.add("Hello");
        System.out.println("Current array list is:" + lst);



    }

}


