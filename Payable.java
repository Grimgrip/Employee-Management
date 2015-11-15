package employeemanagement;

public interface Payable 
{
    double getGrossAmount();
    
    double getFederalDeduction();
    
    double getStateDeduction();
}