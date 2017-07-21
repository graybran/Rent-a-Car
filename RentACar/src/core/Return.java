package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Return {
    
    private ArrayList<Rental> toReturn;
    
    public Return() {
        toReturn = new ArrayList<>();
        try {
            populateInitialList();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Return.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateInitialList() throws FileNotFoundException{
        
        int i=0;
        Scanner in = new Scanner(new File("RentalBase.txt"));
        //String areaCode, remainingPhoneNumber;
        in.useDelimiter(" ");
        
        while(in.hasNextLine()){
            Vehicle vehicle = new Vehicle();
            vehicle.setID(Integer.parseInt(in.next()));
            vehicle.setMake(in.next());
            vehicle.setModel(in.next());
            vehicle.setColor(in.next());
            vehicle.setYear(Integer.parseInt(in.next()));
            vehicle.setCarClass(in.next());
            vehicle.setDailyPrice(Double.parseDouble(in.next()));
            
            Customer customer = new Customer();
            customer.setFirstName(in.next());
            customer.setLastName(in.next());
            customer.setAge(Integer.parseInt(in.next()));
            //areaCode = in.next();
            //remainingPhoneNumber = in.next();
            customer.setPhoneNumber(in.next());
            customer.setEmailAddress(in.nextLine());
            
            Rental rentEntry = new Rental(vehicle, customer);
            toReturn.add(rentEntry);
        }
        
        checkDBExists();
    }
    
    private void checkDBExists()
    {
        try
        {
            File file = new File("RentalBase.txt");

            if(!file.exists())
                file.createNewFile();
        }
        catch(IOException io)
        {
            
        }
    }
    
    public Rental SearchRental(String firstName, String lastName) {
        for(Rental rent:toReturn) {
            if(rent.customer.getFirstName().equals(firstName) && 
                    rent.customer.getLastName().equals(lastName)) {
                return rent;
            }
        }
        return null;
    }
    
    public ArrayList DeleteFoundRental(Rental foundRental) {
        toReturn.remove(foundRental);
        return toReturn;
    }
    
    public void PrintRentalReturns() {
        try {
            FileWriter rentalWriter = new FileWriter("RentalBase.txt", false);
            
            for(Rental r:toReturn) {
                rentalWriter.write(r.vehicle.getID() + " " + r.vehicle.getMake() + " " + 
                        r.vehicle.getModel() + " " + r.vehicle.getColor() + 
                        " " + r.vehicle.getYear() + " " + r.vehicle.getCarClass() + " " + 
                        r.vehicle.getDailyPrice() + " " +
                        r.customer.getFirstName() + " " + 
                        r.customer.getLastName() + " " + 
                        r.customer.getAge() + " " +
                        r.customer.getPhoneNumber() + " " + 
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
