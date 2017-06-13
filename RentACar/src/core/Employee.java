package core;

public class Employee
{
    private int empID;
    private Customer servicedCustomer;
    private Vehicle rentedCar;        

    public int getEmpID()
    {
        return empID;
    }

    public void setEmpID(int empID)
    {
        this.empID = empID;
    }

    public Customer getServicedCustomer()
    {
        return servicedCustomer;
    }

    public void setServicedCustomer(Customer servicedCustomer)
    {
        this.servicedCustomer = servicedCustomer;
    }

    public Vehicle getRentedCar()
    {
        return rentedCar;
    }

    public void setRentedCar(Vehicle rentedCar)
    {
        this.rentedCar = rentedCar;
    }
}
