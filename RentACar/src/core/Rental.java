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
            rentalWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int CalculateRentalDuration(String startDate, String endDate) {
        int duration;
        int[] start = ConvertAndCombineDates(startDate);
        int[] end = ConvertAndCombineDates(endDate);
        duration = CalculateDuration(start, end);
        return duration;
    }
    
    public int[] ConvertAndCombineDates(String date) {
        int[] combinedDate;
        String[] splitDate = SplitDateValues(date);
        int month = ConvertMonth(splitDate[0]);
        int day = ConvertDay(splitDate[1]);
        int year = ConvertYear(splitDate[2]);
        combinedDate = CombineDate(month, day, year);
        return combinedDate;
    }
    
    public String[] SplitDateValues(String date) {
        String[] values = date.split(" ");
        return values;
    }
    
    public int ConvertMonth(String month) {
        return Integer.valueOf(month);
    }
    
    public int ConvertDay(String day) {
        return Integer.valueOf(day);
    }
    
    public int ConvertYear(String year) {
        return Integer.valueOf(year);
    }
    
    public int[] CombineDate(int month, int day, int year) {
        int[] finalDate = {month, day, year};
        return finalDate;
    }
    
    public int CalculateDuration(int[] startDate, int[] endDate) {
        int numDays = 0;
        int monthDuration = endDate[0] - startDate[0];
        int dayDuration = endDate[1] - startDate[1];
        int yearDuration = endDate[2] - startDate[2];
        
        int daysInStartMonth = DetermineMonthDays(startDate[0]);
        int daysInEndMonth = DetermineMonthDays(endDate[0]);
        
        if(yearDuration == 0) {
            if(monthDuration == 0) {
                numDays = dayDuration;
            }
            else {
                int remainingDaysInStart = daysInStartMonth - (startDate[1]-1);
                numDays = remainingDaysInStart + endDate[1];
            }
        }
        else if(startDate[2] > endDate[2] || startDate[0] > endDate[0]) {
            return -1;
        }
        else if(startDate[1] > daysInStartMonth || endDate[1] > daysInEndMonth) {
            return -1;
        }
        else if(startDate[1] > endDate[1]) {
            return -1;
        }
        
        return numDays;
    }
    
    public int DetermineMonthDays(int monthNumber) {
        int numDaysInMonth = 0;
        switch(monthNumber) {
            case 1:
                numDaysInMonth = 31;
                break;
            case 2:
                numDaysInMonth = 28;
                break;
            case 3:
                numDaysInMonth = 31;
                break;
            case 4:
                numDaysInMonth = 30;
                break;
            case 5:
                numDaysInMonth = 31;
                break;
            case 6:
                numDaysInMonth = 30;
                break;
            case 7:
                numDaysInMonth = 31;
                break;
            case 8:
                numDaysInMonth = 31;
                break;
            case 9:
                numDaysInMonth = 30;
                break;
            case 10:
                numDaysInMonth = 31;
                break;
            case 11:
                numDaysInMonth = 30;
                break;
            case 12:
                numDaysInMonth = 31;
                break;
            default:
                break;
        }
        return numDaysInMonth;
    }
    
    public double CalculateTotalPrice(Vehicle rentedVehicle, 
            int rentalDuration) {
        return rentalDuration*rentedVehicle.getDailyPrice();
    }
}