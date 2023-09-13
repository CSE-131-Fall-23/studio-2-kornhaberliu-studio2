package studio2;

public class Pi {

	public static void main(String[] args) {
		int inside = 0;
		for(int i = 1; i <= 10000; i++)
		{
			double xPos = Math.random()-.5;
			double yPos = Math.random() -.5;
			if(Math.pow(xPos, 2) + Math.pow(yPos, 2)<= .25)
			{
				inside++;
			}
		}
		System.out.print((double)inside/10000 * 4);
	}

}
