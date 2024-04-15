package main;

public class Main {

	public static void main(String[] args) 
	{
		final String strValidDirections = "FBRL";
		
		
		if(args.length != 1)//Make sure the program has an argument
		{
			System.out.println("Error: This program must take exactly 1 argument");
			return;
		}
		
		String strPath = args[0];
		String strNumber = "";
		double dblNorth = 0;
		double dblEast = 0;
		
		while(strPath.length() >= 1)//While there are still instructions left
		{
			char chrFirstChar = strPath.charAt(0);
			if(Character.isDigit(chrFirstChar) || chrFirstChar == '.')//If next char is a number or a decimal point
			{
				strNumber += chrFirstChar;//Add it to the number
			}else if(strValidDirections.indexOf(chrFirstChar) != -1)//If next char is a valid direction
			{
				double dblDistance = Double.parseDouble(strNumber);
				strNumber = "";
				switch(chrFirstChar)
				{
					case 'F':
						dblNorth += dblDistance;
						break;
					case 'B':
						dblNorth -= dblDistance;
						break;
					case 'R':
						dblEast += dblDistance;
						break;
					case 'L':
						dblEast -= dblDistance;
						break;
				}
			}else//Next char is not a number or a valid direction
			{
				System.out.println("Error: An invalid character was found in the input string. Please check your input string.");
				return;
			}
			
			strPath = strPath.substring(1);//Cut down the remaining string
		}
		
		
		double dblResult = Math.sqrt((dblNorth * dblNorth) + (dblEast * dblEast));//Pythagorean theorem
		
		System.out.printf("You are %f steps from your starting location%n", dblResult);

		//System.out.printf("Additionally, you are %f steps north and %f steps east of your starting location%n", dblNorth, dblEast);//Unused extra information
	}

}
