package employeemanagement;


public class SalariedEmployee extends Employee
{
    private double annualSalary;
    
    private static final double MINIMUM_ANNUAL_SALARY = 30000;		
    private static final int NUMBER_OF_PAY_PERIODS = 26;
    private static final double TAX_RATE_THRESHOLD = 45000;
    private static final double FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD = 12; 
    private static final double FEDERAL_TAX_RATE_THRESHOLD_OR_MORE = 17;
    private static final double STATE_TAX_RATE_LESS_THAN_THRESHOLD = 7;
    private static final double STATE_TAX_RATE_THRESHOLD_OR_MORE = 10;
    
    // constructor � call the super class constructor 
    // make sure that annualSalary is no less than MINIMUM_ANNUAL_SALARY
    public SalariedEmployee(String id, String first, String last, String birth, String hired, double salary)
    {
    	super(id, first, last, birth, hired);

	this.setAnnualSalary( salary );
    }
    
    public double getAnnualSalary()
    {
    	return annualSalary;
    }
    
    // perform same check as in the constructor
    public void setAnnualSalary(double salary)
    { 
    	if(salary < MINIMUM_ANNUAL_SALARY)
    	{
    		annualSalary = MINIMUM_ANNUAL_SALARY;
    	}
    	else
    	{
    		annualSalary = salary;
    	}
	}
    
    @Override
    // calculate the gross amount for this pay period.  Note: use the NUMBER_OF_PAY_PERIODS constant
    public double getGrossAmount()
    {
    	return this.annualSalary / NUMBER_OF_PAY_PERIODS;
    }
    
    @Override
   // calculate the state tax deduction for this pay period given the value of annualSalary
    public double getFederalDeduction()
    {
    	//private static final double FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD = 12; 
	    //private static final double FEDERAL_TAX_RATE_THRESHOLD_OR_MORE = 17;
    	
		double federalTaxRate;
		if ( annualSalary < TAX_RATE_THRESHOLD ) {
			federalTaxRate = FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD;
		} else {
			federalTaxRate = FEDERAL_TAX_RATE_THRESHOLD_OR_MORE;
		}
		double fedTaxDeduction = this.getGrossAmount() * federalTaxRate / 100;

    	return fedTaxDeduction;
    }
    
    @Override
    public double getStateDeduction()
    {
    	//private static final double STATE_TAX_RATE_LESS_THAN_THRESHOLD = 7;
	    //private static final double STATE_TAX_RATE_THRESHOLD_OR_MORE = 10;
    	
		double stateTaxRate;
		if ( annualSalary < TAX_RATE_THRESHOLD ) {
			stateTaxRate = STATE_TAX_RATE_LESS_THAN_THRESHOLD;
		} else {
			stateTaxRate = STATE_TAX_RATE_THRESHOLD_OR_MORE;
		}
		double stateTaxDeduction = this.getGrossAmount() * stateTaxRate / 100;
    	return stateTaxDeduction;
    }    
}
