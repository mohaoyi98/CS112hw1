package hw1;

import java.util.Scanner;
import java.util.Arrays;

public class WordPalindromeTest {
	
	public static boolean isWordPalindrome(String s) {
		boolean isWordPal = false;
		String wordString = "";
		
		String lowerS = s.toLowerCase();
		   
		for (int i=0; i<lowerS.length(); i++) {
			char c = lowerS.charAt(i);
			// Testing whether c is a non-letter non-digit non-space character
			// If it is, then we replace it with "".   
			if (! ( (c <'a' || c > 'z') && (c < '0' || c > '9') && (c != ' ') ))
				// lowerS.substring(i, i+1) is a substring of lowerS
				// which only contains the character c.
				// We use it to meet the input requirement of .replace().
				// the wrong version: lowerS = lowerS.replace(lowerS.substring(i, i+1), "");
				wordString += c;
		}
		
		String[] wordArray = wordString.split("\\s+");
		
		int i;
		// Checking if each word in wordArray is the same as the word in its "mirror image" position
		// Note that a word at index i has a "mirror position" (wordArray.length-1-i).
		for (i=0; i<(wordArray.length-1-i); i++) {
			if (! wordArray[i].equals(wordArray[wordArray.length-1-i]))
				break;
		}
		// If s is wordpalindrome, the previous for loop will keep looping until i fails the continuous test,
		// which is the same to say that i == wordArray.length/2.
		if (i == wordArray.length/2)
			isWordPal = true;

		System.out.println("\n" + Arrays.toString(wordArray) + "\n");
		
		return isWordPal;	   
	}

	public static void main(String[] args) {
		
		System.out.println("\nWelcome to the Word Palindrome Test Program!");
		System.out.println("\nType in a sentence to be tested or \"quit\" to end:");
		Scanner userInput = new Scanner(System.in);
		
		while (userInput.hasNextLine()) {
			String line = userInput.nextLine();
			
			if (line.equals("quit")) 
		        break;
			if (WordPalindromeTest.isWordPalindrome(line))
				System.out.println("Word Palindrome!");
			else
				System.out.println("Not a Word Palindrome!");
			
			System.out.println("\nType in a sentence to be tested or \"quit\" to end:");
		}
		System.out.println("bye!");
		userInput.close();
		
	}

}
