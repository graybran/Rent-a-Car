package core;

import java.io.FileWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vehicle
{
    private int ID;
    private int year;
    private String make;
    private String model;
    private String carClass;
    private String color;
    private boolean availability;
    private double dailyPrice;
    private double gas; //percentage, .5 is half 1 is full
    private int mileage;
    private String dmgNotes;
    private Date nextMaintenance;
    
    private Customer customerRentedTo;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getCarClass()
    {
        return carClass;
    }

    public void setCarClass(String carClass)
    {
        this.carClass = carClass;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isAvailability()
    {
        return availability;
    }

    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    public double getDailyPrice()
    {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice)
    {
        this.dailyPrice = dailyPrice;
    }
    
    public double getGas(){
        return gas;
    }
    public void setGas(double gas){
        this.gas = gas;
    }
    
    public int getMileage(){
        return mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
    
    public String getDmgNotes(){
        return dmgNotes;
    }
    public void setDmgNotes(String dmgNotes){
        this.dmgNotes = dmgNotes;
    }
    
    
    public Customer getCustomerRentedTo() {
        return customerRentedTo;
    }

    public void setCustomerRentedTo(Customer customerRentedTo) {
        this.customerRentedTo = customerRentedTo;
    }

    public Date getNextMaintenance()
    {
        return nextMaintenance;
    }

    public void setNextMaintenance(Date nextMaintenance)
    {
        this.nextMaintenance = nextMaintenance;
    }
}
