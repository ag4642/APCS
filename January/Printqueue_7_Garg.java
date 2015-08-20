   import java.util.*;
   import java.io.* ;

   public class Printqueue_7_Garg
   {
      public static Queue<Integer> queue = new LinkedList<Integer>();
      public static int start = 100;
      public static String s;
      public static void main(String[] args)
      {
         System.out.println("Add, Print, Delete, eXit");
         Scanner infile = new Scanner(System.in); 
         while(true) 
         {
            s = infile.next();
            System.out.println("Add, Print, Delete, eXit");
            if(s.equals("A"))
            {
               add();
               printQueue();
            }
            if(s.equals("P"))
            {
               printJob();
               printQueue();
            }
            if(s.equals("D"))
            {
               System.out.println("Enter job number");
               String str = infile.next();
               int z = Integer.parseInt(str);
               delete(z);
               printQueue();
            }
            if(s.equals("X"))
            {
               System.exit(0);
            }
         }  
      }
   
      public static void add()
      {
         queue.add(start);   
         start++;
      }
      public static void printJob()
      {
         if(queue.isEmpty())
         {
            System.out.println("Sorry, queue is empty");
         }
         else
         {
            queue.remove();
         }
      }
      public static void delete(int num)
      {
         Queue<Integer> temp = new LinkedList<Integer>();
         int a = 0;
         if(queue.isEmpty())
         {
            System.out.println("Sorry, queue is empty");
         }
         else
         {
            while(!queue.isEmpty())
            {
               a = queue.remove();
               if(a == num)
               {
                  a = 0;
               }
               else 
                  temp.add(a);
            }
            while(!temp.isEmpty())
            {
               a = temp.remove();
               queue.add(a);
            }
         }	
      }
      public static void printQueue()
      {
         Queue<Integer> temp = new LinkedList<Integer>();
         if(queue.isEmpty())
         {
            System.out.println("Sorry, queue is empty");
         }
         while(!queue.isEmpty())
         {
            int a = queue.remove();
            System.out.print(a + " ");
            temp.add(a);
         }
         while(!temp.isEmpty())
         {
            int b = temp.remove();
            queue.add(b);
         }
      }
   }