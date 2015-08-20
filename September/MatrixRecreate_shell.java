// Name: 
// Date:

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
      }
       public static void count(int[][] matrix, int[] rowcount, int[] colcount)
      {
      }
       public static void display(int[][] matrix, int[] rowcount, int[] colcount)
      {
      }
       public static void re_create(int[] rowcount, int[] colcount)
      {
      
      }
       private static void recur(int[][] m, int[] rowcount, int[] colcount, int row, int col) //recursive helper method
      {
         if(compare(m, rowcount, colcount))    //base case: if new matrix works
         {
            display(m, rowcount, colcount);    //we're done!
            System.exit(0);
         }
      }
       private static boolean compare(int[][] m, int[] rowcount, int[] colcount)
      {
      }
   }
