package userInterface;

import core.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class UpdateVehicleUI extends javax.swing.JPanel {

    /**
     * Creates new form UpdateCarUI
     */
    public UpdateVehicleUI() throws FileNotFoundException
    {
        initComponents();
        
        // Adds an "OK" and "CANCEL" dialog
        int result = JOptionPane.showConfirmDialog(null, this, "Update Inventory",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Logic for OKAY or CANCEL button press
        if (result == JOptionPane.OK_OPTION) 
        {
            if(ValidateInput()) 
            {
                // KEEP these lines
                CarInventorySystem searchInventory = new CarInventorySystem();
                Vehicle updateThisVehicle = searchInventory.SearchVehicle(Integer.parseInt(searchIDField.getText()));
                
                if(ValidateIDExists(updateThisVehicle)) 
                {
                    int id = Integer.parseInt(searchIDField.getText());
                    
                    // Declarations with built in error checking
                    String make = newMakeField.getText().isEmpty() ? updateThisVehicle.getMake() : newMakeField.getText();
                    String model = newModelField.getText().isEmpty() ? updateThisVehicle.getModel() : newModelField.getText();
                    String color = newColorField.getText().isEmpty() ? updateThisVehicle.getColor() : newColorField.getText();
                    int year =newYearField.getText().isEmpty() ? updateThisVehicle.getYear() : Integer.parseInt(newYearField.getText());
                    String carClass = newClassField.getText().isEmpty() ? updateThisVehicle.getCarClass() : newClassField.getText();
                    double dailyPrice = newDailyPriceField.getText().isEmpty() ? 
                                        updateThisVehicle.getDailyPrice() : 
                                        Double.parseDouble(newDailyPriceField.getText());
                    
                    // For availability
                    boolean availability;
                    if(newAvailability.getSelectedItem().toString().equals(" "))
                        availability = updateThisVehicle.isAvailability();
                    else
                        availability = newAvailability.getSelectedItem().toString().equals("Available");
                    
                    double gas = Double.parseDouble(newGasField.getText());
                    int mileage = Integer.parseInt(newMileageField.getText());
                    String dmgNotes = newDmgNotesField.getText();
                    
                    // For Maintenance
                    SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
                    Date date = null;
                    try 
                    {
                        date = format.parse(maintenanceField.getText());
                    } 
                    catch (ParseException e) 
                    {
                        e.printStackTrace();
                    }
                                        
                    // Update vehicle info with any entered text
                    updateThisVehicle.setID(id);
                    updateThisVehicle.setMake(make);
                    updateThisVehicle.setModel(model);
                    updateThisVehicle.setColor(color);
                    updateThisVehicle.setYear(year);
                    updateThisVehicle.setCarClass(carClass);
                    updateThisVehicle.setAvailability(availability);
                    updateThisVehicle.setDailyPrice(dailyPrice);
                    updateThisVehicle.setGas(gas);
                    updateThisVehicle.setMileage(mileage);
                    updateThisVehicle.setNextMaintenance(date);
                    updateThisVehicle.setDmgNotes(dmgNotes);

                    // Updates the database, overwriting old one
                    try
                    {
//                        searchInventory.UpdateDatabase(updateThisVehicle, toUpdate);
                        searchInventory.StoreVehicle(updateThisVehicle, true);
                    }
                    catch(Exception e)
                    {
                        // RIP
                    }
                    
                    JOptionPane.showMessageDialog(null, "Vehicle Modified", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Error: Vehicle with "
                            + "that ID number does not exist. Please try again.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Please enter an ID.",
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
        return !(searchIDField.getText().isEmpty());
    }

    private boolean ValidateIDExists(Vehicle found) 
    {
        return (found != null);
    }
    
    private void updateTextFieldsWithResults() throws FileNotFoundException
    {
        if(ValidateInput()) 
        {
            CarInventorySystem searchInventory = new CarInventorySystem();
            Vehicle updateThisVehicle = searchInventory.SearchVehicle(Integer.parseInt(searchIDField.getText()));

            if(ValidateIDExists(updateThisVehicle)) 
            {
                updateText(updateThisVehicle);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Vehicle with "
                        + "that ID number does not exist. Please try again.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please enter an ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateText(Vehicle updateThisVehicle)
    {
        newMakeField.setText(updateThisVehicle.getMake());
        newModelField.setText(updateThisVehicle.getModel());
        newColorField.setText(updateThisVehicle.getColor());
        newYearField.setText(Integer.toString(updateThisVehicle.getYear()));
        newClassField.setText(updateThisVehicle.getCarClass());
        newDailyPriceField.setText(Double.toString(updateThisVehicle.getDailyPrice()));
        newAvailability.setSelectedItem(updateThisVehicle.isAvailability() ? "Available" : "Not Available");
        newGasField.setText(Double.toString(updateThisVehicle.getGas()));
        maintenanceField.setText(dateToString(updateThisVehicle));
        newMileageField.setText(Integer.toString(updateThisVehicle.getMileage()));
        newDmgNotesField.setText(updateThisVehicle.getDmgNotes());
    }
    
    // Convert Date object in vehicle to String
    private String dateToString(Vehicle vehicle)
    {
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy"); 
        String maintenance = format.format(vehicle.getNextMaintenance());
        
        return maintenance;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchIDField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newModelField = new javax.swing.JTextField();
        newMakeField = new javax.swing.JTextField();
        newColorField = new javax.swing.JTextField();
        newYearField = new javax.swing.JTextField();
        newClassField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        newDailyPriceField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        newAvailability = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        newGasField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        newMileageField = new javax.swing.JTextField();
        newDmgNotesField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        maintenanceLabel = new javax.swing.JLabel();
        maintenanceField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel1.setText("ID Number");

        searchButton.setText("Search...");
        searchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(searchIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Update"));

        jLabel2.setText("Make");

        jLabel3.setText("Model");

        jLabel4.setText("Color");

        jLabel5.setText("Year");

        jLabel6.setText("Class");

        jLabel7.setText("Daily Price");

        newMakeField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newMakeFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("$");

        jLabel9.setText("Availability");

        newAvailability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Available", "Not Available" }));
        newAvailability.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newAvailabilityActionPerformed(evt);
            }
        });

        jLabel10.setText("Gas");

        jLabel11.setText("Mileage");

        newDmgNotesField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newDmgNotesFieldActionPerformed(evt);
            }
        });

        jLabel12.setText("Damage Notes");

        maintenanceLabel.setText("Next Maintenance (mmddyyyy):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newModelField)
                            .addComponent(newMakeField)
                            .addComponent(newColorField)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(newYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newClassField))))
                    .addComponent(newDmgNotesField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newDailyPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(newGasField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newMileageField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(maintenanceLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maintenanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newMakeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newColorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(newYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(newClassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(newDailyPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(newGasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(newMileageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(newAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maintenanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(maintenanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newDmgNotesField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newMakeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMakeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newMakeFieldActionPerformed

    private void newAvailabilityActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newAvailabilityActionPerformed
    {//GEN-HEADEREND:event_newAvailabilityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newAvailabilityActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {//GEN-HEADEREND:event_searchButtonActionPerformed
        try
        {
            updateTextFieldsWithResults();
        }
        catch(FileNotFoundException e)
        {
            // RIP
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void newDmgNotesFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newDmgNotesFieldActionPerformed
    {//GEN-HEADEREND:event_newDmgNotesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newDmgNotesFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField maintenanceField;
    private javax.swing.JLabel maintenanceLabel;
    private javax.swing.JComboBox<String> newAvailability;
    public javax.swing.JTextField newClassField;
    public javax.swing.JTextField newColorField;
    public javax.swing.JTextField newDailyPriceField;
    private javax.swing.JTextField newDmgNotesField;
    public javax.swing.JTextField newGasField;
    public javax.swing.JTextField newMakeField;
    public javax.swing.JTextField newMileageField;
    public javax.swing.JTextField newModelField;
    public javax.swing.JTextField newYearField;
    private javax.swing.JButton searchButton;
    public javax.swing.JTextField searchIDField;
    // End of variables declaration//GEN-END:variables
}
