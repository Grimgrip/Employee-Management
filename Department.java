package employeemanagement;

import java.util.ArrayList;

public class Department 
{
    private String departmentID;
    private String departmentName;
    private Manager departmentManager;
    private ArrayList<Employee> employees;
    
    // initialize the employees to a blank ArrayList of Departments.
    public Department(String id, String name)
    {
    	this.departmentID = id;
    	this.departmentName = name;
		this.employees = new ArrayList<Employee>();
    }
    
    public String getDepartmentID()
    {
    	return departmentID;
    }
    
    public String getDepartmentName()
    {
    	return departmentName;
    }
    
    public Manager getDepartmentManager()
    {
    	return departmentManager;
    }
    
    public ArrayList<Employee> getEmployees()
    {
    	return employees;
    }
    
    public void setDepartmentName(String name)
    {
    	departmentName = name;
    }
    
    public void setManager(Manager deptManager)
    {
    	departmentManager = deptManager;
    }
    
    public void setEmployees(ArrayList<Employee> employeeList)
    {
    	employees = employeeList;
    }
    
    public void addEmployee(Employee deptEmployee)
    {
    	employees.add( deptEmployee );
    }
    
    // two departments are considered equal if they have the same deparment id
    public boolean equals(Department dept)
    {
    	return dept.getDepartmentID().equals( departmentID );
    }
    
    public String toString()
    {
    	return this.getDepartmentName() + ", " + this.getDepartmentID();
    }    
}
