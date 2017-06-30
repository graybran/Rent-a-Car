package core;

public class Employee
{
    private int empID;
    private Customer servicedCustomer;
    private Vehicle rentedCar;
    
    private String firstName;
    private String lastName;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
