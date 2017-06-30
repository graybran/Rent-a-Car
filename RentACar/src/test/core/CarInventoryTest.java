package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

public class CarInventoryTest {
    
    private CarInventorySystem testInventory;
    private final String vehicleInformation;
    private final String otherVehicleInformation;
    private VehicleStore storeTest;
    Vehicle testVehicle;
    
    class VehicleStore implements InventorySystem {
        
        private String information;

        @Override
        public void ReadVehicleEntry(String fileName) {
            BufferedReader bReader;
            try {
                bReader = new BufferedReader(new FileReader(fileName));
                String entry = bReader.readLine();
                System.out.println("Orignial entry: " + entry);
                while(entry != null) {
                    System.out.println("Entry: " + entry + " Information: " + information);
                    if(entry.equals("99 Ford F150 White 2016 Truck true 41.62")) {
                        this.setInformation("99 Ford F150 White 2016 Truck true 41.62");
                        break;
                    }
                    entry = bReader.readLine();
                }
                bReader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CarInventoryTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CarInventoryTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Original ReadVehicleEntry
//            String entry = "";
//            try {
//                BufferedReader buffReader = new BufferedReader(new FileReader(fileName));
//                do {
//                    entry = buffReader.readLine();
//                    System.out.println(entry);
//                    if(!buffReader.readLine().equals("99 Ford F150 White 2016 Truck true 41.62")) {
//                        this.setInformation("99 Ford F150 White 2016 Truck true 41.62");
//                    }
//                }while(entry != null);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(CarInventoryTest.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(CarInventoryTest.class.getName()).log(Level.SEVERE, null, ex);
//            }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }
        
    };
    
    public CarInventoryTest() {
        storeTest = new VehicleStore();
        testInventory = new CarInventorySystem(storeTest);
        vehicleInformation = "0 Honda Pilot Black 2015 SUV true 35.21";
        otherVehicleInformation = "99 Ford F150 White 2016 Truck true 41.62";
        
        testVehicle = new Vehicle();
        testVehicle.setID(99);
        testVehicle.setMake("Ford");
        testVehicle.setModel("F150");
        testVehicle.setColor("White");
        testVehicle.setYear(2016);
        testVehicle.setCarClass("Truck");
        testVehicle.setAvailability(true);
        testVehicle.setDailyPrice(41.62);
//        testVehicle = testInventory.AddCar(0, "Honda", "Pilot", "Black", 
//                2015, "SUV", true, 35.21);
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
    public void testCreateVehicleEntry() {
        ArrayList<Object> testEntry = testInventory.CreateVehicleEntry(vehicleInformation);
        assertNotNull(testEntry);
        for(Object e:testEntry) {
            assertNotNull(e);
        }
        assertEquals("0", testEntry.get(0));
        assertEquals("Honda", testEntry.get(1));
        assertEquals("Pilot", testEntry.get(2));
        assertEquals("Black", testEntry.get(3));
        assertEquals("2015", testEntry.get(4));
        assertEquals("SUV", testEntry.get(5));
        assertEquals("true", testEntry.get(6));
        assertEquals("35.21", testEntry.get(7));
    }
    
    @Test
    public void testVerifyFoundVehicle() {
        ArrayList<ArrayList> testVehicleList = CreateTestList();
        
        boolean testVehicleFound = testInventory.VerifyFoundVehicle(0, testVehicleList);
        assertEquals(true, testVehicleFound);
        
        boolean testOtherVehicleFound = testInventory.VerifyFoundVehicle(99, testVehicleList);
        assertEquals(true, testVehicleFound);
        
        boolean vehicleNotFound = testInventory.VerifyFoundVehicle(50, testVehicleList);
        assertEquals(false, vehicleNotFound);
        assertNotEquals(true, vehicleNotFound);
    }
    
    @Test
    public void testGetFoundInformation() {
        ArrayList<ArrayList> testVehicleList = CreateTestList();
        
        ArrayList<Object> testEntry = testInventory.GetFoundInformation(0, testVehicleList);
        assertNotNull(testEntry);
        //to be continued...
    }
    
    @Test
    public void testInitalizeVehicleInformation() {
        ArrayList<Object> testVehicleInformation = 
                testInventory.CreateVehicleEntry(vehicleInformation);
        Vehicle testVehicle = testInventory.InitializeVehicleInformation(testVehicleInformation);
        assertNotNull(testVehicle);
        assertEquals(0, testVehicle.getID());
        assertEquals("Honda", testVehicle.getMake());
        assertEquals("Pilot", testVehicle.getModel());
        assertEquals("Black", testVehicle.getColor());
        assertEquals(2015, testVehicle.getYear());
        assertEquals("SUV", testVehicle.getCarClass());
        assertEquals(true, testVehicle.isAvailability());
        assertEquals(35.21, testVehicle.getDailyPrice(), 1);
    }
    
    @Test
    public void testStoreVehicle() {        
        testInventory.StoreVehicle(testVehicle);
        assertNotNull(storeTest.getInformation());
        Assert.assertNotEquals("", storeTest.getInformation());
        assertEquals("99 Ford F150 White 2016 Truck true 41.62", 
                storeTest.getInformation());
    }
    
    private ArrayList<ArrayList> CreateTestList() {
        ArrayList<ArrayList> testVehicleList = new ArrayList<>();
        ArrayList<Object> testList1 = testInventory.CreateVehicleEntry(vehicleInformation);
        ArrayList<Object> testList2 = testInventory.CreateVehicleEntry(otherVehicleInformation);
        testVehicleList.add(testList1);
        testVehicleList.add(testList2);
        
        return testVehicleList;
    }
    
    /* //This is technically an integration test
    @Test
    public void testAddCar() {
        assertNotNull(testVehicle);
        assertEquals(0, testVehicle.getID());
        assertEquals("Honda", testVehicle.getMake());
        assertEquals("Pilot", testVehicle.getModel());
        assertEquals("Black", testVehicle.getColor());
        assertEquals(2015, testVehicle.getYear());
        assertEquals("SUV", testVehicle.getCarClass());
        assertEquals(true, testVehicle.isAvailability());
        assertEquals(35.21, testVehicle.getDailyPrice(), 1);
    }
    */
}
