    /* M.L. Billington, 10/13/2006.
    Sorts Doubles.
	 Calls methods in the classes Merge and QuickSort. 
	 Students are to write the Merge and QuickSort classes.
    */
   import java.util.*;
   import java.io.*;
    public class Merge_Quick_Teacher
   {
       public static void main(String[] args) throws Exception
      {
         int n = (int)(Math.random()*100 + 50);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();	
         //print(array);
         //Merge.sort(array);
        QuickSort.sort(array);
         print(array);
         if( check(array) )
            System.out.println("In order!");
         else
            System.out.println("oops!");
      }
       public static void print(double[] a)   
      {
         for(double number : a)    //doing something to each element
            System.out.println(number);
         System.out.println();
      }
       public static boolean check(double[] a)
      {
         for(int i = 0; i < a.length - 1; i++) //we must access the index numbers
            if(a[i] > a[i+1])
               return false;
         return true;
      }
   }
	/////////////////////////////////////////////
	// 15 Oct 07
// Merge Code Handout
// from Lambert & Osborne, p. 482 - 485

    class Merge
   {
      private static final int CUTOFF = 10; // for small lists, recursion isn't worth it
   // array				array that is being sorted
   // copyBuffer		temp space needed during the merge
       public static void sort(double[] array)
      { 
         double[] copyBuffer = new double[array.length];
         mergeSortHelper(array, copyBuffer, 0, array.length - 1);
      }
   
       private static void mergeSortHelper(double[] array, double[] copyBuffer,
                                                             int low, int high)
      // array				array that is being sorted
      // copyBuffer		temp space needed during the merge process
      // low, high		bounds of subarray
      // middle			midpoint of subarray
      {  
         //  if ( high - low  < CUTOFF )   //switch to selection sort when
      //              Selection.sort(array);        //the list gets small enough 
      //           else
         if (low < high)
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
         // Initialize i1 and i2 to the first items in each subarray  
         int i1 = low, i2 = middle + 1;
         // Interleave items from the subarrays into the copyBuffer in such 
         // a way that order is maintained.
         for (int i = low; i <= high; i++)
         {
            if (i1 > middle)
               copyBuffer[i] = array[i2++];		// 1st subarray is exhausted
            else if (i2 > high)
               copyBuffer[i] = array[i1++];	   // 2nd subarray is exhausted
            else if (array[i1] < array[i2])
               copyBuffer[i] = array[i1++];	   // Item in 1st subarray is less
            else
               copyBuffer[i] = array[i2++];	   // Item in 2nd subarray is less
         }
         
         for (int i = low; i <= high; i++)		// Copy sorted items back into
            array[i] = copyBuffer[i];				// proper position in array 		
      }		
   }
	
	////////////////////////////////////////////////////
	//Torbert, 10.31.2003
    class QuickSort
   {
       public static void sort(double[] array)
      {
         helper(array, 0, array.length - 1);
      }
       private static void helper(double[] array, int start, int end)
      {
         swap(array, start, (int)(Math.random() * (end - start + 1) + start));
         double pivot = array[start];
         int pos = start + 1;
         for(int k = start + 1; k <= end; k++)
            if(array[k] < pivot)
            {
               swap(array, k, pos);
               pos = pos + 1;
            }
         swap(array, start, pos - 1);
         if(start < pos - 2)
            helper(array, start, pos - 2);
         if(pos < end)
            helper(array, pos, end);
      }
       private static void swap(double[] array, int a, int b)
      {
         if(a == b)
            return;
         double temp = array[a];
         array[a] = array[b];
         array[b] = temp;
      }
   }


