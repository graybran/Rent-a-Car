/*
    Main class. Class initiates program
*/

package rentacar;


import userInterface.RentacarUI;
import core.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rentacar
{
	private static String dbURL = "jdbc:derby:Inventory;create=true";
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args)
	{
		// First connect to database
		createConnection();
		
		// Second, check if tables are already present
		// If not present, create tables and Admin Account
		try 
		{
			ResultSet res = conn.getMetaData().getTables(null, "APP", "%", null);
			boolean tablesExist = res.next();
			if(!tablesExist)
			{
				setupDatabase();
				sampleData();			// Also some sample data
			}
		} 
		catch (SQLException ex) 
		{
			Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		// Printing out data to show it committed

/*	
		selectCustomers();
		removeCustomer(1);
		updateAge(2, 50);
		updatePhoneNumber(2, "555-555-5555");
		updateEmail(2, "CuStOmErTwO@updatedentry.com");
		selectCustomers();
*/

/*
		selectVehicles();
		removeVehicle("SampleVIN1");
		updateAvailability("SampleVIN2", false);
		updateDamages("SampleVIN2", "TOTALLED");
		updateGasLevel("SampleVIN2", "EMPTY");
		updateMileage("SampleVIN2", 1000000);
		selectVehicles();
*/

/*
		selectEmployees();
		removeEmployee(1);
		selectEmployees();
*/

/*
		selectCurrentRentals();
		removeCurrentRental("SampleVIN1");
		selectCurrentRentals();
*/
	
		dropTables();
		
		
		
		
      /* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RentacarUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new RentacarUI().setVisible(true);
			}
		});
		
		
	}
	
	// Inserts sample data into database
	private static void sampleData()
	{
		insertEmployee(1, "First1", "Last1", false);
		insertEmployee(2, "First2", "Last2", false);
		insertEmployee(3, "First3", "Last3", false);
		
		insertCustomer(1, "Cust1", "1Last", 25, "4071234567", "customer1@customer.com");
		insertCustomer(2, "Cust2", "2Last", 35, "4077654321", "customer2@customer.com");
		
		insertVehicle("SampleVIN1", "Honda", "Civic", 2013, "Black", "Compact", true, 50, "None", "Full", 10000);
		insertVehicle("SampleVIN2", "Toyota", "Camry", 2014, "Red", "Mid-size", true, 50, "None", "Full", 15000);
		insertVehicle("SampleVIN3", "Ford", "Fusion", 2015, "White", "Mid-size", true, 50, "None", "Full", 20000);
		
		Date sampleDate = new Date();
		
		insertCurrentRental("SampleVIN1", sampleDate, sampleDate, 1);
		insertCurrentRental("SampleVIN2", sampleDate, sampleDate, 2);
		insertCurrentRental("SampleVIN3", sampleDate, sampleDate, 3);
	}
	
	// Creates tables and Admin Account
	private static void setupDatabase()
	{
		createTables();
		createDefaultAdminAccount();
	}
	
	// Deletes all tables from database
	private static void dropTables()
	{
		try 
		{
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE Vehicles");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE Employees");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE Customers");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE CurrentRentals");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE PastRentals");
			stmt.close();
			
		} 
		catch (SQLException ex) 
		{
			Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Establishes a connection with the database
	private static void createConnection()
	{
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			//Get a connection
			conn = DriverManager.getConnection(dbURL); 
		}
		catch (Exception except)
		{
			except.printStackTrace();
		}
	}
	
	// Creates the database tables
	private static void createTables()
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("create table Vehicles (VIN VARCHAR(30) PRIMARY KEY, MAKE VARCHAR(20), MODEL VARCHAR(30), ModelYEAR INT, COLOR VARCHAR(20), CLASS VARCHAR(20), AVAILABLE boolean, PRICE float, DAMAGES VARCHAR(1000), GASLEVEL VARCHAR(20), MILEAGE INT)");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("create table Employees (empID int PRIMARY KEY, FirstName VARCHAR(20), LastName VARCHAR(30), AdminPrivilege boolean)");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("create table Customers (CustomerID int PRIMARY KEY, FirstName VARCHAR(20), LastName VARCHAR(30), Age INT, PhoneNumber VARCHAR(20), email VARCHAR(30))");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("create table CurrentRentals (VIN VARCHAR(30) PRIMARY KEY, RentalStartDate date, RentalEndDate date, CustomerID int)");
			stmt.close();
			
			stmt = conn.createStatement();
			stmt.execute("create table PastRentals (RentalID int PRIMARY KEY, VIN VARCHAR(30), RentalStartDate date, RentalEndDate date, CustomerID int)");
			stmt.close();
		} 
		catch (SQLException ex) 
		{
			Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Creates default Admin Account
	private static void createDefaultAdminAccount()
	{
		insertEmployee(0, "Store", "Manager", true);
	}
	
	// Inserts a new customer into the database
	public static void insertCustomer(int CustomerID, String FirstName, String LastName, int Age, String PhoneNumber, String email)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("insert into Customers values (" + CustomerID + ", '" + FirstName + "', '" + LastName + "', " + Age + ", '" + PhoneNumber + "', '" + email + "')");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Inserts a new employee into the database
	public static void insertEmployee(int empID, String FirstName, String LastName, boolean isAdmin)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("insert into Employees values (" + empID + ", '" + FirstName + "', '" + LastName + "', " + isAdmin + ")");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Inserts a new vehicle into the database
	public static void insertVehicle(String VIN, String Make, String Model, int Year, String Color, String Class, boolean Available, double Price, String Damages, String GasLevel, int mileage)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("insert into Vehicles values ('" + VIN + "', '" + Make + "', '" + Model + "', " + Year + ", '" + Color + "', '" + Class + "', " + Available + ", " + Price + ", '" + Damages + "', '" + GasLevel + "', " + mileage + ")");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
    
	// Prints out information on all vehicles in database
	private static void selectVehicles()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from Vehicles");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i=1; i<=numberCols; i++)
			{
				//print Column Names
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
			}

			System.out.println("\n-------------------------------------------------");

			while(results.next())
			{
				String VIN = results.getString(1);
				String Make = results.getString(2);
				String Model = results.getString(3);
				int YEAR = results.getInt(4);
				String Color = results.getString(5);
				String Class = results.getString(6);
				boolean Available = results.getBoolean(7);
				double Price = results.getDouble(8);
				String Damages = results.getString(9);
				String GasLevel = results.getString(10);
				int mileage = results.getInt(11);
				
				System.out.println(VIN + "\t\t" + Make + "\t\t" + Model + "\t\t" + YEAR + "\t\t" + Color + "\t\t" + Class + "\t\t" + Available + "\t\t" + Price + "\t\t" + Damages + "\t\t" + GasLevel + "\t\t" + mileage);
			}
			System.out.println("\n\n");
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}

	// Prints out information on all employees in database
	private static void selectEmployees()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from Employees");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i=1; i<=numberCols; i++)
			{
				//print Column Names
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
			}

			System.out.println("\n-------------------------------------------------");

			while(results.next())
			{
				int empID = results.getInt(1);
				String FirstName = results.getString(2);
				String LastName = results.getString(3);
				boolean isAdmin = results.getBoolean(4);
				
				System.out.println(empID + "\t\t" + FirstName + "\t\t" + LastName + "\t\t" + isAdmin);
			}
			System.out.println("\n\n");
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
    
	// Prints out information on all customers in database
	private static void selectCustomers()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from Customers");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i=1; i<=numberCols; i++)
			{
				//print Column Names
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
			}

			System.out.println("\n-------------------------------------------------");

			while(results.next())
			{
				int custID = results.getInt(1);
				String FirstName = results.getString(2);
				String LastName = results.getString(3);
				int Age = results.getInt(4);
				String PhoneNumber = results.getString(5);
				String email = results.getString(6);
				
				System.out.println(custID + "\t\t" + FirstName + "\t\t" + LastName + "\t\t" + Age + "\t\t" + PhoneNumber + "\t\t" + email);
			}
			System.out.println("\n\n");
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Prints our information on all CurrentRentals in the database
	private static void selectCurrentRentals()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from CurrentRentals");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i=1; i<=numberCols; i++)
			{
				//print Column Names
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
			}

			System.out.println("\n-------------------------------------------------");

			while(results.next())
			{
				String VIN = results.getString(1);
				Date startDate = results.getDate(2);
				Date endDate = results.getDate(3);
				int custID = results.getInt(4);
				
				System.out.println(VIN + "\t\t" + startDate + "\t\t" + endDate + "\t\t" + custID);
			}
			System.out.println("\n\n");
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Closes out of database
	private static void shutdown()
	{
		try
		{
			if (stmt != null)
			{
				stmt.close();
			}
			if (conn != null)
			{
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}           
		} 
		catch (SQLException ex) 
		{
			Logger.getLogger(Rentacar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Insert into CurrentRentals
	public static void insertCurrentRental(String VIN, Date startDate, Date endDate, int custID)
	{
		// Convert java.util.Date to java.sql.Date
		java.sql.Date beginDate = new java.sql.Date(startDate.getTime());
		java.sql.Date finishDate = new java.sql.Date(endDate.getTime());

		try
		{
			stmt = conn.createStatement();
			stmt.execute("insert into CurrentRentals values ('" + VIN + "', '" + beginDate + "', '" + finishDate + "', " + custID + ")");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Insert into CurrentRentals
	public static void insertPastRental(int inactiveRentalID, String VIN, Date startDate, Date endDate, int custID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("insert into CurrentRentals values (" + inactiveRentalID + ", '" + VIN + "', " + startDate + ", " + endDate + ", " + custID + ")");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Remove from Employees
	public static void removeEmployee(int empID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("delete from Employees where empID = " + empID );
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Remove from CurrentRentals 
	public static void removeCurrentRental(String VIN)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("delete from CurrentRentals where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Remove from Customers
	public static void removeCustomer(int custID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("delete from Customers where customerID = " + custID );
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Remove from Vehicles
	public static void removeVehicle(String VIN)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("delete from Vehicles where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Vehicle Availablility
	public static void updateAvailability(String VIN, boolean available)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Vehicles set available = " + available + " where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Vehicle Damages
	public static void updateDamages(String VIN, String Damages)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Vehicles set Damages = '" + Damages + "' where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Vehicle Gas Level
	public static void updateGasLevel(String VIN, String GasLevel)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Vehicles set GasLevel = '" + GasLevel + "' where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Vehicle Mileage
	public static void updateMileage(String VIN, int mileage)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Vehicles set mileage = " + mileage + " where VIN = '" + VIN + "'");
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Customer Age
	public static void updateAge(int custID, int newAge)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Customers set age = " + newAge + " where customerID = " + custID);
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Customer Phone Number
	public static void updatePhoneNumber(int custID, String newNumber)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Customers set phonenumber = '" + newNumber + "' where customerID = " + custID);
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
	
	// Change Customer email address
	public static void updateEmail(int custID, String newEmail)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("update Customers set email = '" + newEmail + "' where customerID = " + custID);
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}
}






