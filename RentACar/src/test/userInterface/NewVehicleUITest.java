/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Component;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brandon
 */
public class NewVehicleUITest {
    
    private NewVehicleUI testNewVehicleUI;
    
    public NewVehicleUITest() {
        testNewVehicleUI = new NewVehicleUI();
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
    public void testInitComponents() {
        Component[] components = testNewVehicleUI.getComponents();
        for (Component component : components) {
            assertNotNull(component);
        }
        assertEquals(0, Integer.parseInt(testNewVehicleUI.idNumberField.getText()));
        assertEquals("Honda", testNewVehicleUI.makeField.getText());
        assertEquals("Pilot", testNewVehicleUI.modelField.getText());
        assertEquals("Black", testNewVehicleUI.colorField.getText());
        assertEquals(2015, Integer.parseInt(testNewVehicleUI.yearField.getText()));
        assertEquals("SUV", testNewVehicleUI.classField.getText());
        assertEquals(35.21, Double.parseDouble(testNewVehicleUI.dailyPriceField.getText()), 1);
    }
}
