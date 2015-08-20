   import java.util.Scanner;
   import java.io.*;
   public class AreaFill_7_Garg
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
         Scanner infile = new Scanner (new File(filename));
         String s = "";
         int numRows = infile.nextInt();
         int numCols = infile.nextInt();
         String[][] m = new String[numRows][numCols];
         char[][] c = new char[numRows][numCols];
         int z = 0;
         int y = 0;
         for(z = 0; z < numRows; z++)
         {
            for(int x = 0; x < numCols; x++)
            {
               m[z][y] = infile.next();
               s += m[z][y];
               y++;
            }
            //for(int i = 0; i < x; i++)
         	//{
         	//c[charRow] = s.toCharArray();
            
            infile.nextLine();
            z++;
         }
         
         return c;
      }
      
      public static void display(char[][] g)
      {
         for(int k = 0; k < g.length; k++)
         {
            for(int j = 0; j < g[0].length; j++)
            {
               System.out.print("" + g[k][j]);
            }
            System.out.println();
         }
      }   
      public static void fill(char[][] g, int r, int c, char ch) //recursive method
      {
         g[r][c] = ch; 
         if(g[r][c + 1] == ch)
         {
            c++;
            fill(g, r, c, ch);
         }
         else if(g[r][c - 1] == ch)
         {
            c--;
            fill(g, r, c, ch);
         }
         else if(g[r + 1][c] == ch)
         {
            r++;
            fill(g, r, c, ch);
         }
         else if(g[r - 1][c] == ch)
         {
            r--;
            fill(g, r, c, ch);
         }
      }
   }