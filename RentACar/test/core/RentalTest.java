package core;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {
    
    private Rental testRental;
    private ArrayList<Rental> testRentals;
    private Customer testCustomer;
    private Vehicle testVehicle;
    
    public RentalTest() {
        InitalizeCustomer();
        InitalizeVehicle();
        
        testRental = new Rental(testVehicle, testCustomer);
        
//        testStartDate = "3 18 2017";
//        testEndDate = "4 20 2017";
    }

    @Test
    public void testAddRentalNotNull() {
        testRentals = testRental.AddRental();
        assertNotNull(testRentals);
    }
    
    @Test
    public void testAddRentalAdded() {
        testRentals = testRental.AddRental();
        for(Rental r:testRentals) {
            assertNotNull(r);
        }
    }
    
    private void InitalizeCustomer() {
        testCustomer = new Customer();
        testCustomer.setCustID(0);
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Test");
        testCustomer.setAge(30);
        testCustomer.setPhoneNumber("(555) 555-5555");
        testCustomer.setEmailAddress("test@testing.com");
    }
    
    private void InitalizeVehicle() {
        testVehicle = new Vehicle();
        testVehicle.setID(99);
        testVehicle.setMake("Ford");
        testVehicle.setModel("F150");
        testVehicle.setColor("White");
        testVehicle.setYear(2016);
        testVehicle.setCarClass("Truck");
        testVehicle.setAvailability(true);
        testVehicle.setDailyPrice(41.62);
    }
}
