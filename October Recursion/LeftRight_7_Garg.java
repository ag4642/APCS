   import java.util.*;
   public class LeftRight_7_Garg
   {
      public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("\nHow many digits? ");
         String s = sc.next();
         int n = Integer.parseInt(s);
         recursive("", n);
         oddDigits("", n);
         superprime(n);
      }
      public static void recursive(String s, int n)
      {
         String a = "";
         String b = "";
         if(s.length() == n)
         {
            System.out.println("" + s);
         }
         else 
         {
            recursive(s + "L", n);
            recursive(s + "R", n);
         }  
      }
      public static void oddDigits(String s, int n)
      {
         String a = "";
         String b = "";
         if(s.length() == n)
         {
            System.out.println("" + s);
         }
         else 
         {
            for(int x = 1; x < 10; x+= 2)
            {
               oddDigits(s + x, n);
            }
         }  
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
         if(n == 0) 
         {
            return; 
         }
      	
         if(isPrime(k)) 
         {
            recur(k*10+1,n-1);
            recur(k*10+3,n-1);
            recur(k*10+7,n-1);
            recur(k*10+9,n-1);	
            
            if(n==1)
            {
               System.out.println(k);
            }
         }
      }
      private static boolean isPrime(int n)
      {
         if (n <= 1)
         {
            return false;
         }
         if (n == 2)
         {
            return true;
         }
         if (n % 2 == 0)
         {
            return false;
         }
         for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) 
         {
            if (n % i == 0) 
            {
               return false;
            }
         }
         return true;
      }   
   }