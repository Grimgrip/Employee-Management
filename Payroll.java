package employeemanagement;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Payroll 
{
        private ArrayList<Department> departmentList;
        private NumberFormat fmt;

        // constructor already implemented
         public Payroll(ArrayList<Department> departments)
         {
             departmentList = departments;
             fmt = NumberFormat.getCurrencyInstance();
         }

         // this is pretty much the same method we had in the Report class from assignment 1
         public void print()
         {
             // Create and setup the output window.
             JFrame frame = new JFrame("Payroll Data System");
             frame.setSize(600, 600);

             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.getContentPane().setLayout(new BorderLayout());

             JTextArea textArea = new JTextArea();
                     textArea.setFont(new Font( Font.MONOSPACED, Font.PLAIN, 12));
                     textArea.setForeground(Color.BLACK);
                     textArea.append(generatePayrollData()); 
                     textArea.setVisible(true);

             JScrollPane scrollableTextArea = new JScrollPane(textArea);
             scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
             scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

             frame.getContentPane().add(scrollableTextArea); 
             frame.setVisible(true);
         }


         // write the code that generates the output payroll data given that departmentList has been populated with all the 
         //company�s departments and that every department has a Manager and a list of Employees
         private String generatePayrollData()
         { 
             //two for loops. Outer has departments, inner has employees
             String output = "";

                     output += "      --------------------Payroll Data--------------------\n";

                     for ( Department department : departmentList ) {

                             output += "------------------------------------------------------------------\n";
                             output += String.format( "%s (%s)\n", department.getDepartmentName(), department.getDepartmentID());
                             output += "------------------------------------------------------------------\n";

                             // Manager♦
                             output += "Manager:\n";
                             Manager manager = department.getDepartmentManager();
                             if (manager != null) {
                                     output += getNameLine(  manager.getFirstName() + " " + manager.getLastName(), manager.getGrossAmount() );
                                     output += getPayrollLine( "Bonus after tax:", manager.getBonusAfterTax() );

                                     output += getPayrollLine( "Federal tax:", manager.getFederalDeduction() );
                                     output += getPayrollLine( "State tax:", manager.getStateDeduction() );

                                     double netPay = manager.getGrossAmount() + manager.getBonusAfterTax()
                                                                     - ( manager.getFederalDeduction() + manager.getStateDeduction() );
                                     output += getPayrollLine( "Net Pay:", netPay );
                             }

                             output += "Employees:\n";
                             for ( Employee employee : department.getEmployees()) {
                                     output += getNameLine( employee.getFirstName() + " " + employee.getLastName(), employee.getGrossAmount() );
                                     output += getPayrollLine( "Federal tax:", employee.getFederalDeduction() );
                                     output += getPayrollLine( "State tax:", employee.getStateDeduction() );

                                     double netPay = employee.getGrossAmount() - ( employee.getFederalDeduction() + employee.getStateDeduction() );
                                     output += getPayrollLine( "Net Pay:", netPay );
                                     output += "\n";
                             }
                     }
             return output;
         }

        // this method has been provided for you to use in the generatePayrollData method
        // it prints the line that has the name and gross amount
         private String getNameLine(String name, double value)
         {
             return String.format("%-40s", name) + "Gross Amount:" + String.format("%13s%n", fmt.format(value));
         }

        // this method has been provided for you to use in the generatePayrollData method
        // it prints the lines that only have an amount such as Federal tax, etc.
         private String getPayrollLine(String title, double value)
         {
             return String.format("%53s", title) + String.format("%13s%n", fmt.format(value));
         }    
}
