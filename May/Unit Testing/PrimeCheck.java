//author: Ross Dempsey    date:  February 2013

   public class PrimeCheck {
      public static boolean isPrime(int n) {
         for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
               return false;
         return true;
      }
   }