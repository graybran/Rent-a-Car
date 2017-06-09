/*
    This is the class customer. New customer objects can be created with this
*/

package core;

public class Customer
{
    // Insantiate member variables
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String phoneNumber;
    private int age;
    
    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }
}
