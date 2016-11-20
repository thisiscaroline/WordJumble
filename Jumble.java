/* 
* How to turn:
* "I couldn't believe that I could understand what I was reading!"
* into:
* "I cnduol't bvleiee taht I culod uesdtannrd waht I was rdnaieg!"
*
* 1. Take in a file + tokenize it
* 2. Jumble the middle characters
* 3. Output result
*/

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class Jumble {
	
	public static void main (String[] args) throws FileNotFoundException {

		String token = "";
		Scanner s = new Scanner(new File("unjumble.txt"));
		
		System.out.println();
		
		for (int i = 0; s.hasNext(); i++){ 			// Loops through input file for tokens
			
			token = s.next();
			
			if (token.length() >= 4){
				String newToken = jumbler(token); 	// Jumble up the token
				System.out.print(newToken+" ");
			} else {
				System.out.print(token+" ");		// Print the single-char token
			}
			
		}
		
		System.out.println();
	
	}
	
	public static String jumbler(String token){
		
		int max, r;
		String jumble = token.charAt(0)+"";		// Grabs the head of the token
			
		int[] arr = new int[token.length()-2];		// -2 to cut off head, tail of token
			
		for (max = 0; max < arr.length; max++){
			arr[max] = max;				// Fills array from 0 to n-1
		}

		max--;						// Max must be == arr[last], not arr.length
		
		for (; max >= 0; max--){
			r = (int)(Math.random()*max);		// Fisher-Yates shuffle implementation
			int temp = arr[max];			// With some value swapping
			arr[max] = arr[r]+1;
			arr[r] = temp;
		}
		
		arr[0]++; 					// arr[r]+1 neglects to increment arr[0] iteratively, so this is needed!
			
		for (int i = 0; i < arr.length; i++){
			jumble += token.charAt(arr[i]);		// Composing the new token
		}
		
		jumble += token.charAt(token.length()-1)+"";	// Add the original tail back on
		
		return jumble;
		
	}
	
}
