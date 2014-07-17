import java.util.*;
import javax.swing.*;

public class CopyOfOriginalSort {
	private static int[] numbers;
	static long startTime;
	
	/*
	Useless, ignore this. Originally everything was a bit sloppier,
	but I wanted to keep this for posterity's sake.
	*/


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
		 		
		//quicksort(0, numbers.length - 1, numbers.length / 2);
		
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
	
	public static void swap(int _first, int _second)
	{					
		int temp = numbers[_second];
		numbers[_second] = numbers[_first];
		numbers[_first] = temp;
	}
	
	public static void quicksort(int first, int last, int pivot)
	{
		if (first == last || last < first)
		{
			return;
		}
		
		int pivotnumber = numbers[pivot];				
		
		swap(pivot, first);
				
		List<Integer> swapspots = new ArrayList<Integer>();			
		
		int lastleast = first;
		
		System.out.println("Pivot was " + pivotnumber);						
		
		for (int i = first + 1; i <= last; i++)
		{			
			if (numbers[i] >= pivotnumber)
			{
				swapspots.add(i);				
			}
			
			if(numbers[i] < pivotnumber)
			{
				if (swapspots.size() == 0)
				{
					lastleast = i;
				}
				else
				{
					swap(i, swapspots.get(0));
					swapspots.add(i);
					lastleast = swapspots.get(0);
					swapspots.remove(0);
				}					
			}
		}		
		
		swap(lastleast, first);
		
		printNumbers(first, last);			
		
		quicksort(first, lastleast, (lastleast + first) / 2);
		
		quicksort(lastleast + 1, last, (lastleast + 1 + last) / 2);
		
		swapspots = null;			
	}		 
}
