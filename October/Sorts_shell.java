    /* M.L. Billington, 10/02/2006.
    Uses the helper classes Selection and Insertion. 
	 Students are to write the Selection and Insertion classes.
    */
   import java.util.*;
   import java.io.*;
    public class Sorts_shell
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
        // Insertion.sort(array);
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
       //  Insertion.sort(arrayStr);
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
      }
       private static int findMax(double[] array, int n)
      {
      }
       private static void swap(double[] array, int a, int b)
      {
      }
   	/***************************************************
   	  for Strings
   	  ***********************************************/
       public static void sort(String[] array)
      {
      }
       public static int findMax(String[] array, int upper)
      {
      }
       public static void swap(String[] array, int a, int b)
      {
      }
   	/***************************************************
   	 for Comparables,
   	      Swap() is for Objects.
   	      make sure that print() is for Objects, too.
   	  ***********************************************/
       public static void sort(Comparable[] array)
      {
      }
       public static int findMax(Comparable[] array, int upper)
      {
      }
       public static void swap(Object[] array, int a, int b)
      {
      }
   }   

//**********************************************************
  //Name:              Date:
  //The Insertion class 
  //write it to sort doubles and Comparables.
    class Insertion
   {
   
   }
