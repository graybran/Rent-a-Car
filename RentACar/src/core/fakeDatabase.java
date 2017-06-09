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
           Car car = new Car();
           car.year =  in.nextLine();
           car.make = in.nextLine();
           car.model = in.nextLine();
           car.carClass = in.nextLine();
           car.ID = Integer.toString(i);
           Rental rental = new Rental();
           rental.car = car;
           rental.customer = null;
           rentals.put(i, rental);
           i++;
        }
    }
}
