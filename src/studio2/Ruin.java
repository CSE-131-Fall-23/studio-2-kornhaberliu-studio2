package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("How much money are you starting with?: $");
		double startAmount = in.nextDouble();
		
		System.out.print("What is the probability that you win a single game?(between 0 and 1): ");
		double winChance = in.nextDouble();
		
		System.out.print("What is the amount of money that if you win you had a successful day and leave?: $");
		double winLimit = in.nextDouble();
		
		System.out.print("How many days would you like to play?: ");
		int totalSimulations = in.nextInt();
		
		double initialStart = startAmount;
		int ruins = 0;
		for(int i = 1; i <= totalSimulations; i++)
		{
			int runs = 0;
			while(startAmount > 0 && startAmount < winLimit)
			{
				runs++;
				double random = Math.random();
				if(random < winChance)
					startAmount++;
				else
					startAmount--;
			}
			System.out.print("Simulation " + i + ": " + runs + " ");
			if(startAmount == winLimit)
				System.out.println("Success");
			else
			{
				System.out.println("Ruin");
				ruins++;
			}
			startAmount = initialStart;
		}		
		
		System.out.println("Losses: " + ruins + " Simulations: " + totalSimulations);
		double expectedRuinRate =0;
		if(winChance == .5)
		{
			expectedRuinRate = 1- startAmount/winLimit;
		}
		else
		{
			double alpha = (1-winChance)/winChance;
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + Math.round((double)ruins/totalSimulations * 100)/100.0 + "% Expected Ruin Rate: " + expectedRuinRate);
	}

}
