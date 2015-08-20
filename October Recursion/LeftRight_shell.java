//your name, date
   import java.util.*;
    public class LeftRight_shell
   {
       public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("\nHow many digits? ");
         String s = sc.next();
         int n = Integer.parseInt(s);
         recursive("", n);
         //oddDigits("", n);
      	//superprime(n);
      }
       public static void recursive(String s, int n)
      {
      }
       public static void oddDigits(String s, int n)
      {
      }
      
   	//the SuperPrime methods 
       public static void superprime(int n)
      {
         recur(2, n); //try leading 2, etc.
         recur(3, n); //all the primes < 10
         recur(5, n);
         recur(7, n);
      }
       private static void recur(int k, int n)
      {
      }
       private static boolean isPrime(int n)
      {
      }   
   }
