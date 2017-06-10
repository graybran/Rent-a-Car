package core;

import java.io.*;
import java.util.*;

public class fakeDatabase
{
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
    
    
    public  void initDBpopulator() throws FileNotFoundException{
        
         
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
}
