package com.alberto.arellano.Junk;

import javax.swing.*;
import java.awt.event.ActionListener;
/**
 * Created by rome on 10/9/2015.
 */
public class View extends JFrame {

    // Interface
    private JTextField firstName    = new JTextField(10);
    private JLabel CommaLabel       = new JLabel(",");
    private JTextField lastName     = new JTextField(10);
    private JButton addButton       = new JButton("Add To BlackList");

    private JTextField confirmation = new JTextField(30);

    // Default Constructor
    public View() {
        // Create Panel
        JPanel userInterfacePanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        // Add Components
        userInterfacePanel.add(firstName   );
        userInterfacePanel.add(CommaLabel  );
        userInterfacePanel.add(lastName    );
        userInterfacePanel.add(addButton   );
        userInterfacePanel.add(confirmation);
        // Add Panel Itself
        this.add(userInterfacePanel);
    }


    public String getFirstName() {
        return firstName.getText();
    }

    public String getSecondName(){
        return lastName.getText();
    }
    public String getConfirmation(){
        return confirmation.getText();
    }
    public void setConfirmation(String confirmationFromDB){
            confirmation.setText(confirmationFromDB);
    }
    // Run It
    void addToDBListener(ActionListener addUserButton){
        addButton.addActionListener(addUserButton);
    }
    // Handle User Input
    void displayMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
