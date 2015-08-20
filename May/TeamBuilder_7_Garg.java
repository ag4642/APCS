   import java.util.Scanner;
   import java.io.*;
   import java.util.Arrays; 

   public class TeamBuilder_7_Garg
   {
      public static void main(String[] args) 
      {
         String[] path = {"010", "000", "110"};	   
         //String[] path = {"0010", "1000", "1100", "1000"};
         //String[] path = {"01000", "00100", "00010", "00001", "10000"};
         //String[] path = {"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
        
         int[] ret = specialLocations(path);
         
         System.out.println("{" + ret[0] + ", " + ret[1] + "}");
      }
      public static int[] specialLocations(String[] paths)
      {
         int n = paths.length; 
         int[] answer = new int[2]; 
         int[][] matrix = new int[n][n]; 
         for(int i = 0; i < n; i++) 
         {
            Arrays.fill(matrix[i], 100000); 
         }
         for(int i = 0; i < n; i++) 
         {
            for(int j = 0; j < n; j++) 
            {
               if(paths[i].charAt(j) == '1') 
               {
                  matrix[i][j] = 1; 
               }
            }
         }
         for(int k = 0; k < n; k++)
         { 
            for(int i = 0; i < n; i++) 
            {
               for(int j = 0; j < n; j++)
               { 
                  matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
               }
            }
         } 
         for(int i = 0; i < n; i++) 
         { 
            int c = 0; 
            for(int j = 0; j < n; j++) 
            {
               if(i != j)
               { 
                  if(matrix[i][j] < 100000) 
                     c++; 
               } 
            }
            if(c == n - 1) 
            {
               answer[0]++; 
            }
         }
         for(int i = 0; i < n; i++)
         { 
            int c = 0; 
            for(int j = 0; j < n; j++) 
            {
               if(i != j)
               { 
                  if(matrix[j][i] < 100000) 
                     c++; 
               } 
            }
            if(c == n - 1) 
               answer[1]++; 
         } 
         return answer; 
      } 
   }