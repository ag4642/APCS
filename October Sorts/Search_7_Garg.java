   import java.io.*;      //the File 
   import java.util.*;    //the Scanner 
   import javax.swing.*;  //the JOptionPane
   public class Search_7_Garg
   {
      public static int comparisons = 0;
      public static int indexnumber = 0;
   
      public static void main(String[] args) throws Exception
      {
         Scanner infile = new Scanner(new File("declaration.txt"));
         int numitems = 0;
         while(infile.hasNext())
         {
            numitems++;
         }
         String[] array = new String[numitems];
         for(int k = 0; k < numitems; k++)
         {
            array[k] = infile.next();
         }
         infile.close();
         System.out.println("Enter word:");
         Scanner sc = new Scanner(System.in);
         String a = sc.next();
         System.out.println(Search.linear(array, a) + ", " + Search.binary(array, a));   
      }
      class Search
      {
         public static int linear(Comparable[] array, Comparable target)
         {
            comparisons = -1;
            for(int x = 0; x < array.length; x++)
            {
               comparisons++;
               if(array[x].compareTo(target) ==0)
               {
                  return x;
               }
            }
            return -1;
         }
         public static int binary(Comparable[] array, Comparable target)
         {
            return helper(array, target, 0, array.length-1);
         }
         private static int helper(Comparable[] array, Comparable target, int first, int last)
         {
            if(array[(first + last) / 2].compareTo(target) == 0)
            {
               comparisons++;
               indexnumber = (first + last) / 2;
            }
            else if(array[(first + last) / 2].compareTo(target) == 1)
            {
               comparisons++;
               helper(array, target, first, (first + last) / 2);
            }
            else
            {
               comparisons++;
               helper(array, target, (first + last) / 2, last);
            }
            return indexnumber;
         }
      }
   }