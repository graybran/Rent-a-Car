package core;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReturnTest {
    
    private Return testReturn;
    private Rental testRental;
    private String testFirstName;
    private String testLastName;
    
    public ReturnTest() {
        testReturn = new Return();
        testFirstName = "Test";
        testLastName = "Test";
        testRental = testReturn.SearchRental(testFirstName, testLastName);
    }
    
    @Test
    public void testSearchRentalNotNull() {
        assertNotNull(testRental);
    }
    
    @Test
    public void testSearchRentalCorrectMake() {
        assertEquals("Ford", testRental.vehicle.getMake());
    }
    
    @Test
    public void testSearchRentalCorrectModel() {
        assertEquals("F150", testRental.vehicle.getModel());
    }
    
    @Test
    public void testSearchRentalCorrectColor() {
        assertEquals("White", testRental.vehicle.getColor());
    }
    
    @Test
    public void testSearchRentalCorrectClass() {
        assertEquals("Truck", testRental.vehicle.getCarClass());
    }
    
    @Test
    public void testSearchRentalCorrectFirstName() {
        assertEquals("Test", testRental.customer.getFirstName());
    }
    
    @Test
    public void testSearchRentalCorrectLastName() {
        assertEquals("Test", testRental.customer.getLastName());
    }
}
