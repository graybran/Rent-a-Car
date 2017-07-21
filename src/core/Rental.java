/*
    This class associates a rental with a car and a customer
 */
package core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rental
{
    // Insantiate member variables
    public Vehicle vehicle;
    public Customer customer;
    
    private ArrayList<Rental> rentals;
        
    // Instantiate variables when new Rental class is created
    public Rental()
    {
        this.vehicle = new Vehicle();
        this.customer = new Customer();
        
        rentals = new ArrayList<>();
    }
    
    public Rental(Vehicle vehicle, Customer customer)
    {
        this.vehicle = vehicle;
        this.customer = customer;
        
        rentals = new ArrayList<>();
    }
    
    public ArrayList AddRental() {
        rentals.add(this);
        return rentals;
    }
    
    public ArrayList DeleteRental(Rental returnRental) {
        rentals.remove(returnRental);
        return rentals;
    }
    
    public void PrintRentals() {
        try {
            FileWriter rentalWriter = new FileWriter("RentalBase.txt", true);
            
            for(Rental r:rentals) {
                rentalWriter.write(r.vehicle.getID() + " " + 
                        r.vehicle.getMake() + " " + r.vehicle.getModel() + 
                        " " + r.vehicle.getColor() + " " + r.vehicle.getYear() + 
                        " " + r.vehicle.getCarClass() + " " + 
                        r.vehicle.getDailyPrice() + " " + 
                        r.customer.getFirstName() + " " + 
                        r.customer.getLastName() + " " + r.customer.getAge() + 
                        " " + r.customer.getPhoneNumber() + " " + 
                        r.customer.getEmailAddress());
                rentalWriter.write(System.getProperty("line.separator"));
            }
            
//            rentalWriter.write(this.vehicle.getMake() + " " + 
//                    this.vehicle.getModel() + " " + this.customer.getFirstName() + 
//                    " " + this.customer.getLastName());
//            rentalWriter.write(System.getProperty("line.separator"));
            rentalWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}