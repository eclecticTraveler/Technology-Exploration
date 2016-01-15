package com.alberto.arellano.JavaCollections; /**
 * Created by rome on 9/28/2015.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class MapExperimentation {
    public static void main(String[] args) {

        /************************************************
         *  _   _           _      ___  ___
         * | | | |         | |     |  \/  |
         * | |_| | __ _ ___| |__   | .  . | __ _ _ __
         * |  _  |/ _` / __| '_ \  | |\/| |/ _` | '_ \
         * | | | | (_| \__ \ | | | | |  | | (_| | |_) |
         * \_| |_/\__,_|___/_| |_| \_|  |_/\__,_| .__/
         *                                      | |
         *                                      |_|
         *
         * HashMap is not guaranteed to have its keys sorted
         * and when you iterate over the kyes you can't be
         * sure what order they will be in. This type of Map
         * will be more efficient. This type of Map will be
         * more efficient in general so use it whenever you
         * don't care about the order of the keys.
         **************************************************/
        Map hashMap = new HashMap();
        hashMap.put("Noam Chomsky "    , " 86 years old" );
        hashMap.put("Michel Foucault " , " 90 years old" );
        hashMap.put("Robert Reich "    , " 69 years old" );
        hashMap.put("Emma Goldman "    , " 146 years old");
        // If I put 3 inputs with the same value and key it will only display it once
        hashMap.put("Alberto Arellano ", " 26 years old" );
        hashMap.put("Alberto Arellano ", " 26 years old" );
        hashMap.put("Alberto Arellano ", " 26 years old" );
        // But if its slighty different
        hashMap.put("Alberto Arellan " , " 25 years old" );
        hashMap.put(-2 , "  Be Negative" );

        try
        {
            hashMap.put( null , "Be First" );
        }
        catch (Exception e)
        {
            System.out.println("Null was not acceptable");
        }

        try
        {
            hashMap.put( "Key" , "Value" );
        }
        catch (Exception e)
        {
            System.out.println("Key is missing");
        }

        System.out.println("---------------------------------");
        System.out.println(" Hash Map Elements:");
        System.out.print("\t" + hashMap);

        try
        {
            hashMap.remove("K");
        }
        catch (Exception e)
        {
            System.out.println("Key is missing");
        }
        System.out.println("---------------------------------");
        System.out.println(" Hash Map Elements:");
        System.out.print("\t" + hashMap);

        /************************************************
         * _____              ___  ___
         *|_   _|             |  \/  |
         *  | |_ __ ___  ___  | .  . | __ _ _ __
         *  | | '__/ _ \/ _ \ | |\/| |/ _` | '_ \
         *  | | | |  __/  __/ | |  | | (_| | |_) |
         *  \_/_|  \___|\___| \_|  |_/\__,_| .__/
         *                                 | |
         *                                 |_|
         *
         * TreeMap IS guaranteed to have its keys sorted
         * and when you iterate over the kyes you CAN be
         * sure that the order will be there. This type of Map
         * will be less efficient. Use it whenever you
         * CARE about the order of the keys.
         **************************************************/

        TreeMap treeMap = new TreeMap();
        // Put elements to the map
        treeMap.put("Eliane", new Double(3000.34));
        treeMap.put("Tinho" , new Double(123.22 ));
        treeMap.put("Israel", new Double(1378.00));
        treeMap.put("Nolan" , new Double(99.22  ));
        treeMap.put("Beto"  , new Double(-19.08 ));

        // In order to iterate through a treeMap you can do
        // two things create your iterator (HARD) or place
        // the keys on a SET which is a list with unique values
        // and use the built-in iterator to loop through them (EASY)

        // So lets cast the treeMap into the set
        Set set = treeMap.entrySet();

        // Invoke the mighty iterator and place the set into it
        Iterator i = set.iterator();

        // Now with a While loop lets display
        // all the elements of the set that is on the i
        while(i.hasNext())
        {
            // Cast i into a Map.Entry that returns a
            // collection-view of the map.
            Map.Entry mapEntry = (Map.Entry)i.next();

            // NOW YOU NEED THE NEXT TWO LINES TO PRINT KEYS AND VALUES
            // Print those values by Key
            System.out.print(mapEntry.getKey() + ": ");
            // Print those values by values
            System.out.println(mapEntry.getValue());
        }

        System.out.println();

        // Now let us modify the TreeMap by adding or
        // depositing a 1000 into Eliane's account here is how we will do it

        // Get the person you want to add the money to by using
        // treeMap.get("Eliane")
        // Know we cast it into a Double and automatically will get its value
        double newBalance = ((Double)treeMap.get("Eliane")).doubleValue();
        // Then use treeMap.put with the Value and Key
        treeMap.put("Eliane", new Double(newBalance + 1000));
        // Voula!!
        System.out.println("Eliane's new balance: " +
                treeMap.get("Eliane"));
    }
}
