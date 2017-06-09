/*
    This class associates a rental with a car and a customer
 */
package core;

import core.*;

public class Rental
{
    // Insantiate member variables
    public Vehicle vehicle;
    public Customer customer;
    
    // Instantiate variables when new Rental class is created
    public Rental()
    {
        this.vehicle = new Vehicle();
        this.customer = new Customer();
    }
    
    public Rental(Vehicle vehicle, Customer customer)
    {
        this.vehicle = vehicle;
        this.customer = customer;
    }
}
