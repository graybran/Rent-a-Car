/*
    This is the class car. New car objects can be created with this
    The appropriate getters and setters are set
*/

package core;

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
    
}
