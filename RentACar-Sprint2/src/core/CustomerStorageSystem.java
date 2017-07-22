package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
    
        System.out.println(getCustomer(1).getFirstName());
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
    
    public static Customer getCustomer(Integer id){
        return customerList.get(id);
        
    }
    
    public static int getSize(){
        return customerList.size();
    }
}
