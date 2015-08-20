   import java.util.*;

   public class Fib_7_Garg
   {
      public static final int DEFAULT = 40;
      
      public static void main(String[] args)
      {
         int n = DEFAULT;
         System.out.println("Recursive");
         calculate(new Fib1(), n);
         System.out.println("Iterative, stored in an array");
         calculate(new Fib2(), n);
         System.out.println("Recursive, stored in an arrayList");
         calculate(new Fib3(), n);
         System.out.println("Recursive, stored in a hashMap");
         calculate(new Fib4(), n);		
      }
      
      public static void calculate(Fibber fibber, int n)
      {
         long start = System.nanoTime();
         int f = fibber.fib(n);
         long finish = System.nanoTime();
         long time = finish - start;
      
         System.out.print("fib(" + n + ") = " + f);
         System.out.println(" (" + time + " nanoseconds)");		
         System.out.println();		
      }
    
      private static class Fib1 implements Fibber
      {      
         public int fib(int n)
         {
            if(n == 1 || n == 2)
               return 1;
            else
               return fib(n - 1) + fib(n - 2);
         }
      }
      private static class Fib2 implements Fibber
      {
         public int fib(int n)
         {
            int[] array = new int[n+1];
            array[1] = 1;
            array[2] = 1;
            for(int x = 3; x <= 40; x++)
            {
               array[x] = array[x-1] + array[x-2];
            }
            return array[40];
         }
      }
      private static class Fib3 implements Fibber
      {
         ArrayList<Integer> arraylist;
         public Fib3()
         {
            arraylist = new ArrayList<Integer>();
            arraylist.add(1);
            arraylist.add(1);       
         }	
         public int fib(int n) 
         {
            return fib1(n - 1);
         }
       
         private int fib1(int n)
         {
            if(arraylist.size() > n)
               return arraylist.get(n);
            arraylist.add(fib1(n - 2) + fib1(n - 1));
            return arraylist.get(n);
         }
      }
      private static class Fib4 implements Fibber
      {
         HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>(); 
         public int fib(int n) 
         {
            hashmap.put(0, 1);
            hashmap.put(1, 1);
            return fib1(2, n);
         }
       
         private int fib1(int n, int max)
         {
            if(n == max)
               return hashmap.get(hashmap.size() - 1);
            hashmap.put(n, hashmap.get(n - 2) + hashmap.get(n - 1));
            n++;
            return fib1(n, max);
         } 
      }
      
      private interface Fibber
      {
         public abstract int fib(int n);
      }
   }
   	/*
    Recursive
    fib(42) = 267914296 (3276558048 nanoseconds)
    
    Iterative, stored in an array
    fib(42) = 267914296 (4988 nanoseconds)
    
    Recursive, stored in an arrayList
    fib(42) = 267914296 (64025 nanoseconds)
    
    Recursive, stored in a hashMap
    fib(42) = 267914296 (177793 nanoseconds)
    
   	*/
