//Author: 
//Date:    
   import java.util.Scanner;
  
    public class Hailstone_shell
   {
       public static void main(String[] args)
      {
         System.out.println("Hailstone Numbers!");
         System.out.print("Enter the start value: ");
         Scanner sc = new Scanner(System.in);
         int start = sc.nextInt();
         int count = hailstone(start, 1);
         System.out.println("The number of steps to reach 1 is: " + count );
      }
      
       public static int hailstone(int n, int count)
      {
     
      }
   }