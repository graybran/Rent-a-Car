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
//    public static fakeDatabase DB = new fakeDatabase();
    
    public static void main(String[] args) throws FileNotFoundException
    {
        try {
            File customerBase = new File("CustomerBase.txt");
            File carBase = new File("CarBase.txt");
            
            customerBase.createNewFile();
            carBase.createNewFile();
        }
        catch(Exception ex) {
            System.out.println("Error: Could not create files. " + 
                    "Please try again. " + ex.getMessage());
            System.exit(1);
        }
        CarInventorySystem carDB = new CarInventorySystem(null);
        CustomerStorageSystem custDB = new CustomerStorageSystem(null);
        /*
        try {
//            DB.initDBpopulator();
            DB.CreateCustomerBase();
            //DB.CreateCarBase();
        } 
//        catch (FileNotFoundException | UnsupportedEncodingException ex) {
        catch(IOException ex) {
            Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
                
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
        
        /*
        try {
            DB.CreateCustomerBase();
        } catch (IOException ex) {
            Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
    /*
    //These may be redundant (possibly go straight to fakeDB class)
    public static Rental DBgetter(Integer ID){
        return DB.get(ID);
        
    }
    public static void DBupdater(Rental renter, Integer ID){
        DB.set(renter, ID);
        
    }
    */
    
    /*
    private static void PrintCustomerBase() {
        Customer cust = new Customer();
        ArrayList<Customer> customerBase = cust.getCustomers();
        
        FileWriter custEntry;
        try {
            custEntry = new FileWriter("CustomerBase.txt", true);
            for(int i=0;i<customerBase.size();i++) {
                custEntry.write(customerBase.get(i).getFirstName() + "\t ");
                custEntry.write(customerBase.get(i).getLastName() + "\t ");
                custEntry.write(customerBase.get(i).getAge() + "\t ");
                custEntry.write(customerBase.get(i).getPhoneNumber() + "\t ");
                custEntry.write(customerBase.get(i).getEmailAddress() + "\t ");
            }
            custEntry.close();
        } catch (IOException ex) {
            Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }  
    }
    */
}