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
public class SearchInventoryUITest {
    
    private SearchInventoryUI testSearchInventoryUI;
    
    public SearchInventoryUITest() {
        testSearchInventoryUI = new SearchInventoryUI();
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
        Component[] components = testSearchInventoryUI.getComponents();
        for(int i=0;i<components.length;i++) {
            assertNotNull(components[i]);
        }
        assertEquals(0, Integer.parseInt(testSearchInventoryUI.searchIDField.getText()));
    }
}
