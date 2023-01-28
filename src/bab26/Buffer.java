package bab26;

public interface Buffer {
	public void set(int value) throws InterruptedException;
	
	public int get() throws InterruptedException;
}
