package sjsu.Bariana.cs146.project1.part2;
import java.util.*;

public class QuickSort 
{
	
	public long comparisons = 0;
	public int[] arrays;
	
	/*
	 * Quicksort using normal quicksort algorithm
	 */
	public int[] quickSort1(int[] numbers, int index1, int index2)
	{
		arrays = numbers;
		if (index1 < index2)
		{
			int[] q = Partition(numbers, index1, index2);
			quickSort1(numbers, index1, q[0]);			
			quickSort1(numbers, q[1], index2);
		}
		return numbers;
	}
	
	/*
	 * Quicksort using random-partition
	 */
	public int[] quickSort2(int[] numbers, int index1, int index2)
	{
		arrays = numbers;
		if (index1 < index2)
		{
			int[] part = RandomArray(numbers, index1, index2);
			quickSort2(numbers, index1, part[0]);
			quickSort2(numbers, part[1], index2);
		}	
		return numbers;
	}
	
	/*
	 * get a random number from the array partition using that index
	 */
	public int[] RandomArray(int[] array, int i, int j)
	{
		Random ran = new Random();
		int last = (int) Math.random() * (j-i) + i;
		Swap(array, last, j);		
		return Partition(array, i, j);
		
	}
	
	/*
	 * get the nth index of the array
	 */
	public int select(int[] array,int first,int last,int number)
	{
		if (first == last)
		{
			return array[first];
		}
		int[] q = RandomArray(array, first, last);
		int k = q[0] - first + 2;
		if (number == k)
		{
			return array[q[0] + 1];
		}
		else if(number < k)
		{
			return select(array, first, q[0], number);
		}
		else
		{
			return select(array, q[1], last, number - k);
		}
	}
	
	/*
	 * Attempted to use median of medians
	 *
	public int getMedian(int[] a, int first, int last)
	{
		if (first < last)
		{
			int currentindex = 0;
			int[] medians = new int[a.length /5];
			
			
			/*
			if (a.length % groups == 0)
			{
				medians = new int[a.length/groups];
			}
			
			else
			{
				medians = new int[(a.length/groups) + 1];
			}
			*
			for (int j = 0; j < a.length/5; j++)
			{	
				int i = 0;
				int [] temp = new int[5];
				while(i < 5)
				{
					temp[i] = a[currentindex];
					currentindex++;
					i++;
				}
				InsertionSort(temp);
				medians[j] = temp[5 / 2];
			}
			/*
			if (currentindex < last)
			{
				int t = last - currentindex;
				int[] temp = new int[t];
				while(t > 0)
				{
					temp[t - 1] = a[currentindex + (t - 1)];
					t--;
				}
				InsertionSort(temp);
				if (medians.length > 1)
				{
					medians[medians.length - 1] = temp[temp.length/2];
				}
				else
				{ 
					medians[0] = temp[temp.length/2];
				}
			}
			*
			return getMedian(medians, 0, medians.length - 1);
		}
		else
		{
			InsertionSort(a);
			return a[a.length/2];
		}
	}
	*/
	
			
	/*
	 * Split the array into two based off of the partition
	 */
	public int[] Partition(int[] numbers, int i1, int i2)
	{
		int i  = i1 - 1;
		int k = i2-1;
		for (int j = i1; j <= k; j++)
		{
			if (numbers[j] < numbers[i2])
			{
				i++;
				Swap(numbers, i, j);

			}
			else if (numbers[j] == numbers[i2])
			{		
				Swap(numbers, j, k);
				k--;
				j--;		
			}
			comparisons++;
		}
		
		int h = i;
		for (int l = k + 1; l <= i2; l++)
		{
			h++;
			Swap(numbers, h, l);
		}
		return new int[]{i, h + 1};
	}
	
	/*
	 * Sort a small array of numbers
	 */
	public void InsertionSort(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int j = i;
			while (j > 0 && nums[j-1] > nums[j])
			{
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
				j--;
			}
		}
	}
	
	/*
	 * Swap two indexes
	 */
	public void Swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/*
	 * resets the array back to 0
	 */
	public void reset()
	{
		for (int i = 0; i < arrays.length; i++)
		{
			arrays[i] = 0;
		}
	}
	
	/*
	 * fills the array with random numbers
	 */
	public int[] populate(int number)
	{
		arrays = new int[number];
		for (int i = 0; i < arrays.length; i++)
		{
			arrays[i] = (int)(Math.random() * arrays.length * 2);
		}
		return arrays;
	}
	
	/*
	 * get the number of comparisons
	 */
	public long getPartCount()
	{
		return comparisons;
	}
}
