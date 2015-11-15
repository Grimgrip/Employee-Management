package employeemanagement;


public class Manager extends SalariedEmployee
{
    private double biWeeklyBonus;
    public static final double BONUS_TAX_RATE = 20;
    
   // constructor  - � call the super class constructor
   // make sure that bonus is not a negative amount
   public Manager(String id, String first, String last, String birth, String hired, double salary, double bonus)
   {
	   super(id, first, last, birth, hired, salary);

	  setBiWeeklyBonus( bonus );
   }
    
    public double getBiWeeklyBonus()
    {
    	return biWeeklyBonus;
    }
    
    public double getBonusAfterTax()
    {
    	return biWeeklyBonus - (biWeeklyBonus * (BONUS_TAX_RATE / 100));
    }
    
    // perform same check as in the constructor
    public void setBiWeeklyBonus(double bonus)
    {
    	if (bonus < 0)
    	{
    		biWeeklyBonus = 0;
    	}
    	
    	biWeeklyBonus = bonus;
    }
    
    public String toString()
    {
    	return "Manager: " + super.toString();
    }    
}
