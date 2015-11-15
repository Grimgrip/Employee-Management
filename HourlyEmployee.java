package employeemanagement;

public class HourlyEmployee extends Employee
{
    private double hourlyRate;
    private int periodHours;
    
    private static final double MINIMUM_PAY_RATE = 7.50;
    private static final int MINIMUM_NUMBER_OF_HOURS = 40;
    private static final double TAX_RATE_THRESHOLD_HOURS = 80;
    private static final double FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD_HOURS = 10;
    private static final double FEDERAL_TAX_RATE_THRESHOLD_OR_MORE_HOURS = 15;
    private static final double STATE_TAX_RATE_LESS_THAN_THRESHOLD_HOURS = 5;
    private static final double STATE_TAX_RATE_THRESHOLD_OR_MORE_HOURS = 7;
    
    // constructor � call the super class constructor
    // make sure that hourlyRate is no less than MINIMUM_PAY_RATE and periodHours is no less than MINIMUM_NUMBER_OF_HOURS
    public HourlyEmployee(String id, String first, String last, String birth, String hired, double rate, int hours)
    {
    	super(id, first, last, birth, hired);
    	
		setHourlyRate( rate );
		setPeriodHours( hours );
    }
    
    public double getHourlyRate()
    {
    	return hourlyRate;
    }
    
    public int getPeriodHours()
    {
    	return periodHours;
    }
    
    // perform same check as in the constructor
    public void setHourlyRate(double rate)
    {
		if ( rate < MINIMUM_PAY_RATE ) {
			this.hourlyRate = MINIMUM_PAY_RATE;
		} else {
			this.hourlyRate = rate;
		}
    }
    
    // perform same check as in the constructor
    public void setPeriodHours(int hours)
    {
		if ( hours < MINIMUM_NUMBER_OF_HOURS ) {
			this.periodHours = MINIMUM_NUMBER_OF_HOURS;
		} else {
			this.periodHours = hours;
		}
    }
    
    @Override
   // calculate the gross amount for this pay period. 
    public double getGrossAmount()
    {
    	return this.hourlyRate * this.periodHours;
    }
    
    @Override
    // calculate the federal tax deduction for this pay period given the value of periodHours
    public double getFederalDeduction()
    {
    	//private static final double FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD_HOURS = 10;
        //private static final double FEDERAL_TAX_RATE_THRESHOLD_OR_MORE_HOURS = 15;
    	//private static final double TAX_RATE_THRESHOLD_HOURS = 80;


		double federalTaxRate;
		if ( periodHours < TAX_RATE_THRESHOLD_HOURS ) {
			federalTaxRate = FEDERAL_TAX_RATE_LESS_THAN_THRESHOLD_HOURS;
		} else {
			federalTaxRate = FEDERAL_TAX_RATE_THRESHOLD_OR_MORE_HOURS;
		}
		double fedTaxDeduction = this.getGrossAmount() * federalTaxRate / 100;

		return fedTaxDeduction;
    	
    	
    }
    
    @Override
   // calculate the state tax deduction for this pay period given the value of periodHours
    public double getStateDeduction()
    {
    	//private static final double STATE_TAX_RATE_LESS_THAN_THRESHOLD_HOURS = 5;
        //private static final double STATE_TAX_RATE_THRESHOLD_OR_MORE_HOURS = 7;
    	//private static final double TAX_RATE_THRESHOLD_HOURS = 80;


		double stateTaxRate;
		if ( periodHours < TAX_RATE_THRESHOLD_HOURS ) {
			stateTaxRate = STATE_TAX_RATE_LESS_THAN_THRESHOLD_HOURS;
		} else {
			stateTaxRate = STATE_TAX_RATE_THRESHOLD_OR_MORE_HOURS;
		}
		double stateTaxDeduction = this.getGrossAmount() * stateTaxRate / 100;
		return stateTaxDeduction;
    }
    
}
