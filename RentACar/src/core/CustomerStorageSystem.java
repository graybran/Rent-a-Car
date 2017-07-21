package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerStorageSystem {
    
    private static ArrayList<Customer> customerList;
    
    public CustomerStorageSystem() throws FileNotFoundException {
        customerList = new ArrayList(1000);
        populateInitialList();
    }
       
    
    private void populateInitialList() throws FileNotFoundException{
        
        
        Scanner in = new Scanner(new File("Starter DB_cust.txt"));
        while(in.hasNextLine()){
           Customer customer = new Customer();
           customer.setCustID(Integer.parseInt(in.nextLine()));
           customer.setLastName(in.nextLine());
           customer.setFirstName(in.nextLine());
           customer.setEmailAddress(in.nextLine());
           customer.setPhoneNumber(in.nextLine());
           customer.setAge(Integer.parseInt(in.nextLine()));
           int rentalID = Integer.parseInt(in.nextLine());
           if(rentalID == -1){
               customer.setRentalID(rentalID);
           }
           else{
               customer.setRentalID(rentalID);
               //Vehicle car = CarInventorySystem.getCar(rentalID);
               //Rental rental = new Rental(car, customer);
               //RentalBase.set(rental, rentalID);
           }

           customerList.add(customer.getCustID(), customer);
        }
        
        checkDBExists();
        System.out.println(getCustomer(1).getFirstName());
    }
    
    private void checkDBExists()
    {
        try
        {
            File file = new File("CustomerBase.txt");

            if(!file.exists())
                file.createNewFile();
        }
        catch(IOException io)
        {
            // You screwed up
        }
    }
    
    public Customer RegisterCustomer(int id, String firstName, String lastName, 
            int age, String phoneNumber, String emailAddress) {
        Customer newCustomer = new Customer();
        newCustomer.setCustID(id);
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setAge(age);
        newCustomer.setPhoneNumber(phoneNumber);
        newCustomer.setEmailAddress(emailAddress);
        
        customerList.add(newCustomer);
        StoreCustomer(newCustomer);

        return newCustomer;
    }
    
    public void UpdateCustomer(String firstName, String lastName, int newAge, 
            String newPhoneNumber, String newEmailAddress) {
        try {
            Scanner baseScan = new Scanner(new File("CustomerBase.txt"));
            while(baseScan.hasNextLine()) {
                String temp = baseScan.nextLine();
                System.out.println(temp);
            }
            baseScan.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerStorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void StoreCustomer(Customer customer) {
        
        try {
            FileWriter custEntry = new FileWriter("CustomerBase.txt", true);
            custEntry.write(customer.getCustID() + " " + 
                    customer.getFirstName() + " " + customer.getLastName() + 
                    " " + customer.getAge() + " " + customer.getPhoneNumber() + 
                    " " + customer.getEmailAddress());
            custEntry.write(System.getProperty("line.separator"));
            custEntry.close();
        }
        catch(Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Overwrites a specific customer based on ID. Also sorts the database as a consequence.
    public void UpdateDatabase(Customer insertThisCustomer) throws IOException
    {
        String [] customerListBuffer = new String[1000];
        
        // Reads CarBase.txt
        Scanner in = new Scanner(new File("CustomerBase.txt"));
        int id = in.nextInt();
        String N = in.nextLine();
        StringBuilder sb = new StringBuilder();
        
        // Store contents in an ArrayList
        while (in.hasNextLine())
        {
            customerListBuffer[id] = N;
            id = in.nextInt();
            N = in.nextLine();
        }
        customerListBuffer[id] = N;
        
        // Convert data to string for ArrayList
        String stringToWrite = CustomerInfoToOneLineString(insertThisCustomer, sb);
                 
        // Insert to ArrayList
        customerListBuffer[insertThisCustomer.getCustID()] = stringToWrite;
        
        // Writes new data to file
        WriteDBArrayToFile(customerListBuffer);
    }
    
    private String CustomerInfoToOneLineString(Customer insertThisCustomer, StringBuilder sb)
    {
        sb.append(" ").append(insertThisCustomer.getFirstName()).append(" ");
        sb.append(insertThisCustomer.getLastName()).append(" ");
        sb.append(insertThisCustomer.getAge()).append(" ");
        sb.append(insertThisCustomer.getPhoneNumber()).append(" ");
        sb.append(insertThisCustomer.getEmailAddress()).append(" ");
        
        return sb.toString();
    }
    
    // Writes new data to file
    private void WriteDBArrayToFile(String [] carListBuffer) throws IOException
    {
        // !!!!!!!! TODO: CHANGE to "CustomerBase2Base.txt" for release! !!!!!!!!!!!
        FileWriter fw = new FileWriter("CustomerBase.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        for(int i = 0; i < carListBuffer.length; i++)
        {
            if(carListBuffer[i] != null)
            {
                out.print(i);
                out.println(carListBuffer[i]);
            }
        }
        
        out.close();
    }
    
    public Customer SearchCustomer(String FirstName, String LastName) {
        ArrayList<ArrayList> customers = new ArrayList<>();
        ArrayList<Object> customerInformation = null;
        Customer foundCustomer = null;
        String customerEntry;
        try {
            Scanner customerScan = new Scanner(new File("CustomerBase.txt"));
            while(customerScan.hasNextLine()) {
                customerEntry = customerScan.nextLine();
                customerInformation = CreateCustomerEntry(customerEntry);
                customers.add(customerInformation);
            }
            customerScan.close();
            
            int id = VerifyFoundCustomer(FirstName, LastName, customers);
            
            if(id >= 0) {
                System.out.println("Customer found!");
                
                ArrayList<Object> information = GetFoundInformation(id, customers);

                foundCustomer = InitializeCustomerInformation(information);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerStorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return foundCustomer;
    }
    
    // For SearchCustomer(String, String) function
    public int VerifyFoundCustomer(String FirstName, String LastName, ArrayList<ArrayList> customers) 
    {
        for(int i=0;i<customers.size();i++) 
        {
            for(int j=0;j<customers.get(i).size();j++) 
            {
                if(FirstName.equals(customers.get(i).get(1).toString()) &&
                    LastName.equals(customers.get(i).get(2).toString())
                        ) 
                {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public Customer SearchCustomer(int searchID) {
        ArrayList<ArrayList> customers = new ArrayList<>();
        ArrayList<Object> customerInformation = null;
        Customer foundCustomer = null;
        String customerEntry;
        try {
            Scanner customerScan = new Scanner(new File("CustomerBase.txt"));
            while(customerScan.hasNextLine()) {
                customerEntry = customerScan.nextLine();
                customerInformation = CreateCustomerEntry(customerEntry);
                customers.add(customerInformation);
            }
            customerScan.close();
            
            if(VerifyFoundCustomer(searchID, customers)) {
                System.out.println("Customer found!");
                
                ArrayList<Object> information = GetFoundInformation(searchID, customers);

                foundCustomer = InitializeCustomerInformation(information);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerStorageSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return foundCustomer;
    }
    
    public ArrayList CreateCustomerEntry(String customerInformation) {
        ArrayList<Object> customerEntries = new ArrayList<>();
        String[] newCustomerEntry = customerInformation.split(" ");
        for(int i=0;i<newCustomerEntry.length;i++) {
            customerEntries.add(newCustomerEntry[i]);
        }
        
        return customerEntries;
    }
    
    public boolean VerifyFoundCustomer(int verifyID, ArrayList<ArrayList> customers) {
        for(int i=0;i<customers.size();i++) {
            for(int j=0;j<customers.get(i).size();j++) {
                if(verifyID == Integer.parseInt(customers.get(i).get(0).toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<Object> GetFoundInformation(int id, ArrayList<ArrayList> customers) {
        ArrayList<Object> entry = new ArrayList<>();
        for(ArrayList customer:customers) {
            for(int j=0;j<customer.size();j++) {
                if(id == Integer.parseInt(customer.get(0).toString())) {
                    entry = customer;
                }
            }
        }
        return entry;
    }
    
    public Customer InitializeCustomerInformation(ArrayList customerInformation) {
        Customer foundCustomer = new Customer();
        
        foundCustomer.setFirstName(customerInformation.get(1).toString());
        foundCustomer.setLastName(customerInformation.get(2).toString());
        foundCustomer.setAge(Integer.parseInt(customerInformation.get(3).toString()));
        foundCustomer.setPhoneNumber(customerInformation.get(4).toString() + " " 
                                    + customerInformation.get(5).toString());
        foundCustomer.setEmailAddress(customerInformation.get(6).toString());
        
        return foundCustomer;
    }
    
    public static Customer getCustomer(Integer id){
        return customerList.get(id);
        
    }
    
    public static int getSize(){
        return customerList.size();
    }
}
