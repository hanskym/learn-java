package bab10;

public class SalariedEmployee1 extends Employee1 {
	private double weeklySalary;
	
	public SalariedEmployee1(String first, String last, String ssn, double salary)
	{
		super(first, last, ssn);
		setWeeklySalary(salary);
	}
	
	public void setWeeklySalary(double salary)
	{
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	}
	
	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return getWeeklySalary();
	}
	
	@Override
	public String toString()
	{
		return String.format("salaried employee: %s\n%s: $%,.2f",
				super.toString(), "weekly salary", getWeeklySalary());
	}
}
