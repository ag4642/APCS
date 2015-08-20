   public class Modes_7_Garg
   {
      public static void main(String[] args)
      {
         int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
         display(tally);
         int[] modes = calculateModes(tally);
         display(modes);
         int sum = 0;
         for(int k = 0; k < tally.length; k++)
            sum += tally[k];
         System.out.println("kth \tindex"); 
         for(int k = 1; k <= sum; k++)
            System.out.println(k + "\t\t" + kthDataValue(tally, k));
      }
      public static int[] calculateModes(int[] tally)
      {
         int[] array = new int[3];
         double y = findMax(tally);
         int z = 0;
         for(int x=0; x<tally.length; x++)
         {
            if(tally[x]==y)
            {
               array[z]= x;
               z++;
            }		
         }
         return array;	
      }
      public static int kthDataValue(int[] tally, int k)
      {
         {
            int y = 0;
            for(int x=0; x<tally.length; x++)
            {
               y += tally[x];
               if (y >= k)
               {
                  return x;
               }
            }
         }
         return -1;
      }
      public static int findMax(int[] nums)
      {
         int pos = 0;
         for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
               pos = k;
         return nums[pos];
      }
      public static void display(int[] args)
      {
         for(int k = 0; k < args.length; k++)
            System.out.print(args[k] + " ");
         System.out.println();
         System.out.println();
      }
   }
