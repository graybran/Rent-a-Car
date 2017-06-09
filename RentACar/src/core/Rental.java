/*
    This class associates a rental with a car and a customer
 */
package core;

import core.*;

public class Rental
{
    // Insantiate member variables
    private Vehicle car;
    private Customer customer;
    
    // Instantiate variables when new Rental class is created
    public Rental()
    {
        this.car = new Vehicle();
        this.customer = new Customer();
    }
    
    public Rental(Vehicle car, Customer customer)
    {
        this.car = car;
        this.customer = customer;
    }
}
