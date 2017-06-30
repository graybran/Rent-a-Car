package userInterface;

import javax.swing.JOptionPane;
import core.*;
import java.io.FileNotFoundException;

public class NewCustomerUI extends javax.swing.JPanel
{
    
    boolean unitTesting = true;

    /**
     * Creates new form NewJPanel
     * @throws java.io.FileNotFoundException
     */
    public NewCustomerUI() throws FileNotFoundException
    {
        initComponents();
        
        // Adds an "OK" and "CANCEL" dialog
        int result = JOptionPane.showConfirmDialog(null, this, "New Customer",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Logic for OKAY or CANCEL button press
        if (result == JOptionPane.OK_OPTION) 
        {
            
            // When OK is pressed, input logic here to store data to database
            // BUG: All input fields must be entered or application will crash
            // TODO: Check user input. Before closing. Must be implemented with a custom dialog
//            String first = firstNameField.getText();
//            String last = lastNameField.getText();
//            int age = Integer.parseInt(ageField.getText());
//            String email = emailField.getText();
//            String phone = phoneField.getText();
            
            // For debugging purposes:
            // System.out.println(first + " " + last);
            
            if(ValidateInput()) {
                int id = Integer.parseInt(idNumberField.getText());
                String first = firstNameField.getText();
                String last = lastNameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String phone = phoneField.getText();
                String email = emailField.getText();
                
               // if(!unitTesting) {
                    CustomerStorageSystem customerSystem = new CustomerStorageSystem(null);
                    customerSystem.RegisterCustomer(id, first, last, age, phone, email);
               // }
            }
            else {
                JOptionPane.showMessageDialog(null, "Some fields are blank. "
                        + "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
//            Customer addedCustomer = new Customer();
//            addedCustomer.setFirstName(first);
//            addedCustomer.setLastName(last);
//            addedCustomer.setAge(age);
//            addedCustomer.setPhoneNumber(phone);
//            addedCustomer.setEmailAddress(email);
//            addedCustomer.StoreCustomer();
            
//            CustomerStorageSystem customerSystem = new CustomerStorageSystem();
//            customerSystem.RegisterCustomer(first, last, age, phone, email);
        } 
        else 
        {
            System.out.println("Cancelled");
        }
        
    }
    
    private boolean ValidateInput() {
        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || 
                ageField.getText().isEmpty() || phoneField.getText().isEmpty() || 
                emailField.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lastNameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idNumberField = new javax.swing.JTextField();

        lastNameLabel.setText("Last Name");

        phoneLabel.setText("Phone Number");

        firstNameLabel.setText("First Name");

        emailLabel.setText("Email Address");

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        ageLabel.setText("Age");

        jLabel1.setText("ID Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(8, 8, 8)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField)
                            .addComponent(firstNameField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ageField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(idNumberField))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    public javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    public javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    public javax.swing.JTextField idNumberField;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    public javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    // End of variables declaration//GEN-END:variables
}
