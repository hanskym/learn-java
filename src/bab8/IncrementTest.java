package bab8;

public class IncrementTest {
	public static void main(String[] args)
	{
		Increment value = new Increment(5);
		
		System.out.printf("before incrementing: %s\n\n", value);
		
		for(int i = 1; i <= 3; i++)
		{
			value.addIncrementToTotal();
			System.out.printf("After increment %d: %s\n", i, value);
		}
	}
}
