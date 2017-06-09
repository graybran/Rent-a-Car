/*
    Main class. Class initiates program
*/

package rentacar;

import userInterface.RentacarUI;
import java.io.*;
import java.util.*;

public class Rentacar
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Creates text files as a fake, temporary database
        /*
        try
        {
            File customerTable = new File("Customer-Table.txt");
            File vehicleTable = new File("Vehicle-Table.txt");
            File employeeTable = new File("Employee-Table.txt");

            // Creates file when txt file does not exist
            if(!customerTable.exists())
                customerTable.createNewFile();
            if(!vehicleTable.exists())
                vehicleTable.createNewFile();
            if(!employeeTable.exists())
                employeeTable.createNewFile();

            // Creates file writers file addendums
            FileWriter fwCustomer = new FileWriter("Customer-Table.txt", true);
            BufferedWriter bwCustomer = new BufferedWriter(fwCustomer);
            PrintWriter outCustomer = new PrintWriter(bwCustomer);

            FileWriter fwVehicle = new FileWriter("Vehicle-Table.txt", true);
            BufferedWriter bwVehicle = new BufferedWriter(fwVehicle);
            PrintWriter outVehicle = new PrintWriter(bwVehicle);

            FileWriter fwEmployee = new FileWriter("Employee-Table.txt", true);
            BufferedWriter bwEmployee = new BufferedWriter(fwEmployee);
            PrintWriter outEmployee = new PrintWriter(bwEmployee);

            // Finish editting files
            outCustomer.close();
            outVehicle.close();
            outEmployee.close();
        } catch(IOException ioe)
        {
             System.out.println("Exception occurred:");
             ioe.printStackTrace();
        }
        */
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new RentacarUI().setVisible(true);
            }
        });
    }
    
}
