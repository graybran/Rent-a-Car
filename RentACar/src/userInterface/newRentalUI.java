package userInterface;

import java.awt.*;
import javax.swing.*;

public class newRentalUI
{
    public static void display() 
    {
        // Variables
        JTextField lastNameField = new JTextField("", 20);
        JTextField firstNameField = new JTextField("");
        // Create panel with as many rows as needed; 3 columns wide
        JPanel panel = new JPanel(new GridLayout(0, 2));    
        
        
        // Adds a writeable text field with their labels
        panel.add(new JLabel("Last Name"));         // Label for text field
        panel.add(lastNameField);                   // 2-column wide Text field 
        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);
        
        // Adds an "OK" and "CANCEL" dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "New Rental",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Logic for OKAY or CANCEL button press
        if (result == JOptionPane.OK_OPTION) 
        {
            // When OK is pressed, input logic here to store data to database
        } 
        else 
        {
            System.out.println("Cancelled");
        }
    }
}
