package core;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CarInventorySystem
{
    
    private static ArrayList<Vehicle> carList;
    
    public CarInventorySystem() throws FileNotFoundException {
        this.carList = new ArrayList(1000);
        populateInitialList();
    }

    private void populateInitialList() throws FileNotFoundException{
        
        int i=0;
        Scanner in = new Scanner(new File("Starter DB.txt"));
        while(in.hasNextLine()){
        Vehicle vehicle = new Vehicle();
        vehicle.setID(Integer.parseInt(in.nextLine()));
        vehicle.setMake(in.nextLine());
        vehicle.setModel(in.nextLine());
        vehicle.setColor(in.nextLine());
        vehicle.setYear(Integer.parseInt(in.nextLine()));
        vehicle.setCarClass(in.nextLine());
        if(Integer.parseInt(in.nextLine()) == 0){
            vehicle.setAvailability(false);
        }
        else{
            vehicle.setAvailability(true);
        }
        vehicle.setDailyPrice(Double.parseDouble(in.nextLine()));

        }
    }
    
    public Vehicle AddCar(int ID, String brand, String model, String color, int year, 
            String carClass, boolean availability, double dailyPrice) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setID(ID);
        newVehicle.setMake(brand);
        newVehicle.setModel(model);
        newVehicle.setColor(color);
        newVehicle.setYear(year);
        newVehicle.setCarClass(carClass);
        newVehicle.setAvailability(availability);
        newVehicle.setDailyPrice(dailyPrice);
        
        // Using new UpdateDatabase Function
        StoreVehicle(newVehicle);
        
        try
        {
            UpdateDatabase(newVehicle);
        }
        catch(IOException e)
        {
            
        }
        
        // NOTE: This gives indexOutOfBounds if ID is NOT in order! Suggest using an array instead.
        carList.add(newVehicle.getID(), newVehicle);
        
        return newVehicle;
    }
    
    public void UpdateCar(Vehicle updateThisVehicle)
    {
        
    }
    
    public Vehicle SearchVehicle(int searchID) {
        ArrayList<ArrayList> vehicles = new ArrayList<>();
        ArrayList<Object> vehicleInformation = null;
        Vehicle foundVehicle = null;
        String vehicleEntry;
        try {
            Scanner vehicleScan = new Scanner(new File("CarBase.txt"));
            while(vehicleScan.hasNextLine()) {
                vehicleEntry = vehicleScan.nextLine();
                vehicleInformation = CreateVehicleEntry(vehicleEntry);
                vehicles.add(vehicleInformation);
            }
            vehicleScan.close();
            
            if(VerifyFoundVehicle(searchID, vehicles)) {
                System.out.println("Vehicle found!");
                
                ArrayList<Object> information = GetFoundInformation(searchID, vehicles);

                foundVehicle = InitializeVehicleInformation(information);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarInventorySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return foundVehicle;
    }
    
    public ArrayList CreateVehicleEntry(String vehicleInformation) {
        ArrayList<Object> vehicleEntries = new ArrayList<>();
        String[] newVehicleEntry = vehicleInformation.split(" ");
        for(int i=0;i<newVehicleEntry.length;i++) {
            vehicleEntries.add(newVehicleEntry[i]);
        }
        
        return vehicleEntries;
    }
    
    public boolean VerifyFoundVehicle(int verifyID, ArrayList<ArrayList> vehicles) {
        for(int i=0;i<vehicles.size();i++) {
            for(int j=0;j<vehicles.get(i).size();j++) {
                if(verifyID == Integer.parseInt(vehicles.get(i).get(0).toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<Object> GetFoundInformation(int id, ArrayList<ArrayList> vehicles) {
        ArrayList<Object> entry = new ArrayList<>();
        for(ArrayList vehicle:vehicles) {
            for(int j=0;j<vehicle.size();j++) {
                if(id == Integer.parseInt(vehicle.get(0).toString())) {
                    entry = vehicle;
                }
            }
        }
        return entry;
    }
    
    public Vehicle InitializeVehicleInformation(ArrayList vehicleInformation) {
        Vehicle foundVehicle = new Vehicle();
        
        foundVehicle.setMake(vehicleInformation.get(1).toString());
        foundVehicle.setModel(vehicleInformation.get(2).toString());
        foundVehicle.setColor(vehicleInformation.get(3).toString());
        foundVehicle.setYear(Integer.parseInt(vehicleInformation.get(4).toString()));
        foundVehicle.setCarClass(vehicleInformation.get(5).toString());
        foundVehicle.setAvailability(vehicleInformation.get(6).toString().equals("1"));
        foundVehicle.setDailyPrice(Double.parseDouble(vehicleInformation.get(7).toString()));
        
        return foundVehicle;
    }
    
    
    
    public void StoreVehicle(Vehicle newVehicle) 
    {
        // Using new UpdateDatabase Function
        try
        {
            UpdateDatabase(newVehicle);
        }
        catch(IOException e)
        {
            
        }
        /*
        try {
            FileWriter vehicleEntry = new FileWriter("CarBase.txt", true);
            vehicleEntry.write(newVehicle.getID() + " " + newVehicle.getMake() + 
                    " " + newVehicle.getModel() + " " + newVehicle.getColor() + 
                    " " + newVehicle.getYear() + " " + newVehicle.getCarClass() + 
                    " " + newVehicle.isAvailability() + " " + 
                    newVehicle.getDailyPrice());
            vehicleEntry.write(System.getProperty("line.separator"));
            vehicleEntry.close();
        }
       catch(Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        */      
    }
    
    // Overwrites a specific vehicle based on ID. Also sorts the database as a consequence.
    public void UpdateDatabase(Vehicle insertThisVehicle) throws IOException
    {
        String [] carListBuffer = new String[1000];
        
        // Reads CarBase.txt
        Scanner in = new Scanner(new File("CarBase.txt"));
        int id = in.nextInt();
        String N = in.nextLine();
        StringBuilder sb = new StringBuilder();
        
        // Store contents in an ArrayList
        while (in.hasNextLine())
        {
            carListBuffer[id] = N;
            id = in.nextInt();
            N = in.nextLine();
        }
        carListBuffer[id] = N;
        
        // Convert data to string for ArrayList
        String stringToWrite = VehicleInfoToOneLineString(insertThisVehicle, sb);
                 
        // Insert to ArrayList
        carListBuffer[insertThisVehicle.getID()] = stringToWrite;
        
        // Writes new data to file
        WriteDBArrayToFile(carListBuffer);
    }
    
    private String VehicleInfoToOneLineString(Vehicle insertThisVehicle, StringBuilder sb)
    {
        sb.append(" ").append(insertThisVehicle.getMake()).append(" ");
        sb.append(insertThisVehicle.getModel()).append(" ");
        sb.append(insertThisVehicle.getColor()).append(" ");
        sb.append(insertThisVehicle.getYear()).append(" ");
        sb.append(insertThisVehicle.getCarClass()).append(" ");
        sb.append(Boolean.toString(insertThisVehicle.isAvailability())).append(" ");
        sb.append(insertThisVehicle.getDailyPrice()).append(" ");
        
        return sb.toString();
    }
    
    // Writes new data to file
    private void WriteDBArrayToFile(String [] carListBuffer) throws IOException
    {
        // !!!!!!!! TODO: CHANGE to "CarBase.txt" for release! !!!!!!!!!!!
        FileWriter fw = new FileWriter("CarBase.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        for(int i = 0; i < carListBuffer.length; i++)
        {
            if(carListBuffer[i] != null)
            {
                out.print(i);
                out.println(carListBuffer[i]);
            }
        }
        
        out.close();
    }
    
    public static Vehicle getCar(int id)
    {
        Vehicle retVal;
        
        try
        {
            retVal = carList.get(id);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
        return retVal;
    }
    public static int getSize()
    {
        return carList.size();
    }
}
