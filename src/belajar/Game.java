package belajar;

import java.util.Scanner;
import java.util.Random;

public class Game {
	public static void main(String[] args)
	{
		Random random = new Random();
		
		// membuat objek player dan musuh
		Player player = new Player();
		Enemy enemy = new Enemy();
		
		// deklarasi input
		Scanner input = new Scanner(System.in);
		
		// mengisi atribut player
		System.out.print("Enter player name: ");
		player.name = input.next();
		
		player.healthPoin = 100;
		player.level = 1;
		player.run();
		
		// memanggil musuh
		System.out.println("\nNew enemy appear");
		
		System.out.print("Enter enemy name: ");
		enemy.name = input.next();
		input.close();
		
		enemy.enemy();
		
		// pertarungan
		System.out.println("\nFIGHT!");
		
		for(int i = 1; i <= 100; i++)
		{
			int chance = random.nextInt(2) + 1;
			
			switch(chance)
			{
			case 1:
				System.out.printf("\nPlayer turn\n");
				System.out.printf(player.name + " attacking " + enemy.name);
				int playerAttack = player.attack();
				System.out.printf("\nPlayer deal %d damage", playerAttack);
				enemy.healthPoin = enemy.healthPoin - playerAttack;
				System.out.printf("\nEnemy Health Point: %d\n", enemy.healthPoin);
				break;
			case 2:
				System.out.printf("\nEnemy turn\n");
				System.out.printf(enemy.name + " attacking " + player.name);
				int enemyAttack = enemy.attack();
				System.out.printf("\nEnemy deal %d damage", enemyAttack);
				player.healthPoin = player.healthPoin - enemyAttack;
				System.out.printf("\nPlayer Health Point: %d\n", player.healthPoin);
				break;
			}
			
			// cek status player dan musuh
			boolean playerStatus = player.isDead();
			boolean enemyStatus = enemy.isDead();
			
			if(enemyStatus == true)
			{
				System.out.println("\nPlayer Win!");
				break;
			}
			else if(playerStatus == true)
			{
				System.out.println("\nGame Over!");
				break;
			}
		}
	}
}
