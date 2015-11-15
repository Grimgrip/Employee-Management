package employeemanagement;


public class Employee implements Payable
{
    private String employeeID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateHired;
    
   // constructor - use the same toProperCase method from assignment 1 to format first and last names
    public Employee(String id, String first, String last, String birth, String hired)
    {
    	this.employeeID = id;
    	this.dateOfBirth = birth;
    	this.dateHired = hired;
    	this.firstName = toProperCase(first);
        this.lastName = toProperCase(last);
    }

    public String getEmployeeID()
    {
    	return employeeID;
    }
    
    public String getFirstName()
    {
    	return firstName;
    }
    
    public String getLastName()
    {
    	return lastName;
    }
    
    public String getDateOfBirth()
    {
    	return dateOfBirth;
    }
    
    public String getDateHired()
    {
    	return dateHired;
    }

    // remember to format the incoming first name as you did in the constructor
    public void setFirstName(String first)
    {
    	firstName = toProperCase(first);
    }
    
    // remember to format the incoming last name as you did in the constructor
    public void setLastName(String last)
    {
    	lastName = toProperCase(last);
    }
    
    public void setDateOfBirth(String birth)
    {
    	dateOfBirth = birth;
    }
    
    private static String toProperCase(String str)
    {
    	String name = str;
        String initial = "";

        name = name.toLowerCase();
        initial = name.substring(0, 1).toUpperCase();
        name = initial + name.substring(1,name.length());

        //System.out.print(name + " ");
        return str;
    }
    
    // you may use this method while generating the output 
    public String toString()
    {
    	return this.firstName + " " + this.lastName;
    }
    
    // these are the methods in the interface � the subclasses will provide the implementation
    public double getGrossAmount()
    {
        return 0;
    }
    
    public double getFederalDeduction()
    {
        return 0;
    }
    
    public double getStateDeduction()
    {
        return 0;
    }    
}
