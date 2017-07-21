package userInterface;

import core.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

// Created this class for easier sorting
class DatedVehicleObject implements Comparable<DatedVehicleObject>
{
    private Vehicle vehicle;
    private Date dateTime;

    public Date getDateTime() 
    {
      return dateTime;
    }

    public void setDateTime(Date datetime) 
    {
      this.dateTime = datetime;
    }
    
    @Override
    public int compareTo(DatedVehicleObject o) 
    {
      return getDateTime().compareTo(o.getDateTime());
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
}

public class MaintenanceReminderUI extends javax.swing.JPanel
{

    public MaintenanceReminderUI()
    {
        initComponents();
        maintenanceLateTextArea.setEditable(false);
        maintenanceSoonTextArea.setEditable(false);
        
        CarInventorySystem searchInventory = new CarInventorySystem();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<DatedVehicleObject> datedVehicles = new ArrayList<>();
        DatedVehicleObject temp;
        
        // Grabs an arraylist of every car in text database
        vehicles = searchInventory.dbToArrayList();
        
        // Transforms Vehicle class object to sortable DatedVehicleObject
        for(int i = 0; i < vehicles.size(); i++)
        {
            temp = new DatedVehicleObject();
            temp.setVehicle(vehicles.get(i));
            temp.setDateTime(vehicles.get(i).getNextMaintenance());
            datedVehicles.add(temp);
        }
        
        Collections.sort(datedVehicles);
        
        // Display vehicles sorted by date
        displayByDate(datedVehicles);
        
        int result = JOptionPane.showConfirmDialog(null, this, "View Maintenance",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    
    private void displayByDate(ArrayList<DatedVehicleObject> datedVehicles)
    {
        StringBuilder sb = new StringBuilder();
        Vehicle vehicleToWrite;
        
        for(int i = 0; i < datedVehicles.size(); i++)
        {
            vehicleToWrite = datedVehicles.get(i).getVehicle();
            Date date = new Date();
            if(vehicleToWrite.getNextMaintenance().before(date))
            {
                maintenanceLateTextArea.append("Date due: "
                                        + dateToString(vehicleToWrite) + "\nID #" 
                                        + vehicleToWrite.getID() + ": "
                                        + vehicleToWrite.getYear() + " " 
                                        + vehicleToWrite.getMake() + " " 
                                        + vehicleToWrite.getModel() + "\n");
                maintenanceLateTextArea.append("Notes: " + vehicleToWrite.getDmgNotes() + "\n\n");
            }
            else
            {
                maintenanceSoonTextArea.append("Date due: "
                                        + dateToString(vehicleToWrite) + "\nID #" 
                                        + vehicleToWrite.getID() + ": "
                                        + vehicleToWrite.getYear() + " " 
                                        + vehicleToWrite.getMake() + " " 
                                        + vehicleToWrite.getModel() + "\n");
                maintenanceSoonTextArea.append("Notes: " + vehicleToWrite.getDmgNotes() + "\n\n");
            }
        }
    }
    
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintenanceLateTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintenanceSoonTextArea = new javax.swing.JTextArea();

        jLabel1.setText("These vehicles need maintenance soon:");

        maintenanceLateTextArea.setColumns(20);
        maintenanceLateTextArea.setRows(5);
        jScrollPane1.setViewportView(maintenanceLateTextArea);

        jLabel2.setText("These vehicles are overdue:");

        maintenanceSoonTextArea.setColumns(20);
        maintenanceSoonTextArea.setRows(5);
        jScrollPane2.setViewportView(maintenanceSoonTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(199, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea maintenanceLateTextArea;
    private javax.swing.JTextArea maintenanceSoonTextArea;
    // End of variables declaration//GEN-END:variables
}