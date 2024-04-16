import java.lang.NumberFormatException;

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
				if(strNumber == "")
				{
					System.out.println("Error: A direction was found without a preceding number. Please check your input.");
					return;
				}
				
				double dblDistance;
				try
				{
					dblDistance = Double.parseDouble(strNumber);//Try to parse the number
				}catch(NumberFormatException e)
				{
					System.out.println("Error: An invalid string was found preceding a direction.");
					return;
				}
				
				strNumber = "";//Reset the stored digits
				
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
		
		if(strNumber != "")
		{
			System.out.println("Warning: Input contained a trailing number without any direction. It was ignored for this result.");
		}
		
		
		double dblResult = Math.sqrt((dblNorth * dblNorth) + (dblEast * dblEast));//Pythagorean theorem
		
		System.out.printf("You are %f steps from your starting location%n", dblResult);

		//System.out.printf("Additionally, you are %f steps north and %f steps east of your starting location%n", dblNorth, dblEast);//Unused extra information
	}

}
