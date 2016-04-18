package sjsu.Bariana.cs146.project1.part2;

/*  
 * Class: CS146-01    
 * Semester: Spring 2016    
 * Project: #1 - Quicksort    
 * Sample JUnit tests for quickSort1, quickSort2 i.e., with pivot as last element and median, their running time,    and count of comparisons.  
 * */
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before; 
import org.junit.Test;
/**  
 * The main JUnit Test class to test each method in Quicksort 
 */
public class QuickSortTest2 
{
   private QuickSort quickSorter;
   @Before   
   public void setUp() throws Exception    
   {       
	   quickSorter = new QuickSort();       
	       
   } // setUp()

 
     /* 
      * Method to test the Sorting of an already sorted list:    
      */   
   @Test  
   public void testSortedRandomized() 
   {       
	   int[] a1 = quickSorter.populate(40);    
	   int[] a2 = quickSorter.populate(40); 
	   int[] a3 = a1;
	   int[] a4 = a2;
	   Arrays.sort(a3);
	   Arrays.sort(a4);
        // run quickSort1()    
        a1 = quickSorter.quickSort1(a1, 0, a1.length - 1);   
        assertArrayEquals(a1,a3);              
        // run quickSort2()     
        a2 = quickSorter.quickSort2(a2, 0, a2.length - 1);   
        assertArrayEquals(a2,a4);        
   }  
   
   /*     
    * Method to test the select method   
    */    
   @Test  
   public void testSelectForQuarterValue() 
   {      
	   int[] array1 = new int[100]; 
	   for (int i = 0; i < 100; i++) 
	   {           
		   array1[i] = i; 
	   }    
	   // median is 24  
	   int median=quickSorter.select(array1,0, array1.length-1, array1.length/4);    
	   System.out.println("median:"+ median);
	   assertEquals(24, median);
    } 
   
   /* 
    * Method to test the Sorting of a reverse sorted list:   
    *   */  
   @Test   
   public void testReverseSortedFor50() 
   {      
	   int[] array1 = new int[50];   
	   int[] array2 = new int[50];           
	   int[] array3 = new int[50];               
	   for (int i = 0; i < 50; i++) 
	   {             
		   array1[i] = (50-i);     
		   array2[i] = (50-i);           
		   array3[i] = (50-i);      
	   }        
	   //sort array3  
	   Arrays.sort(array3);      
	   // run quickSort1()   
	   array1 = quickSorter.quickSort1(array1, 0, array1.length - 1);     
	   assertArrayEquals(array1,array3);     
	   // run quickSort2()      
	   array1 = quickSorter.quickSort2(array2, 0, array2.length - 1);   
	   assertArrayEquals(array1,array3);    
	   }       
  
   /*    
    *  * Method to test the randomness to the tests:   
    */  
   @Test 
   public void testRandomFor100() 
   {     
	   int[] array1 = new int[100];  
	   for (int i = 0; i < 100; i++)
	   {           
		   array1[i] = (int) Math.random()*100;
	   }   
	   //copy the arrays
	   int[] array2 = array1;
	   int[] array3 = array1;
	   Arrays.sort(array3);      
	   // run quickSort1()       
	   array1 = quickSorter.quickSort1(array1, 0, array1.length - 1);   
	   assertArrayEquals(array1,array3);             
	   // run quickSort2()     
	   array2 = quickSorter.quickSort2(array2, 0, array2.length - 1);    
	   assertArrayEquals(array2,array3);       
   }
	

   /* Method to test the timing of quickSort1 
    *  
    
    */    
   @Test  
   public void testquickSort1Timing()  
   {       
	   // create an array and a sorted backup  
	   int[] array1 = quickSorter.populate(10000);     
	   int[] array2 = quickSorter.populate(100000);
	   int[] array3 = quickSorter.populate(1000000);    
	   int[] array4 = quickSorter.populate(10000000);     
	   int[] array5 = quickSorter.populate(100000000);
 
	   long start = System.currentTimeMillis();   
	   array1 = quickSorter.quickSort1(array1, 0, array1.length - 1); 
	   long end = System.currentTimeMillis();    
	   long elapsed = end - start;     
	   System.out.println("quickSort1 time to sort 10,000 elements in ms:"+ elapsed);
	   System.out.println("Number of comparisons for 10,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
   
      start = System.currentTimeMillis(); 
      array2 = quickSorter.quickSort1(array2, 0, array2.length - 1);   
      end = System.currentTimeMillis();  
      elapsed = end - start;     
      System.out.println("quickSort1 time to sort 100,000 elements in ms:"+ elapsed); 
      System.out.println("Number of comparisons for 100,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
	   
      start = System.currentTimeMillis();    
      array3 = quickSorter.quickSort1(array3, 0, array3.length - 1);     
      end = System.currentTimeMillis();      
      elapsed = end - start;      
      System.out.println("quickSort1 time to sort 1,000,000 elements in ms:"+ elapsed);
      System.out.println("Number of comparisons for 1,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
      
      start = System.currentTimeMillis(); 
      array4 = quickSorter.quickSort1(array4, 0, array4.length - 1);   
      end = System.currentTimeMillis();  
      elapsed = end - start;     
      System.out.println("quickSort1 time to sort 10,000,000 elements in ms:"+ elapsed); 
      System.out.println("Number of comparisons for 10,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
      
      start = System.currentTimeMillis();    
      array5 = quickSorter.quickSort1(array5, 0, array5.length - 1);     
      end = System.currentTimeMillis();      
      elapsed = end - start;      
      System.out.println("quickSort1 time to sort 100,000,000 elements in ms:"+ elapsed);
      System.out.println("Number of comparisons for 100,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
   }
   /* Method to test the timing of quickSort2     
    */   
   @Test
   public void testquickSort2Timing()   
   {     
	// create an array and a sorted backup  
	   int[] array1 = quickSorter.populate(10000);     
	   int[] array2 = quickSorter.populate(100000);
	   int[] array3 = quickSorter.populate(1000000);    
	   int[] array4 = quickSorter.populate(10000000);     
	   int[] array5 = quickSorter.populate(100000000);
 
	   long start = System.currentTimeMillis();   
	   array1 = quickSorter.quickSort2(array1, 0, array1.length - 1); 
	   long end = System.currentTimeMillis();    
	   long elapsed = end - start;     
	   System.out.println("quickSort2 time to sort 10,000 elements in ms:"+ elapsed);
	   System.out.println("Number of comparisons for 10,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
   
      start = System.currentTimeMillis(); 
      array2 = quickSorter.quickSort2(array2, 0, array2.length - 1);   
      end = System.currentTimeMillis();  
      elapsed = end - start;     
      System.out.println("quickSort2 time to sort 100,000 elements in ms:"+ elapsed); 
      System.out.println("Number of comparisons for 100,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
	   
      start = System.currentTimeMillis();    
      array3 = quickSorter.quickSort2(array3, 0, array3.length - 1);     
      end = System.currentTimeMillis();      
      elapsed = end - start;      
      System.out.println("quickSort2 time to sort 1,000,000 elements in ms:"+ elapsed);
      System.out.println("Number of comparisons for 1,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
      
      start = System.currentTimeMillis(); 
      array4 = quickSorter.quickSort2(array4, 0, array4.length - 1);   
      end = System.currentTimeMillis();  
      elapsed = end - start;     
      System.out.println("quickSort2 time to sort 10,000,000 elements in ms:"+ elapsed); 
      System.out.println("Number of comparisons for 10,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;
      
      start = System.currentTimeMillis();    
      array5 = quickSorter.quickSort2(array5, 0, array5.length - 1);     
      end = System.currentTimeMillis();      
      elapsed = end - start;      
      System.out.println("quickSort2 time to sort 100,000,000 elements in ms:"+ elapsed);
      System.out.println("Number of comparisons for 100,000,000: " + quickSorter.comparisons);
	   quickSorter.comparisons = 0;  
   }
   /*     * Method to test the number of comparisons in sorting an already sorted array of 10 numbers.     
    * * Number of comparisons should be 45     
    * */   
   @Test 
   public void testgetPartCountWith20()  
   {    
	   int[] array1 = new int[20];  
	   //  int[] result1 = new int[10];   
	   for (int i = 0; i < 20; i++) 
	   {           
		   array1[i] = i*20; 
	   }            
	   array1 = quickSorter.quickSort1(array1, 0, array1.length - 1);  
	   System.out.println("comparisons in already sorted:"+ quickSorter.getPartCount()); 
	   long compare=quickSorter.getPartCount();       
	   assertEquals(compare, 190);     
   }
   /*    
    *  * Method to test the number of comparisons in reverse sorted array of 10 numbers.     
    *  * Number of comparisons should be 45.     
    *  */   
   @Test    
   public void testgetPartCountWith20A()   
   {      
	   int[] array1 = new int[20];
	   for (int i = 0; i < 20; i++)
	   {            
		   array1[i] = (100-i);   
		   }            
	   array1 = quickSorter.quickSort1(array1, 0, array1.length - 1);  
	   System.out.println("comparisons in reverse sorted:"+ quickSorter.getPartCount());   
	   long compare=quickSorter.getPartCount();    
	   assertEquals(compare, 190);    
	    // getPartCount()
   }
}
   // class QuicksortTest1       
