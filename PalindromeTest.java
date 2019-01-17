package hw1;

import java.util.Scanner;

public class PalindromeTest {
	
	public static boolean isPalindrome( String s ) {
		boolean isPal = false;
		
		String lowerS = s.toLowerCase();
		   
		for (int i=0; i<lowerS.length(); i++) {
			char c = lowerS.charAt(i);
			
			// Testing whether c is a non-letter non-digit character
			// If it is, then we replace it with "".
			if ((c < 'a' || c > 'z') && (c < '0' || c > '9'))
				// lowerS.substring(i, i+1) is a substring of lowerS
				// which only contains the character c.
				// We use it to meet the input requirement of .replace().
				lowerS = lowerS.replace(lowerS.substring(i, i+1), "");
		}
		   
		int i;
		// Checking if each letter in lowerS is the same as the letter in its "mirror image" position
		// Note that a letter at index i has a "mirror position" (lowerS.length()-1-i).
		for (i=0; i<(lowerS.length()-1-i); i++) {
			if (lowerS.charAt(i) != lowerS.charAt(lowerS.length()-1-i))
				break;
		}
		// If lowerS is palindrome, the previous for loop will keep looping until i fails the continuous test,
		// which is the same to say that i == lowerS.length()/2.
		if (i == lowerS.length()/2)
			isPal = true;

		return( isPal );
		}
	
	public static void main(String[] args) {
		System.out.println("\nWelcome to the Palindrome Test Program!");
		System.out.println("\nType in a sentence to be tested or Control-d to end:");
		
		Scanner userInput = new Scanner(System.in);
		
		while (userInput.hasNextLine()) {
			String line = userInput.nextLine();
			if (line.equals("quit"))
		        break;
			if (PalindromeTest.isPalindrome(line))
				System.out.println("Palindrome!");
			else
				System.out.println("Not a palindrome!");
		}
		System.out.println("bye!");
		userInput.close();
	}
}
