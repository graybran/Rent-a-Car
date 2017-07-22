package userInterface;

import java.awt.Component;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewCustomerUITest {
    
    private newCustomerUI testNewCustomerUI;
    
    public NewCustomerUITest() {
        testNewCustomerUI = new newCustomerUI();
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
