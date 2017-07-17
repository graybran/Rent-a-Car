package userInterface;

import java.awt.Component;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UpdateVehicleUITest
{
    private UpdateVehicleUI testUpdateVehicleUI;
 
    public UpdateVehicleUITest()
    {
        testUpdateVehicleUI = new UpdateVehicleUI();
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testInitComponents() 
    {
        Component[] components = testUpdateVehicleUI.getComponents();
        for (Component component : components) 
        {
            assertNotNull(component);
        }
        
        assertEquals("Honda", testUpdateVehicleUI.newMakeField.getText());
        assertEquals("Pilot", testUpdateVehicleUI.newModelField.getText());
        assertEquals("Black", testUpdateVehicleUI.newColorField.getText());
        assertEquals(2015, Integer.parseInt(testUpdateVehicleUI.newYearField.getText()));
        assertEquals("SUV", testUpdateVehicleUI.newClassField.getText());
        assertEquals(35.21, Double.parseDouble(testUpdateVehicleUI.newDailyPriceField.getText()), 1);
    }
}
