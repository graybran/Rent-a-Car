package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerStorageSystemTest {
    
    private CustomerStorageSystem testStorage;
    private Customer testCustomer;
    private String testCustomerInformation;
    
    public CustomerStorageSystemTest() throws FileNotFoundException {
        testStorage = new CustomerStorageSystem();
        testCustomerInformation = "0 Test Test 30 (555) 555-5555 test@testing.com";
        
        testCustomer = new Customer();
        testCustomer.setCustID(0);
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Test");
        testCustomer.setAge(30);
        testCustomer.setPhoneNumber("(555) 555-5555");
        testCustomer.setEmailAddress("test@testing.com");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testRegisterCustomer() {
        assertNotNull(testCustomer);
        assertEquals(0, testCustomer.getCustID());
        assertEquals("Test", testCustomer.getFirstName());
        assertEquals("Test", testCustomer.getLastName());
        assertEquals(30, testCustomer.getAge());
        assertEquals("(555) 555-5555", testCustomer.getPhoneNumber());
        assertEquals("test@testing.com", testCustomer.getEmailAddress());
    }
}
