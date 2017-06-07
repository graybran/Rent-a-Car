/*
    This class associates a rental with a car and a customer
 */
package core;

import core.*;

public class Rental
{
    // Insantiate member variables
    public Car car;
    public Customer customer;
    
    // Instantiate variables when new Rental class is created
    public Rental()
    {
        this.car = new Car();
        this.customer = new Customer();
    }
    
    public Rental(Car car, Customer customer)
    {
        this.car = car;
        this.customer = customer;
    }
}
