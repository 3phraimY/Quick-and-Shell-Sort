import java.util.Random;

public class Main {
	public static void main(String[] args) 
	{
		int[] arr = RandomArrayGenerator(100);
		shellSort(arr);
		displayArray(arr);		 
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
	public static void ShellSortPartition(int[] arr, int startIndex, int interval)
	{
		for(int i = startIndex; i<arr.length; i++)
		{
			int pos = i;
			while(pos - interval >= startIndex && arr[pos - interval] > arr[pos])
			{
				int temp = arr[pos];
				arr[pos] = arr[pos - interval];
				arr[pos - interval] = temp;
				pos = pos - interval;
			}
		}
	}
	public static int[] shellSort(int[] array)
	{
		int interval = array.length;
		while((interval % 2)-1 != 0 )
		{
			interval--;
		}
		while(interval > 0)
		{
			for(int i = 0; i<interval; i++)
			{
				ShellSortPartition(array, i, interval);
			}	
			interval = interval -2;
		}		
		return array;
	}	
}
