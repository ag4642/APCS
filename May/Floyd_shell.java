//Name:       Date: 
//Graphs, Lesson #3

   import java.util.Scanner;
   import java.io.*;
    public class Floyd_shell
   {
       public static void floyd( int[][] g)
      {

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