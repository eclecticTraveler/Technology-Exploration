package com.alberto.arellano.MVC;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

/**
 * Created by rome on 10/13/2015.
 */
public class ViewBank extends JFrame {

    // Interface
    private JTextField userName     = new JTextField("User Name");
    private JLabel CommaLabel       = new JLabel(",");
    private JTextField socSec       = new JTextField("Social Security");
    private JButton addButton       = new JButton("Add To Database");

    private JTextField confirmation = new JTextField(30);

    // Default Constructor
    public ViewBank() {
        // Create Panel
        JPanel userInterfacePanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);

        // Add Components
        userInterfacePanel.add(userName    );
        userInterfacePanel.add(CommaLabel  );
        userInterfacePanel.add(socSec      );
        userInterfacePanel.add(addButton   );
        userInterfacePanel.add(confirmation);
        // Add Panel to Frame
        this.add(userInterfacePanel);
    }

    // Getter for the text that will be input it on the button
    public String getUserName() {
        return userName.getText();
    }
    public String getSocSec(){
        return socSec.getText();
    }
    public String getConfirmation(){
        return confirmation.getText();
    }

    // Setter for those input text fields
    public void setConfirmation(String confirmationFromDB){confirmation.setText(confirmationFromDB); }
    public void setUserName(String expectNewString) { userName.setText(expectNewString); }
    public void setSocSec(String expectString){ socSec.setText(expectString);}

    // Run It Here I implement an active listener that will trigger the logic in the Controller
    void addToDBListener(ActionListener listenForUserButton){
        addButton.addActionListener(listenForUserButton);
    }
    // Handle User Input
    void displayMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

//    @Override
//    public void focusGained(FocusEvent e){
//        if(this.getText().isEmpty()){
//            super.setText("");
//            showingHint
//
//        }
//    }
//
}
