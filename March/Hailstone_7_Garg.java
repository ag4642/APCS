   import java.util.*;
   public class Hailstone_7_Garg
   {
      private static Map<Integer, Integer> steps = new HashMap<Integer, Integer>();
      private static Map<Integer, String> seq = new HashMap<Integer, String>();
      public static void main(String[] args)
      {
         for(int i = 1; i <= 200; i++)
         {
            hailstone(i);
         }
      }
      public static void hailstone(int n)
      {
         long start = System.nanoTime();
         int steps = hailsteps(n);
         long finish = System.nanoTime();
         long time = finish - start;
         System.out.println("h(" + n + ") takes " + steps + " steps in " + time + " nanoseconds");
         hail(n);
      }
      public static int hailsteps(int n)
      {
         int count = 0;
         while(n != 1)
         {
            if(steps.containsKey(n))
            {
               n = 1;
               count += steps.get(n);
            }
            else if(n % 2 == 0)
            {
               n = n / 2;
               count++;
            }
            else
            {
               n = 3 * n + 1;
               count++;
            }
         }
         steps.put(n, count);
         return count;
      }
      public static void hail(int n)
      {
         int nn = n;
         seq.put(n, n + ", ");
         while(n != 1)
         {
            if(steps.containsKey(n))
            {
               n = 1;
               seq.put(nn, seq.remove(nn) + ", " + seq.get(n));
            }
            else if(n % 2 == 0)
            {
               n = n / 2;
               seq.put(nn, seq.remove(nn) + n + ", ");
            }
            else
            {
               n = 3 * n + 1;
               seq.put(nn, seq.remove(nn) + n + ", ");
            }
         
         }
         System.out.println(seq.get(nn).substring(0, seq.get(nn).length() - 2));
      }
   }