/**
 * Delimiter matching algorithm.
 * */
import java.util.Scanner;

public class DelimiterMatcher 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ArrayStack<String> delimiterContainer = new ArrayStack<String>();//braces{}, brackets[], parentheses()
		String tmp = "";//This will hold each character being read from the input stream.
		Scanner sc = new Scanner(System.in);//Scanner reads input from command line.
		Scanner scanInputString = new Scanner(sc.nextLine());
		sc.close();
		
		/*Makes scanner read input one character at a time instead of one word
		 at a time because delimiter splits "words" around empty string instead 
		 of whitespace character.*/
		scanInputString.useDelimiter("");
		
		//Reading the next character from the input string.
		while(scanInputString.hasNext())
		{
			tmp = scanInputString.next();
			
			//Whenever you see a left (opening) delimiter, push it to the stack.
			if(tmp.equals("{") || tmp.equals("[") || tmp.equals("("))
			{
				delimiterContainer.push(tmp);
			}
			
			//Whenever you see a right (closing) delimiter pop the (hopefully matching) opening
			//delimiter from the stack, and If they don't match, report a matching error.*/
			else if(tmp.equals("}") || tmp.equals("]") || tmp.equals(")"))
			{
				//If you can't pop the stack because it is empty, report a missing left delimiter error.
				if(delimiterContainer.isEmpty())
				{
					System.out.println("Missing left delimiter error");
				}
				
				switch(tmp)
				{
					case "}" : if(!delimiterContainer.pop().equals("{")) System.out.println("Matching error");
									break;
								
					case "]" : if(!delimiterContainer.pop().equals("[")) System.out.println("Matching error");
									break;
					
					case ")" : if(!delimiterContainer.pop().equals("(")) System.out.println("Matching error");
									break;
				}
			}	
		}
		
		scanInputString.close();
		
		/*If the stack is non-empty after all the characters of the expression have been processed,
		report a missing right delimiter error.*/
		if(!delimiterContainer.isEmpty())
		{
			System.out.println("Missing right delimiter");
		}
	}

}
