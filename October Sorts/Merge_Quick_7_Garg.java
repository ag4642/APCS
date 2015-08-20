   import java.util.*;
   import java.io.*;
   public class Merge_Quick_7_Garg
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
         for(double theNumber : array )   
            System.out.println(theNumber);
         System.out.println();
      }
      public static boolean check(double[] a)
      {
         for(int x = 0; x < a.length-1; x++)
         {
            if(a[x+1] < a[x])
            {
               return false;
            }
         }
         return true;
      }
   }
   class Merge
   {
      private static final int CUTOFF = 10; 
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
         if (low < high)
         {
            int middle = (low + high) / 2;
            mergeSortHelper(array, copyBuffer, low, middle);
            mergeSortHelper(array, copyBuffer, middle + 1, high);
            merge(array, copyBuffer, low, middle, high);
         }
      }
   	
      public static void merge(double[] array, double[] copyBuffer,int low, int middle, int high)
      {
      // array				array that is being sorted
      // copyBuffer		temp space needed during the merge process
      // low				beginning of first sorted subarray
      // middle			end of first sorted subarray
      // middle + 1		beginning of second sorted subarray
      // high				end of second sorted subarray
      
         int x = low;
         int y = middle + 1;
         for(int i = low; i <= high; i++)
         {
            if(x > middle)
               copyBuffer[i] = array[y++];
            else if(y > high)
               copyBuffer[i] = array[x++];
            else if(array[x] < array[y])
               copyBuffer[i] = array[x++];
            else
               copyBuffer[i] = array[y++];
         }
         for(int i = low; i <= high; i++)
            array[i] = copyBuffer[i];
      }	
   }

   class QuickSort
   {
      public static void sort(double[] array)
      {
         helper(array, 0, array.length - 1);
      }
      private static void helper(double[] array, int start, int end)
      {
         int splitPt;
         if (start < end)   			
         {    
            splitPt = split(array, start, end);
            split(array, start, splitPt - 1);	
            split(array, splitPt + 1, end);	
         }
      }
      private static void swap (double[] array, int a, int b)
      {
         if(a == b)
            return;
         double temp = array[a];
         array[a] = array[b];
         array[b] = temp;
      }
      private static int split(double info[], int first, int last)
      {
         int splitPt = first;       
         double pivot = info[first];
      
         while (first <= last)
         { 
            if (info[first] <= pivot)       
               first++;                      
            else if (info [last] >= pivot)  
               last--;                         
            else                             
            {  
               swap (info, first, last);     
               first++;                  
               last--;
            }
         }
         swap (info, last, splitPt); 	
         splitPt = last;			
         return splitPt;
      }
   }