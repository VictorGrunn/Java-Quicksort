import java.util.*;
import javax.swing.*;

/*
 * 
 * A basic implementation of quicksort with some Swing reporting. Simple recursion on a classic algorithm.
 * 
 * Generates 100 random numbers in an array, unsorted, and then sorts them. Reports the original array,
 * the resulting array, and the time in ms taken to complete the action.
 * 
 * Simple. Concise. Effective. That's Quicksort!
 */

public class OriginalSort {
	private static int[] numbers;
	static long startTime;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		generateNumbers();		
		
		ArrayProcessor test = new ArrayProcessor();			
		
		printNumbers(0, numbers.length);		
		
		String message = "";
		
		for (int i = 0; i < numbers.length; i++)
		{
			message += numbers[i] + " ";
		}
		
		System.out.println("\r\nSorting...\r\n");
		
		numbers = test.Process(numbers);		 		
		
		printNumbers(0, numbers.length);
		
		String message2 = "";
		
		for (int i = 0; i < numbers.length; i++)
		{
			message2 += numbers[i] + " ";
		}
		
		String message3 = "\r\nThis operation took " + (System.currentTimeMillis() - startTime) + " milliseconds to complete.";
		
		JOptionPane.showMessageDialog(null, message + "\r\nConverted to\r\n" + message2 + message3);
	}
	
	private static void generateNumbers()
	{
		startTime = System.currentTimeMillis();
		
		int amount = 50;	
		
		numbers = new int[amount];
		
		for (int i = 0; i < amount; i++)
		{
			numbers[i] = (int)(Math.random() * 100);
		}
	}
	
	private static void printNumbers(int start, int finish)
	{
		 for (int l = start; l < finish; l++)
		    {
		    	System.out.print(numbers[l] + " ");
		    }
		 
		 System.out.println("");
	}	
}
