package core;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fakeDatabase
{
    public void CreateCustomerBase() throws IOException {
        FileWriter headers = new FileWriter(new File("CustomerBase.txt"), true);
        headers.write("------------------------------------------------------------------------------------");
        headers.write(System.getProperty("line.separator"));
        headers.write("First Name\t Last Name\t Age\t Phone Number\t Email Address\t Car Rented");
        headers.write(System.getProperty("line.separator"));
        headers.close();
    }
    
    /*
    public void CreateCustomerBase() throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter custWrite = new PrintWriter("CustomerBase.txt", "UTF-8")) {
            custWrite.println("First Name\t Last Name\t Age\t Phone Number\t Email Address\t Car Rented");
            custWrite.println("--------------------------------------------------------------------------------------");
            custWrite.close();
        }
    }
    
    public void CreateCarBase() throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter carWrite = new PrintWriter("CarBase.txt", "UTF-8")) {
            carWrite.println("ID\t Brand\t Model\t Color\t Year\t Class\t Availability\t Daily Price");
            carWrite.println("-----------------------------------------------------------------------------------------------");
            carWrite.close();
        }
    }
    */
    
    /*
    HashMap<Integer, Rental> rentals;
    
    public fakeDatabase(){
     rentals = new HashMap<>();
    }
    
    //Getters/Setters (use HashMap functionality)
    public Rental get(Integer ID){
        return rentals.get(ID);
    }
    public void set(Rental renter, Integer ID){
        rentals.put(ID, renter);
    }
    
    
    
    public  void initDBpopulator() throws FileNotFoundException {

        
        
        int i=0;
        Scanner in = new Scanner(new File("Starter DB.txt"));
        while(in.hasNextLine()){
           Vehicle vehicle = new Vehicle();
           vehicle.setYear(Integer.parseInt(in.nextLine()));
           vehicle.setMake(in.nextLine());
           vehicle.setModel(in.nextLine());
           vehicle.setCarClass(in.nextLine());
           vehicle.setID(i);
           Rental rental = new Rental();
           rental.vehicle = vehicle;
           rental.customer = null;
           rentals.put(i, rental);
           i++;
        }
    }
    */
}
