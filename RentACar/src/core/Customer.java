/*
    This is the class customer. New customer objects can be created with this
*/

package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer
{
    // Insantiate member variables
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String phoneNumber;
    private int age;
    
    private int custID;
    private Vehicle rentedCar;
    
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    public Vehicle getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Vehicle rentedCar) {
        this.rentedCar = rentedCar;
    }
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
//    public void StoreCustomer() {
//        
////        ArrayList<Customer> currentCustomers = ScanCurrentBase();
//
//        try {
//            FileWriter custEntry = new FileWriter("CustomerBase.txt", true);
//            custEntry.write(custID + " " + firstName + " " + lastName + 
//                    " " + age + " " + phoneNumber + " " + emailAddress);
//            custEntry.write(System.getProperty("line.separator"));
//            custEntry.close();
//        }
//        catch(Exception ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        /* //Replaces entries
//        try (PrintWriter custBaseEntry = new PrintWriter("CustomerBase.txt", "UTF-8")) {
//            custBaseEntry.println(firstName + "\t " + lastName + "\t " + age + 
//                    "\t " + phoneNumber + "\t " + emailAddress);
//            custBaseEntry.close();
//        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        */
//    }
    
    /*
    //Good, but not needed
    private ArrayList ScanCurrentBase() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Scanner fileScan = new Scanner(new File("CustomerBase.txt"));
            while(fileScan.hasNextLine()) {
                String scanned = fileScan.nextLine();
                System.out.println("Scanned: " + scanned);
                customers = CreateCustomerEntry(scanned);
            }
            fileScan.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("The file CustomerBase.txt does not exist. "
                    + "Please try again.");
            System.exit(1);
        }
        return customers;
    }
    
    private ArrayList CreateCustomerEntry(String customerInfo) {
        String[] splitInfo = customerInfo.split(" ");
        for(int i=0;i<splitInfo.length;i++) {
            System.out.print(splitInfo[i] + " ");
        }
        System.out.println();
        return new ArrayList<>();
    }
    */
}
