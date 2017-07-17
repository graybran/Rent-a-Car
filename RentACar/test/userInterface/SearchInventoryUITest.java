package userInterface;

import java.awt.Component;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Test
    public void testInitComponents() {
        Component[] components = testSearchInventoryUI.getComponents();
        for(int i=0;i<components.length;i++) {
            assertNotNull(components[i]);
        }
        assertEquals(0, Integer.parseInt(testSearchInventoryUI.searchIDField.getText()));
    }
}
