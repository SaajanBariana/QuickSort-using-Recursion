public class QuickSortTest
{
	public static void main(String[] args) 
	{ 
		
		//int[] x = {2, 1, 3, 2, 2, 3, 4, 4, 5, 5, 3};
		//int[] y = {0, 5, 5, 5, 5, 5, 2, 4, 10, 4, 3};
		int[] x = new int[1000];
		int[] y = new int[1000];
		
		for(int i = 0; i < x.length; i++)
		{
			x[i] = i;
			y[i] = i;
		}
		
		QuickSort tester = new QuickSort();
		QuickSort tester2 = new QuickSort();
		long now = System.nanoTime();
		tester.quickSort1(y, 0, y.length - 1);
		long time = System.nanoTime() - now;
		System.out.println("Run time for quicksort1: " + time + " nanoseconds");
		System.out.println(tester.comparisions + " comparisions");
		
		now = System.nanoTime();
		tester2.quickSort2(x, 0, x.length - 1);
		time = System.nanoTime() - now;
		System.out.println("Run time for quicksort2: " + time + " nanoseconds");
		System.out.println(tester2.comparisions + " comparisions");
		/*
		System.out.println("Results for quicksort1");
		for (int i = 0; i < y.length; i++)
		{
			System.out.print(y[i] + " ");
		}
		
		System.out.println(" ");
		System.out.println("Results for quicksort2");
		for (int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + " ");
		}*/
	}
}
	
