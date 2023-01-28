package belajar;

import java.util.Random;

public class Enemy {
	String name;
	int healthPoin = 100;
	int level = 1;
	
	public static final Random randomNumbers = new Random();
	
	// definisi method attack
	public int attack()
	{
		// set besar serangan
		int attack = (int) (Math.random() * (25 - 10)) + 10;
		return attack;
	}
	
	// definisi method run
	public void enemy()
	{
		System.out.println("Enemy is " + name);
		System.out.println("Health Poin: "+ healthPoin);
		System.out.println("Enemy Level: "+ level);
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
