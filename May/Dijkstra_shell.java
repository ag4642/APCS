//Name:     Date:
//Graphs, Lesson #4

   import java.util.*;
   import java.io.*;

    class wVertex implements Comparable<wVertex>
   {
   
   }

    public class Dijkstra_shell
   {
       public static void main(String[] args) throws FileNotFoundException
      {
         List<wVertex> vertices = read();
         //List<wVertex> vertices = read2();
         int n = enterSource(vertices);    
         wVertex source = vertices.get(n); 
         computePaths(source);   
         System.out.println("Distance from "+ source.toString() );
         for (wVertex v : vertices)
         {
            System.out.print("    to " + v + ": " + v.getMinDistance() );
            System.out.println();
         }
      }
       public static List<wVertex> read()
      {
      
      }
       public static List<wVertex> read2() throws FileNotFoundException
      {
      
      }
       public static int enterSource(List<wVertex> theList)
      {
      
      }
       public static void computePaths(wVertex source)
      {
      
      }
   
       public static List<wVertex> getShortestPathTo(wVertex target)
      {
      
      }
   }

