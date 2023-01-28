package belajar;

import java.util.Random;

public class Player {
	String name;
	int healthPoin;
	int level;
	
	public static final Random randomNumbers = new Random();
	
	// definisi method attack
	public int attack()
	{
		// set besar serangan
		int attack = (int) (Math.random() * (25 - 10)) + 10;
		return attack;
	}
	
	// definisi method run
	public void run()
	{
		System.out.println(name +" is running...");
		System.out.println("Health Poin: "+ healthPoin);
		System.out.println("Player Level: "+ level);
	}
	
	// definisi method isDead untuk mengecek nilai kesehatan (healthPoin)
	boolean isDead()
	{
		if(healthPoin <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
    }
}
