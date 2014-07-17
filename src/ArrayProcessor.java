import java.util.ArrayList;
import java.util.List;


public class ArrayProcessor {
	private int[] numbers;
	
	public ArrayProcessor()
	{
		
	}
	
	public int[] Process(int[] array)
	{
		numbers = array;
		
		quicksort(0, numbers.length - 1, numbers.length / 2);
		
		return numbers;
	}
	
	private void swap(int _first, int _second)
	{					
		int temp = numbers[_second];
		numbers[_second] = numbers[_first];
		numbers[_first] = temp;
	}
	
	private void quicksort(int first, int last, int pivot)
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
	
	private void printNumbers(int start, int finish)
	{
		 for (int l = start; l < finish; l++)
		    {
		    	System.out.print(numbers[l] + " ");
		    }
		 
		 System.out.println("");
	}

}
