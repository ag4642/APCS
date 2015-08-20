   import java.io.*;
   import java.util.*;
   public class IteratorLab_7_Garg
   {
      public static void main(String[] args)
      {
         System.out.println("Iterator Lab\n");
         int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
         for(int n : rawNumbers )
            System.out.print(n + " ");    
         ArrayList<Integer> numbers = createNumbers(rawNumbers);
         System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
         System.out.println("Count negative numbers: " + countNeg(numbers));
         System.out.println("Average: " + average(numbers));
         System.out.println("Replace negative numbers: " + replaceNeg(numbers));
         System.out.println("Delete zeros: " + deleteZero(numbers));
         String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
         ArrayList<String> movies = createMovies(rawMovies);
         System.out.println("Movies: " + movies);
         System.out.println("Movies: " +  removeDupes(movies));
      }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
      public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
         ArrayList<Integer> ints = new ArrayList<Integer>();
         for(Integer e : rawNumbers)
         {
            ints.add(e);
         }
         return ints;
      }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
      public static ArrayList<String> createMovies(String[] rawWords) 
      {
         ArrayList<String> words = new ArrayList<String>();
         for(String e : rawWords)
         {
            words.add(e);
         }
         return words;
      }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
      public static int countNeg(ArrayList<Integer> a)
      {
         int n = 0;
         for(Integer e : a)
         {
            if(e < 0)
            {
               n++;
            }
         } 
         return n;
      }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
      public static double average(ArrayList<Integer> a)
      {
         double sum = 0.0;
         double avg = 0.0;
         for(Integer e : a)
         {
            sum += e;
         }
         avg = sum/a.size();
         return avg;
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
      public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
      {
         ListIterator<Integer> b = a.listIterator();
         while(b.hasNext())
         {
            if(b.next() < 0)
            {
               b.set(0);
            }
         }
         return a;
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
      public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
      {
         ListIterator<Integer> b = a.listIterator();
         while(b.hasNext())
         {
            if(b.next() == 0)
            {
               b.remove();
            }
         }
         return a;
      }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
   	// strategy: build a new array using 2 for-each and a boolean
      public static ArrayList<String> removeDupes(ArrayList<String> a)
      {
         ArrayList<String> s = new ArrayList<String>();
         for(String e : a) 
         {
            boolean in = false;
            for(String t: s)
            {
               if(t.equals(e))
               {
                  in = true; 
                  break;
               }
            }
            if(!in)
               s.add(e);
         }  
         return s;
      }
   }