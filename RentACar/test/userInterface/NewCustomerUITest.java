package userInterface;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewCustomerUITest {
    
    private newCustomerUI testNewCustomerUI;
    
    public NewCustomerUITest() {
        try {
            testNewCustomerUI = new newCustomerUI();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewCustomerUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void testInitComponents() {
        Component[] components = testNewCustomerUI.getComponents();
        for(int i=0;i<components.length;i++) {
            assertNotNull(components[i]);
        }
        assertEquals(0, Integer.parseInt(testNewCustomerUI.idNumberField.getText()));
        assertEquals("Test", testNewCustomerUI.firstNameField.getText());
        assertEquals("Test", testNewCustomerUI.lastNameField.getText());
        assertEquals(30, Integer.parseInt(testNewCustomerUI.ageField.getText()));
        assertEquals("(555) 555-5555", testNewCustomerUI.phoneField.getText());
        assertEquals("test@testing.com", testNewCustomerUI.emailField.getText());
    }
}
