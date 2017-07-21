package userInterface;

import core.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class UpdateCustomerUI extends javax.swing.JPanel {

    /**
     * Creates new form UpdateCustomerUI
     */
    public UpdateCustomerUI() throws FileNotFoundException {
        initComponents();
        
        int result = JOptionPane.showConfirmDialog(null, this, "Update Customer", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Logic for OKAY or CANCEL button press
        if (result == JOptionPane.OK_OPTION) 
        {
            if(ValidateInput()) 
            {
                CustomerStorageSystem customerSystem = new CustomerStorageSystem();
                Customer updateThisCustomer = customerSystem.SearchCustomer(Integer.parseInt(findIDField.getText()));
                
                if(ValidateIDExists(updateThisCustomer)) 
                {
                    String searchFirstName = findFirstNameField.getText();
                    String searchLastName = findLastNameField.getText();
                    int newAge = Integer.parseInt(newAgeField.getText());
                    String newPhoneNumber = newPhoneNumberField.getText();
                    String newEmailAddress = newEmailAddrField.getText();
                    
                    updateThisCustomer.setFirstName(searchFirstName);
                    updateThisCustomer.setLastName(searchLastName);
                    updateThisCustomer.setAge(newAge);
                    updateThisCustomer.setPhoneNumber(newPhoneNumber);
                    updateThisCustomer.setEmailAddress(newEmailAddress);

                    // Updates the database, overwriting old one
                    try
                    {
    //                        searchInventory.UpdateDatabase(updateThisVehicle, toUpdate);
                        customerSystem.UpdateDatabase(updateThisCustomer);
                    }
                    catch(Exception e)
                    {
                        // RIP
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Error: Customer "
                            + "does not exist. Please try again.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please Enter an ID or both Last and First Name.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else 
        {
            System.out.println("Cancelled");
        }
    }
    
    private boolean ValidateInput() 
    {
        if(findIDField.getText().isEmpty() &&
                (findFirstNameField.getText().isEmpty() &&
                findLastNameField.getText().isEmpty())) 
        {
            return false;
        }
        
        return true;
    }
    
    private boolean ValidateNameInput() 
    {
        if(findFirstNameField.getText().isEmpty() &&
                findLastNameField.getText().isEmpty()) 
        {
            return false;
        }
        
        return true;
    }
    
    private boolean ValidateIDExists(Customer found) 
    {
        return (found != null);
    }
    
    // When search button by ID is pressed
    private void updateTextFieldsFromIDWithResults() throws FileNotFoundException
    {
        if(ValidateInput()) 
        {
            CustomerStorageSystem searchCustomer = new CustomerStorageSystem();
            Customer updateThisCustomer = searchCustomer.SearchCustomer(Integer.parseInt(findIDField.getText()));

            if(ValidateIDExists(updateThisCustomer)) 
                updateText(updateThisCustomer);
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Customer with "
                        + "that ID does not exist. Please try again.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please enter an ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // When search button by names is pressed
    private void updateTextFieldsFromNameWithResults() throws FileNotFoundException
    {
        if(ValidateNameInput()) 
        {
            CustomerStorageSystem searchCustomer = new CustomerStorageSystem();
            Customer updateThisCustomer = 
                    searchCustomer.SearchCustomer(findFirstNameField.getText(), findLastNameField.getText());

            if(ValidateIDExists(updateThisCustomer)) 
                updateText(updateThisCustomer);
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Customer with "
                        + "that name does not exist. Please try again.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please enter both First and Last names.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateText(Customer updateThisCustomer)
    {
        findLastNameField.setText(updateThisCustomer.getLastName());
        findFirstNameField.setText(updateThisCustomer.getFirstName());
        findIDField.setText(Integer.toString(updateThisCustomer.getCustID()));
        newAgeField.setText(Integer.toString(updateThisCustomer.getAge()));
        newPhoneNumberField.setText(updateThisCustomer.getPhoneNumber());
        newEmailAddrField.setText(updateThisCustomer.getEmailAddress());
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

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        findLastNameField = new javax.swing.JTextField();
        findFirstNameField = new javax.swing.JTextField();
        idField = new javax.swing.JLabel();
        findIDField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idSearch = new javax.swing.JButton();
        nameSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newAgeField = new javax.swing.JTextField();
        newPhoneNumberField = new javax.swing.JTextField();
        newEmailAddrField = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel1.setText("Last Name");

        jLabel2.setText("First Name");

        idField.setText("ID");

        jLabel6.setText("----------------------------or----------------------------");

        idSearch.setText("Search");
        idSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                idSearchActionPerformed(evt);
            }
        });

        nameSearch.setText("Search");
        nameSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nameSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(findLastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(findFirstNameField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField)
                    .addComponent(findIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(findLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(findFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameSearch))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Update"));

        jLabel3.setText("Age");

        jLabel4.setText("Phone Number");

        jLabel5.setText("Email Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(newPhoneNumberField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(newAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(newEmailAddrField)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newEmailAddrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_idSearchActionPerformed
    {//GEN-HEADEREND:event_idSearchActionPerformed
        try
        {
            updateTextFieldsFromIDWithResults();
        }
        catch(FileNotFoundException e)
        {
            // RIP
        }
    }//GEN-LAST:event_idSearchActionPerformed

    private void nameSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nameSearchActionPerformed
    {//GEN-HEADEREND:event_nameSearchActionPerformed
        try
        {
            updateTextFieldsFromNameWithResults();
        }
        catch(FileNotFoundException e)
        {
            // RIP
        }
    }//GEN-LAST:event_nameSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField findFirstNameField;
    private javax.swing.JTextField findIDField;
    private javax.swing.JTextField findLastNameField;
    private javax.swing.JLabel idField;
    private javax.swing.JButton idSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton nameSearch;
    private javax.swing.JTextField newAgeField;
    private javax.swing.JTextField newEmailAddrField;
    private javax.swing.JTextField newPhoneNumberField;
    // End of variables declaration//GEN-END:variables
}
