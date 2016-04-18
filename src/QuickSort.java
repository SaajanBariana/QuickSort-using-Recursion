
public class QuickSort 
{
	public final int GROUP = 100;
	public int comparisions = 0;
	
	public void quickSort1(int[] numbers, int index1, int index2)
	{
		if (index1 < index2)
		{
			int[] q = Partition(numbers, index1, index2);
			quickSort1(numbers, index1, q[0]);			
			quickSort1(numbers, q[1], index2);	
		}
		
	}
	
	public void quickSort2(int[] numbers, int index1, int index2)
	{
		if (index1 < index2)
		{
			/*if (index2 - index1 < GROUP)
			{
				InsertionSort(numbers);
			}
			else*/
			{
				//int q = getMedian(numbers, index1, index2);
				int[] part = RandomArray(numbers, index1, index2);
				/*int i = 0;
				while(numbers[i] != q)
				{
					i++;
				}
				Swap(numbers, q, numbers.length - 1);
				int[] part = Partition(numbers, index1, index2);
				*/
				quickSort2(numbers, index1, part[0]);
				quickSort2(numbers, part[1], index2);
			}
		}	
	}
	
	public int[] RandomArray(int[] array, int i, int j)
	{
		int last = (int)(Math.random() * (j - i)) + i;
		Swap(array, last, j);		
		return Partition(array, i, last);
		
	}
	
	public int getMedian(int[] a, int first, int last)
	{
		if (first < last)
		{
			int currentindex = 0;
			int[] medians;
			if (a.length % GROUP == 0)
			{
				medians = new int[a.length/GROUP];
			}
			else
			{
				medians = new int[(a.length/GROUP) + 1];
			}
			for (int j = 0; j < a.length/GROUP; j++)
			{
				int i = 0;
				int [] temp = new int[GROUP];
				while(i < GROUP)
				{
					temp[i] = a[currentindex];
					currentindex++;
					i++;
				}
				InsertionSort(temp);
				medians[j] = temp[GROUP / 2];
			}
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
			return getMedian(medians, 0, medians.length - 1);
		}
		else
		{
			return a[first];
		}
	}
	
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
			comparisions++;
		}
		
		int h = i;
		for (int l = k + 1; l <= i2; l++)
		{
			h++;
			Swap(numbers, h, l);
		}
		return new int[]{i, h + 1};
	}
	 
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
	public void Swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	

}
