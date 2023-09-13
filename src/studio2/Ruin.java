package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("How much money are you starting with?: ");
		double startAmount = in.nextDouble();
		
		System.out.print("What is the probability that you win a single game?(between 0 and 1): ");
		double winChance = in.nextDouble();
		
		System.out.print("What is the amount of money that if you win you had a successful day and leave?: ");
		double winLimit = in.nextDouble();
		
		System.out.print("How many days would you like to play?: ");
		int totalSimulations = in.nextInt();
		
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
				System.out.println("Ruin");
		}		
	}

}
