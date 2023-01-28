package bab8;

public class Employee1Test {
	public static void main(String[] args)
	{
		System.out.printf("Employees before instantiation: %d\n", Employee1.getCount());
		
		Employee1 e1 = new Employee1("Susan", "Baker");
		Employee1 e2 = new Employee1("Bob", "Blue");
		
		System.out.println("\nEmployees after instantiation: ");
		System.out.printf("via e1.getCount(): %d\n", e1.getCount());
		System.out.printf("via e2.getCount(): %d\n", e2.getCount());
		System.out.printf("via Employee1.getCount(): %d\n", Employee1.getCount());
		
		System.out.printf("\nEmployee 1: %s %s\nEmployee 2: %s %s\n",
				e1.getFirstName(), e1.getLastName(),
				e2.getFirstName(), e2.getLastName());
		
		e1 = null;
		e2 = null;
	}
}
