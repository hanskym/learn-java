package bab22;

public class EmptyListException extends RuntimeException {
	public EmptyListException()
	{
		this("List");
	}
	
	public EmptyListException(String name)
	{
		super(name + " is empty");
	}
}
