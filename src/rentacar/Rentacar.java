/*
    Main class. Class initiates program
*/

package rentacar;

import userInterface.RentacarUI;
import core.*;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rentacar
{
    
    public static void main(String[] args) throws FileNotFoundException
    {
        try {
            File customerBase = new File("CustomerBase.txt");
            File carBase = new File("CarBase.txt");
            File rentalBase = new File("RentalBase.txt");
            
            customerBase.createNewFile();
            carBase.createNewFile();
            rentalBase.createNewFile();
        }
        catch(Exception ex) {
            System.out.println("Error: Could not create files. " + 
                    "Please try again. " + ex.getMessage());
            System.exit(1);
        }
        CarInventorySystem carDB = new CarInventorySystem();
        CustomerStorageSystem custDB = new CustomerStorageSystem();
                
        // Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {

                new RentacarUI().setVisible(true);
            }
        });
    }
}