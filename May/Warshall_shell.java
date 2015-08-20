//Name:      Date:
//Graphs, Lesson #1
   import java.util.Scanner;
   import java.io.*;
    public class Warshall_shell
   {
       public static void warshall( int[][] g)
      {
      
      }
      
       public static void main( String[] args) throws FileNotFoundException
      {
         System.out.print("Warshall's Algorithm! Enter filename: "); //citydata.txt
      																					//citydataundirected.txt
         int[][] adjacency = read();
         warshall(adjacency);
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