package userInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewRentalsUI extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    public ViewRentalsUI() {
        initComponents();
        int result = JOptionPane.showConfirmDialog(null, this, "View Rentals",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }
	 
	 private void displayRentals()
	 {
		 try {
			 Scanner in = new Scanner(new FileReader("RentalBase.txt"));
			 int i;
			 
			 jTextArea1.setText("Rental Information:\n\n");
			 
			 while(in.hasNext())
			 {
				 String vehicleID = in.next();
				 String make = in.next();
				 String model = in.next();
				 String color = in.next();
				 String year = in.next();
				 String carClass = in.next();
				 String price = in.next();
				 String firstName = in.next();
				 String lastName = in.next();
				 String age = in.next();
				 String phoneNumber = in.next();
				 String email = in.next();
				 
				 jTextArea1.append("Vehicle ID #" + vehicleID + ": " + year + " " + make + " " + model + "\n");
				 jTextArea1.append("Customer: " + firstName + " " + lastName + "\n" + "Contact: " + phoneNumber + "\n\n");
				 
			 }
			 
			 in.close();
			 
		 } catch (FileNotFoundException ex) {
			 Logger.getLogger(ViewRentalsUI.class.getName()).log(Level.SEVERE, null, ex);
		 }
	 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTextArea1 = new javax.swing.JTextArea();
      jButton1 = new javax.swing.JButton();

      setLayout(new java.awt.BorderLayout());

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rentals"));

      jTextArea1.setColumns(20);
      jTextArea1.setRows(5);
      jScrollPane2.setViewportView(jTextArea1);

      jButton1.setText("View Rentals");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton1)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addContainerGap())
      );

      add(jPanel1, java.awt.BorderLayout.LINE_END);
   }// </editor-fold>//GEN-END:initComponents

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      displayRentals();
   }//GEN-LAST:event_jButton1ActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextArea jTextArea1;
   // End of variables declaration//GEN-END:variables
}
