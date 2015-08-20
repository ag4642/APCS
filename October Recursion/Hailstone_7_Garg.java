   import java.util.Scanner;
  
   public class Hailstone_7_Garg
   {
      public static void main(String[] args)
      {
         System.out.println("Hailstone Numbers!");
         System.out.print("Enter the start value: ");
         Scanner sc = new Scanner(System.in);
         int start = sc.nextInt();
         int count = hailstone(start, 1);
         System.out.println("" + "The number of steps to reach 1 is: " + count);
      }
      
      public static int hailstone(int n, int count)
      {
         System.out.print("" + n + "-");
         for(int x = 0; x < 100; x++)
         {
            if(n == 1)
            {
               System.out.println("");
               break;
            }
            else if (n == 2)
            {
               n = n/2;
               System.out.print("" + n);
               count++;
            }
            else if(n % 2 == 0)
            {
               n = n/2;
               System.out.print("" + n + "-");
               count++;
            }
            else if(n % 2 == 1)
            {
               n = 3 * n + 1;
               System.out.print("" + n + "-");
               count++;
            }
         } 
         return count;
      }
   }