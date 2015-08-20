   //name:
   //date:
   
   import java.util.Scanner;
   import java.io.*;
    public class AreaFill_shell
   {
      public static char[][] grid = null;
   
       public static void main(String[] args) throws FileNotFoundException
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("Filename: ");
         String filename = sc.next();
         grid = read(filename);
         display(grid);
         System.out.print("\nEnter ROW COL to fill from: ");
         int row = sc.nextInt();
         int col = sc.nextInt(); 
         fill(grid, row, col, grid[row][col]);
         display(grid);
         sc.close();
      }
       public static char[][] read(String filename)throws FileNotFoundException
      {
      
      }
      
       public static void display(char[][] g)
      {
                      
      }
       public static void fill(char[][] g, int r, int c, char ch) //recursive method
      {
       
       
       
      }
   }