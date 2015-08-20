   import java.util.Scanner;
   import java.io.*;
   public class Floyd_7_Garg
   {
      public static void floyd(int[][] g)
      {
         for(int x = 0; x < 8; x++)
         {
            for(int i = 0; i < 8; i++)
            {
               for(int z = 0; z < 8; z++)
               {
                  g[i][z] = Math.min(g[i][z], g[i][x] + g[x][z]); 
               }
            }
         }
      }         
      public static void main( String[] args)throws FileNotFoundException
      {
         System.out.print("Floyd's Algorithm! Enter filename: "); //citydataweighted.txt
         int[][] adjacency = read();
         floyd(adjacency);
         display(adjacency);
      }
   		
      public static int[][] read() throws FileNotFoundException
      {
         Scanner sc = new Scanner(System.in);
         String s = sc.next();
         Scanner infile = new Scanner(new File(s));
         int r = infile.nextInt();
         int c = infile.nextInt();
         int[][] array = new int[r][c];
         for(int x = 0; x < r; x++)
         {
            for(int i = 0; i < c; i++)
            {
               array[x][i] = infile.nextInt();
            }
         }
         infile.close();
         return array;
      }
      
      public static void display(int[][] g)
      {
         for(int r = 0; r < g.length; r++)
         {
            for(int c = 0; c < g[0].length; c++)
               System.out.print(" " + g[r][c] + " ");
            System.out.println();
         }
      }
   }