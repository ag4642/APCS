   import java.util.*;
   import java.io.*;
   public class Sorts_7_Garg
   {
      public static void main(String[] args) throws Exception
      {
        //Part 1, for doubles
         int n = (int)(Math.random()*100);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();	
         print(array);
         System.out.println("*************  *************");
         Selection.sort(array);
         //Insertion.sort(array);
         print(array);
         	//Part 2, for Strings
         int size = 100;
         Scanner sc = new Scanner(new File("declaration.txt"));
         String[] arrayStr = new String[size];
         for(int k = 0; k < arrayStr.length; k++)
            arrayStr[k] = sc.next();	
         print(arrayStr);
         System.out.println("*************  *************");
         Selection.sort(arrayStr);
         //Insertion.sort(arrayStr);
         print(arrayStr);
      }
      public static void print(double[] a)
      {
         // for(int k = 0; k < a.length; k++)
            // System.out.println(a[k]);
         for(double d : a)
            System.out.println(d);
         System.out.println();
      }
      public static void print(Object[] papaya)
      {
         for(Object abc : papaya)     //for-each
            System.out.println(abc);
      }
   }
   //*******************************************************************
  //Name:              Date:
  //The Selection class will have methods sort(), findMax() and swap().
  //Three versions of each method will have to be written, to work 
  //for doubles, Strings, and Comparables.
  
   class Selection
   {
      public static void sort(double[] array)
      { 
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      private static int findMax(double[] array, int n)
      {
         int maxIndex = 0;
         for(int x = n; x >= 0; x--)
         {
            if(array[x] > array[maxIndex])
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      private static void swap(double[] array, int a, int b)
      {
         double temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   	/***************************************************
   	  for Strings
   	  ***********************************************/
      public static void sort(String[] array)
      {
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      public static int findMax(String[] array, int upper)
      {
         int maxIndex = 0;
         for(int x = upper; x >= 0; x--)
         {
            if(array[x].compareTo(array[maxIndex]) == 1)
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      public static void swap(String[] array, int a, int b)
      {
         String temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   	/***************************************************
   	 for Comparables,
   	      Swap() is for Objects.
   	      make sure that print() is for Objects, too.
   	  ***********************************************/
      public static void sort(Comparable[] array)
      {
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      public static int findMax(Comparable[] array, int upper)
      {
         int maxIndex = 0;
         for(int x = upper; x >= 0; x--)
         {
            if(array[x].compareTo(array[maxIndex]) == 1)
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      public static void swap(Object[] array, int a, int b)
      {
         Object temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   }   

//**********************************************************
  //Name:              Date:
  //The Insertion class 
  //write it to sort doubles and Comparables.
   class Insertion
   {
      public static void sort(double[] array)
      {
         for(int x = 1; x < array.length; x++)
         {
            double next = array[x];
            int y = x;
         
            while (y > 0 && next < array[y - 1])
            {
               array[y] = array[y - 1];
               y--;
            }
            array[y] = next;
         }
      }
      public static void sort(String[] array)
      {
         for(int x = 1; x < array.length; x++)
         {
            String next = array[x];
            int y = x;
         
            while (y > 0 && next.compareTo(array[y - 1]) == -1)
            {
               array[y] = array[y - 1];
               y--;
            }
            array[y] = next;
         }
      }
   
      public static void sort(Comparable[] array)
      {
         for(int x = 1; x < array.length; x++)
         {
            Comparable next = array[x];
            int y = x;
         
            while (y > 0 && array[x].compareTo(array[y - 1]) == -1)
            {
               array[y] = array[y - 1];
               y--;
            }
            array[y] = next;
         }
      }
   }