   import edu.fcps.Scanner;
   public class Fibonacci_7_Garg
   {
      public static void main(String[] args)
      {
         long start, end, fib;
         int[] fibNumber = {1, 5, 10, 20, 30, 40, 41, 42};
         System.out.println("\tFibonacci\tBy Iteration\tTime\tby Recursion\t Time");
         for(int n = fibNumber[0]; n <= fibNumber[fibNumber.length - 1]; n++)
         { 
            start = System.nanoTime();
            fib = fibIterate(n);
            end = System.nanoTime();
            System.out.print("\t\t" + n + "\t\t" + fib + "\t" + (end-start)/1000.);
            start = System.nanoTime();   	
            fib = fibRecur(n);      
            end = System.nanoTime();
            System.out.println("\t" + fib + "\t\t" + (end-start)/1000.);
         }
      }
   	/***********************
   	Calculates the nth Fibonacci number by iteration
   	***********************/
      public static long fibIterate(int n)
      {
         int a = 1;
         int b = 1;
         int fib = 0;
         if(n == 1 || n == 2)
         {
            return 1;
         }
         for(int x = 2; x < n; x++)
         {
            fib = a + b;
            a = b;
            b = fib;
         }     
         return fib;    
      }
   	/***********************
   	Calculates the nth Fibonacci number by recursion
   	***********************/
      public static long fibRecur(int n)
      {
      
         if( n == 1 || n == 2)
         {
            return 1;
         }
         else
         {
            return fibRecur(n-1) + fibRecur(n-2);
         }   
      }
   }