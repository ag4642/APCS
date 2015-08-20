    /* 
    Calls methods in the classes Merge and QuickSort. 
	 Students are to write the Merge and QuickSort classes.
    */
   import java.util.*;
   import java.io.*;
    public class Merge_Quick_shell
   {
       public static void main(String[] args) throws Exception
      {
         int n = (int)(Math.random()*100);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();	
         print(array);
         Merge.sort(array);
         //QuickSort.sort(array);
         print(array);
         if(check(array))
            System.out.println("In order!");
         else
            System.out.println("oops!");
      }
       public static void print(double[] array)
      {
         for(double theNumber : array )     //doing something to each
            System.out.println(theNumber);
         System.out.println();
      }
       public static boolean check(double[] a)
      {
      }
   }
/////////////////////////////////////////////////
// from Lambert & Osborne, p. 482 - 485
    class Merge
   {
      private static final int CUTOFF = 10;  // for small lists, recursion isn't worth it
       public static void sort(double[] array)
      { 
         double[] copyBuffer = new double[array.length];
         mergeSortHelper(array, copyBuffer, 0, array.length - 1);
      }
   
       private static void mergeSortHelper(double[] array, double[] copyBuffer,
                                                             int low, int high)
      {  
         										  //switch to selection sort when
           								        //the list gets small enough 
         else if (low < high)
         {
            int middle = (low + high) / 2;
            mergeSortHelper(array, copyBuffer, low, middle);
            mergeSortHelper(array, copyBuffer, middle + 1, high);
            merge(array, copyBuffer, low, middle, high);
         }
      }
   	
       public static void merge(double[] array, double[] copyBuffer,
                                      int low, int middle, int high)
      // array				array that is being sorted
      // copyBuffer		temp space needed during the merge process
      // low				beginning of first sorted subarray
      // middle			end of first sorted subarray
      // middle + 1		beginning of second sorted subarray
      // high				end of second sorted subarray
      {
        		/* write the merge method  */
      }		
   }

////////////////////////////////////////////////////
    class QuickSort
   {
       public static void sort(double[] array)
      {
         helper(array, 0, array.length - 1);
      }
       private static void helper(double[] array, int start, int end)
      {
      }
       private static void swap(double[] array, int a, int b)
      {
      }
   }