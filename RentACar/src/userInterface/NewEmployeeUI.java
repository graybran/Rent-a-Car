package userInterface;

import javax.swing.JOptionPane;
import core.*;

public class NewEmployeeUI extends javax.swing.JPanel
{

    /**
     * Creates new form NewJPanel
     */
    public NewEmployeeUI()
    {
        initComponents();
        
        // Adds an "OK" and "CANCEL" dialog
        int result = JOptionPane.showConfirmDialog(null, this, "New Rental",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Logic for OKAY or CANCEL button press
        if (result == JOptionPane.OK_OPTION) 
        {
            // When OK is pressed, input logic here to store data to database
            // e.g.
            // rental.car.make = "Toyota";
            // rental.car.year = 1999;
        } 
        else 
        {
            System.out.println("Cancelled");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lastNameLabel = new javax.swing.JLabel();
        emmpIDLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        empIDField = new javax.swing.JTextField();

        lastNameLabel.setText("Last Name");

        emmpIDLabel.setText("Employee ID");

        firstNameLabel.setText("First Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addComponent(firstNameField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emmpIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empIDField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emmpIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emmpIDLabel;
    private javax.swing.JTextField empIDField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    // End of variables declaration//GEN-END:variables
}
