package com.alberto.arellano.MVC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Created by rome on 10/13/2015.
 */
public class ModelBank {

    public ModelBank(){

    }

    // Save to Database values passed down by the Controller
    public void addToDatabase(String userSocSecKey, String userNameValue){
        try{
            dataBase.put(userSocSecKey, userNameValue);

        }
        catch (Exception e){
            System.out.println("MODEL says: Could not add values to DataBase");
            e.printStackTrace();

        }
    }

    // After saving user input in database we will confirm
    public Boolean confirmDatabaseInsertion(String userSocSecKey){
        return dataBase.containsKey(userSocSecKey);


    }

    //  A map cannot contain duplicate keys
    private TreeMap<String, String> dataBase = new TreeMap<String, String>();


//    private String dataBaseInfo = "Entry: " + String.valueOf("DatabaseInfo.txt");
//    FileWriter fstream = new FileWriter(dataBaseInfo);
//    BufferedWriter out = new BufferedWriter(fstream);
//
//    for(Map.Entry<String, String>entry : database.entrySet()){
//        // Print the keys and values
//        System.out.print("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        out.write(entry.getKey() + "\t" + entry.getValue());
//        System.out.println("Done");
//        out.flush(); // Flush the buffer and write all changes to the disk
//    }
//    out.close(); // Close file

}
