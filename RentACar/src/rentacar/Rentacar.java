/*
    Main class. Class initiates program
*/

package rentacar;

import userInterface.RentacarUI;
import core.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rentacar
{
    public static fakeDatabase DB = new fakeDatabase();
    
    public static void main(String[] args)
    {
        
        
        
        try {
            DB.initDBpopulator();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
        }
                
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
    
    
    //These may be redundant (possibly go straight to fakeDB class)
    public static Rental DBgetter(Integer ID){
        return DB.get(ID);
        
    }
    public static void DBupdater(Rental renter, Integer ID){
        DB.set(renter, ID);
        
    }
}
