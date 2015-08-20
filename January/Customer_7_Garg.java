   import java.util.*;
   import java.io.* ;

   public class Customer_7_Garg implements Comparable<Customer>
   {
      private int myGradYear, myMinute;
      public Customer(int gradYear, int minute)
      {
         myGradYear = gradYear;
         myMinute = minute;
      }
      public static int compareTo(Customer c)
      {
         return myGradYear.compareTo(c.myGradYear);
      }
   }