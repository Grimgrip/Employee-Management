package employeemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class EmployeeManagement 
{
    private static ArrayList<Department> departmentList = new ArrayList<Department>();
    
    public static void main(String[] args)
    {
        File selectedFile;
        JFileChooser fileChooser = new JFileChooser();
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = fileChooser.getSelectedFile(); 
        
            try
            {
                @SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader (selectedFile));
                String line = reader.readLine();
                
                while(line != null && !line.isEmpty())
                {
                    processDataRecord(line);
                    line = reader.readLine();
                }
            }
            catch(IOException e) 
            {
                System.out.println(e.toString()); 
            }   
            
            // after reading the entire input file, we can generate the payroll data
            Payroll payroll = new Payroll(departmentList);
            payroll.print();
        }
    }
    
    // this method gets called for every line of data in the input file
    // check the record type
    // if D, create a Department object and add it to the departmentList
    // if S, create a salariedEmployee object and add it to the employees list of his/her department
    // if H, create an hourlyEmployee object and add it to the employees list of his/her department
    // if M, create a Manager object and set the manager instance variable of his/her department
    // note: use the findDepartment method of this class provided for you
    public static void processDataRecord(String line)
    {
		char departmentType = line.charAt( 0 );
		String[] parts = line.split( "," );

		switch ( departmentType ) {
			case 'D': {
				// Format: record type,department id,department name
				//String recordType = parts[0];
				String departmentId = parts[ 1 ];
				String departmentName = parts[ 2 ];

				Department dept = new Department( departmentId, departmentName );
				departmentList.add( dept );

				//System.out.print("Department: " + parts[1] + " ");
				//System.out.println(parts[2]);
				//System.out.println( "Departments: " + departmentList );
				break;
			}
			case 'S': {
				//record type,employee id,first name,last name,date of birth,hire date,annual salary,department id
				//takes in String id, String first, String last, String birth, String hired, double salary
				//String recordType = parts[0];
				String employeeId = parts[ 1 ];
				String fname = parts[ 2 ];
				String lname = parts[ 3 ];
				String birthDate = parts[ 4 ];
				String hireDate = parts[ 5 ];
				double yearSalary = Double.parseDouble(parts[ 6 ]);
				String departmentId = parts[ 7 ];

				SalariedEmployee salariedEmployee = new SalariedEmployee( employeeId, fname, lname, birthDate, hireDate, yearSalary );

				// Find Department to add this employee
				Department employeeDepartment = findDepartment( departmentId );
				if (employeeDepartment != null) {
					employeeDepartment.addEmployee( salariedEmployee );
				}

				//System.out.println( "This is a Salaried employee." );
				break;
			}
			case 'H': {
				//record type,employee id,first name,last name,date of birth,hire date,	hourly rate, pay period hours, department id
				//takes in String id, String first, String last, String birth, String hired, double rate, int hours

				//String recordType =       parts[0];
				String id = parts[ 1 ];
				String fname = parts[ 2 ];
				String lname = parts[ 3 ];
				String birthDate = parts[ 4 ];
				String hireDate = parts[ 5 ];
				double hourlyRate = Double.parseDouble( parts[ 6 ] );
				int payPeriodHours = Integer.parseInt( parts[ 7 ] );
				String departmentId = parts[ 8 ];

				HourlyEmployee hourlyEmployee = new HourlyEmployee( id, fname, lname, birthDate, hireDate, hourlyRate, payPeriodHours );

				// Find Department to add this employee
				Department employeeDepartment = findDepartment( departmentId );
				if ( employeeDepartment != null ) {
					employeeDepartment.addEmployee( hourlyEmployee );
				}
				//System.out.println( "This is an Hourly Employee." );
				break;
			}

			case 'M': {
				//record type,employee id,first name,last name,date of birth,hire date,annual salary,bi-weekly bonus,department id
				//takes in String id, String first, String last, String birth, String hired, double salary, double bonus
				//String recordType =       parts[0];
				String id = parts[ 1 ];
				String fname = parts[ 2 ];
				String lname = parts[ 3 ];
				String birthDate = parts[ 4 ];
				String hireDate = parts[ 5 ];
				double annualSalary = Double.parseDouble( parts[ 6 ] );
				double biWeeklyBonus = Double.parseDouble( parts[ 7 ] );
				String departmentId = parts[ 8 ];

				Manager manager = new Manager( id, fname, lname, birthDate, hireDate, annualSalary, biWeeklyBonus );

				// Find Department to add this manager
				Department employeeDepartment = findDepartment( departmentId );
				if ( employeeDepartment != null ) {
					employeeDepartment.setManager( manager );
				}

				//System.out.println( "This is a Manager." );
				break;
			}
		}
    }
    
    public static Department findDepartment(String deptId)
    {
        for(Department dept:departmentList)
        {
            if(dept.getDepartmentID().equals(deptId))
                return dept;
        }
        return null;
    }

}
