package userInterface;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewVehicleUITest {
    
    private NewVehicleUI testNewVehicleUI;
    
    public NewVehicleUITest() {
        try {
            testNewVehicleUI = new NewVehicleUI();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewVehicleUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testInitComponents() {
        Component[] components = testNewVehicleUI.getComponents();
        for (Component component : components) {
            assertNotNull(component);
        }
//        assertEquals(0, Integer.parseInt(testNewVehicleUI.idNumberField.getText()));
        assertEquals("Honda", testNewVehicleUI.makeField.getText());
        assertEquals("Pilot", testNewVehicleUI.modelField.getText());
        assertEquals("Black", testNewVehicleUI.colorField.getText());
        assertEquals(2015, Integer.parseInt(testNewVehicleUI.yearField.getText()));
        assertEquals("SUV", testNewVehicleUI.classField.getText());
        assertEquals(35.21, Double.parseDouble(testNewVehicleUI.dailyPriceField.getText()), 1);
    }
}
