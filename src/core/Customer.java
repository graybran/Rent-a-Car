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
    private int rentalID;
    
    private Vehicle rentedCar;
    
    
    public int getCustID(){
        return custID;
    }
    public void setCustID(int ID){
        this.custID = ID;
    }
    
    public int getRentalID(){
        return rentalID;
    }
    public void setRentalID(int ID){
        this.rentalID = ID;
    }
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
}