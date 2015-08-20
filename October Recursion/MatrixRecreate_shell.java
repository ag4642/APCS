   public class MatrixRecreate_shell
   {
      public static void main(String[] args)
      {
         int[][] matrix = create();
         int[] rowcount = new int[matrix.length];
         int[] colcount = new int[matrix[0].length];
         count(matrix, rowcount, colcount);
         display(matrix, rowcount, colcount);
         re_create(rowcount, colcount);
      }
      public static int[][] create()
      {
         int rows = (int)(Math.random() * 3 + 3);
         int cols = (int)(Math.random() * 3 + 3);
         int[][] a = new int[rows][cols];
         for(int i = 0; i < rows; i++)
         {
            for(int k = 0; k < cols; k++)
            {
               int y = (int)(Math.random() * 2);
               a[i][k] = y;
            }
         }
         return a;
      }
      public static void count(int[][] matrix, int[] rowcount, int[] colcount)
      {
         for(int i = 0; i < matrix[0].length; i++)
         {
            for(int x = 0; x < matrix.length; x++)
            {
               if(matrix[x][i] == 1)
               {
                  rowcount[x]++;
                  colcount[i]++;
               }
            }
         }
      }
   
      public static void display(int[][] matrix, int[] rowcount, int[] colcount)
      {
         
         System.out.print("--");
         for(int x = 0; x < matrix[0].length; x++)
         {
            System.out.print(colcount[x] + " ");
         }
         System.out.println();
         for(int x = 0; x < matrix.length; x++)
         {
            System.out.print(rowcount[x] + " " );
            for(int i = 0; i < matrix[0].length; i++)
            {
               System.out.print(matrix[x][i] + " ");
            }
            System.out.println();
            
         } 
         System.out.println();
      }     
      public static void re_create(int[] rowcount, int[] colcount)
      {
         int[][] matrix = new int[rowcount.length][colcount.length];
         for(int x = 0; x < matrix.length; x++)
         {
            for(int y = 0; y < matrix[0].length; y++)
            {
               matrix[x][y] = 0;
            }
         }
         recur(matrix, rowcount, colcount, 0, 0);
      }
      private static void recur(int[][] m, int[] rowcount, int[] colcount, int row, int col) //recursive helper method
      {
      	if(m[0].length==col){
         	if(compare(m, rowcount, colcount))    //base case: if new matrix works
         	{
            	display(m, rowcount, colcount);    //we're done!
            	System.exit(0);
         	}
         }
         else if(row==rowcount.length){
            recur(m,rowcount,colcount,0,col+1);
         }
         else{
            m[row][col]=0;
            recur(m,rowcount,colcount,row+1,col);
            m[row][col]=1;
            recur(m,rowcount,colcount,row+1,col);
         }
      }
      private static boolean compare(int[][] m, int[] rowcount, int[] colcount)
      {
         int y = 0;
         for(int x = 0; x < m.length; x++)
         {
            for(int i = 0; i < m[0].length; i++)
            {
               if(m[x][i] == 1)
               {
                  y++;
               }
            }
            if(y != rowcount[x])
            {
               return false;
            }
            else y = 0;
         }
         int k = 0;
         for(k = 0; k < m.length; k++)
         {
            for(int i = 0; i < m[0].length; i++)
            {
               if(m[k][i] == 1)
               {
                  y++;
               }
            }
            if(y != colcount[k])
            {
               return false;
            }
            else y = 0;
         }
            
         return y == colcount[k];

      }
   }
