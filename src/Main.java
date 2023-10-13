import java.util.Random;

public class Main {
	public static void main(String[] args) 
	{
		int[] arr = RandomArrayGenerator(10000);
		int[] copy = arr.clone();
		long start, end;
		
		start = System.nanoTime();
		int[] gap = new int[arr.length/2];
		int counter = 0;
		for(int i = arr.length; i>0; i = i-2)
		{
			if(i % 2 == 0)
			{
				i--;
			}
			gap[counter] = i;
			counter++;
		}
		shellSort(arr,gap);
		end = System.nanoTime();
		System.out.println("Shell sort: " + (end-start));
		
		start = System.nanoTime();
		quickSort(copy, 0, copy.length-1);
		end = System.nanoTime();
		System.out.println("quick Sort: " + (end-start));	 
	}
	//1 - 100, random pick one item out one by one, and place in sequence
	//shuffle
	public static int[] RandomArrayGenerator(int size) 
	{
		int[] result = new int[size];
		Random r = new Random();
	
		//assign from 0 to size to each element of array in order
		for(int i =0; i< size; i++)
		{
			result[i] = i;
		}
		
		//shuffle the position of each element
		for(int i =0; i< size; i++)
		{
			int pos = r.nextInt(size);
			int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		return result;
	}
	
	public static void displayArray(int[] array)
	{
		for(int i = 0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	//1. partition shell sort
	//1 2 3 4 5 6 7 8 9
	//round 1
	//1     4     7
	//  2     5     8
	//    3      6    9
	//round 2
	//1   3   5   7   9
	//  2   4   6   8
	//round 3
	//1 2 3 4 5 6 7 8 9
	public static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) 
	{
		   for (int i = startIndex + gap; i < numbers.length; i += gap) 
		   {
		      int j = i;
		      while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) 
		      {
		         // Swap numbers[j] and numbers [j - gap]
		         int temp = numbers[j];
		         numbers[j] = numbers[j - gap];
		         numbers[j - gap] = temp;
		         j -= gap;
		      }
		   }
		}
	public static void shellSort(int[] numbers, int[] gapValues) 
	{
		   for (int g = 0; g < gapValues.length && gapValues[g] > 0; g++) 
		   {
		      for (int i = 0; i < gapValues[g]; i++) 
		      {
		         insertionSortInterleaved(numbers, i, gapValues[g]);
		      }
		   }
		}

	public static int Partition(int[] array, int low, int high) {
	    int pivot = array[low];
	    int left = low;
	    int right = high + 1;

	    while (true) {
	        do {
	            left++;
	        } while (left <= high && array[left] < pivot);

	        do {
	            right--;
	        } while (array[right] > pivot);

	        if (left >= right) {
	            break;
	        }

	        int temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	    }

	    array[low] = array[right];
	    array[right] = pivot;

	    return right;
	}

	public static void quickSort(int[] array, int low, int high) {
	    
		if (low < high) {
	        int mid = Partition(array, low, high);
	        quickSort(array, low, mid - 1);
	        quickSort(array, mid + 1, high);
	    }
		
		
		return;
	}

}
