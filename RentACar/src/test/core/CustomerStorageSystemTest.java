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
    private CustomerStore storeTest = new CustomerStore();
    private String testCustomerInformation;
    
    class CustomerStore implements CustomerStorage {
        
        private String customerInformation;

        @Override
        public void ReadCustomerEntry(String fileName) {
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(fileName));
                do {
                    if(!bReader.readLine().equals("0 Test Test 30 (555) 555-5555 test@testing.com")) {
                        this.setCustomerInformation("0 Test Test 30 (555) 555-5555 test@testing.com");
                    }
                }while(bReader.readLine() != null);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CustomerStorageSystemTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CustomerStorageSystemTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public String getCustomerInformation() {
            return customerInformation;
        }

        public void setCustomerInformation(String customerInformation) {
            this.customerInformation = customerInformation;
        }
        
    }
    
    public CustomerStorageSystemTest() {
        testStorage = new CustomerStorageSystem(storeTest);
        testCustomerInformation = "0 Test Test 30 (555) 555-5555 test@testing.com";
        
        testCustomer = new Customer();
        testCustomer.setCustID(0);
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Test");
        testCustomer.setAge(30);
        testCustomer.setPhoneNumber("(555) 555-5555");
        testCustomer.setEmailAddress("test@testing.com");
//        testCustomer = testStorage.RegisterCustomer(0, "Test", "Test", 30, 
//                "(555) 555-5555", "test@testing.com");
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
    
    @Test
    public void testStoreCustomer() {
        testStorage.StoreCustomer(testCustomer);
        assertNotNull(storeTest.getCustomerInformation());
        assertEquals("0 Test Test 30 (555) 555-5555 test@testing.com", 
                storeTest.getCustomerInformation());
    }
}
