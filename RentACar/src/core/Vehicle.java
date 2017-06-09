/*
    This is the class car. New car objects can be created with this
    The appropriate getters and setters are set
*/

package core;

public class Vehicle
{
    private int year;
    private String make;
    private String model;
    private String carClass;
    private String color;
    private boolean availability;
    private double dailyPrice;

    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * @return the make
     */
    public String getMake()
    {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make)
    {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * @return the carClass
     */
    public String getCarClass()
    {
        return carClass;
    }

    /**
     * @param carClass the carClass to set
     */
    public void setCarClass(String carClass)
    {
        this.carClass = carClass;
    }

    /**
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @return the availability
     */
    public boolean isAvailability()
    {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    /**
     * @return the dailyPrice
     */
    public double getDailyPrice()
    {
        return dailyPrice;
    }

    /**
     * @param dailyPrice the dailyPrice to set
     */
    public void setDailyPrice(double dailyPrice)
    {
        this.dailyPrice = dailyPrice;
    }
    
}
