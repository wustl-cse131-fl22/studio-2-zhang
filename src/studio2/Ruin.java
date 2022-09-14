package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// user input
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a start amount: ");
		int startAmount = in.nextInt();
		
		System.out.println("Enter win chance: ");
		double winChance = in.nextDouble();
		
		System.out.println("Enter win limit: ");
		int winLimit = in.nextInt();
		
		System.out.println("Enter total simulations: ");
		int totalSimulations = in.nextInt();
		
		
		// loop
		int totalLosses = 0;
		for (int i = 1; i < totalSimulations; i++) {
			
			int numOfGames = 0;
			int changeAmount = startAmount;
			
				while ((changeAmount > 0) && (changeAmount < winLimit))
				{
					if (Math.random() < winChance) {
						changeAmount++;
					} else {
						changeAmount--;	
					}
					numOfGames++;
				}
				
			if (changeAmount ==0) {
				System.out.println("Simulation "+i+ ": "+ numOfGames+ " LOSE");
				totalLosses++;
			} else {
				System.out.println("Simulation " +i+ ": "+ numOfGames+ " WIN");
			}
			
		}
		
		double expectedRuin;
		double a = (1-winChance)/winChance;
		
		if (winChance == 0.5)
		{
			expectedRuin = (1-(startAmount/winLimit));
			
		}
		else {
			// 
			expectedRuin = (Math.pow(a,startAmount)-Math.pow(a,winLimit))/1-Math.pow(a,winLimit);
		}
		
		
		System.out.println("Losses: " + totalLosses);
		System.out.println("Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: "+ (double)(totalLosses/totalSimulations) + "Expected ruin rate: " + expectedRuin);
		
	
		
	}

}
