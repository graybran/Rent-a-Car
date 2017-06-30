package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerStorageSystem {
    
    private CustomerStorage storageSystem;
    
    public CustomerStorageSystem(CustomerStorage store) {
        this.storageSystem = store;
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
        
//        ArrayList<Customer> currentCustomers = ScanCurrentBase();

        try {
            FileWriter custEntry = new FileWriter("CustomerBase.txt", true);
            custEntry.write(customer.getCustID() + " " + 
                    customer.getFirstName() + " " + customer.getLastName() + 
                    " " + customer.getAge() + " " + customer.getPhoneNumber() + 
                    " " + customer.getEmailAddress());
            custEntry.write(System.getProperty("line.separator"));
            storageSystem.ReadCustomerEntry("CustomerBase.txt");
            custEntry.close();
        }
        catch(Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* //Replaces entries
        try (PrintWriter custBaseEntry = new PrintWriter("CustomerBase.txt", "UTF-8")) {
            custBaseEntry.println(firstName + "\t " + lastName + "\t " + age + 
                    "\t " + phoneNumber + "\t " + emailAddress);
            custBaseEntry.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
}
