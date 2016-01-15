package com.alberto.arellano.MVC;

/**
 * Created by rome on 10/13/2015.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBank {

    // Obtain objects Straight off the bat on the constructor
    public ControllerBank(ViewBank view, ModelBank model){
        // Obtain View and Model Instance
        this.view  = view;
        this.model = model;

        // Make the View know that if the button is pressed it should
        // pick up input and hand it down so that eventually could be saved in Model
         this.view.addToDBListener(new panelListener());
    }


    // My variables
    private ViewBank view;
    private ModelBank model;


    class panelListener implements ActionListener{
        // Important method that is need it to explain what should happen when button is pressed
        public void actionPerformed(ActionEvent e){

            // Initialize two variables
            String userName, socSec;


                // Get Input from the View when button is clicked
                userName = view.getUserName();
                socSec   = view.getSocSec();

                if (!userName.equals("") && !socSec.equals("")) {
                    // Once we got the input we will now pass it to the Model to save it
                    // Pass the Key and Value
                    model.addToDatabase(socSec, userName);

                    // After storing those values to the "database" we will send the proper message to
                    // the user from this Controller and we will pass it to the view to be displayed
                    if(model.confirmDatabaseInsertion(socSec)) {
                             view.setConfirmation("Information Saved in Database!");
                    } else{
                             view.setConfirmation("Unable to Save in Database");
                    }

                    // Reset the input text fields
                    view.setSocSec("");
                    view.setUserName("");

                }else {

                    // If there is a field missing then we will punish the user
                    // By passing the proper message to the view
                    view.displayMessage("You need to fill all the input spaces SIR!!!");
                }






        }

    }
}
