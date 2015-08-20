   import java.util.*;
   import java.io.* ;

   public class McRonald1000_7_Garg
   {
      public static Queue<Integer> queue = new LinkedList<Integer>();
      public static Queue<Integer> time = new LinkedList<Integer>();
      public static int minute, m = 0;
      public static int longestqueue, queuelength, wait, servetime, cserved, carrived, avgwait, avgserved, totaltime, largestserved;
      public static void main(String[] args)
      {
         for(int x = 0; x < 1000; x++)
         {
            for(int i = 1; i <= 1080; i++)
            {
               newMinute(i);   
            }
            while(!queue.isEmpty())
            {
               newMinute(1079);
            }
         } 
         avgserved = cserved / 1000;       
         System.out.println("Total customers served: " + cserved + " customers.");
         avgwait = totaltime/carrived;
         System.out.println("Average wait time: " + avgwait + " minutes.");
         System.out.println("Longest wait time: " + wait + " minutes.");
         System.out.println("Longest queue: " + longestqueue + " customers.");
         System.out.println("Average served per day: " + avgserved + " customers.");
         //System.out.println("Largest Day: " + largestserved + " customers.");
      }
   
      public static void newMinute(int time)
      {
         minute = time;
         if(minute < 1080)
         {
            addCustomers(carrived);
            //printQueue();
            serveCustomers(cserved);
         }   
         if(minute == 1080)
         {
            while(!queue.isEmpty())
            {
               serveCustomers(cserved);
               //printQueue();	  
               //System.out.println();
            }
         } 
         //System.out.println();
      }
      public static int addCustomers(int sofar)
      {
         if(queue.isEmpty())
         {
            queuelength = 0;
         }
         int total = sofar;
         int customers = 0;
         int k = (int) (Math.random() * 5);
         
         if(k == 1)
         {
            total++;
            queue.add(total);
            queuelength++;
            time.add(minute);   
         }
         if(longestqueue < queuelength)
         {
            longestqueue = queuelength;
         }
         carrived = total;
         return carrived;
      }
      
      public static int serveCustomers(int paid)
      {
         if(queue.isEmpty())
         {
            return cserved;
         }
         int k = (int) (Math.random() * 5);
         if(k == 0)
         {
            cserved = paid;
            return cserved;
         }
         if(k == 1)
         {
            queue.remove();
            cserved = paid;
            cserved++;
            queuelength--;
            int beginning = time.remove();
            servetime = minute - beginning;
            totaltime += servetime;
            if(wait < servetime)
            {
               wait = servetime;
            }
         }
         return cserved;
      }
      public static void printQueue()
      {
         Queue<Integer> temp = new LinkedList<Integer>();
         System.out.print("Minute " + minute + ": ");
         while(!queue.isEmpty())
         {
            m = 2;
            int j = queue.remove();	
            System.out.print("[" + j + "]" + " ");	
            temp.add(j);
         }
         if(queue.isEmpty() && m == 0)
         {
            System.out.print("[]");
         }
         while(!temp.isEmpty())
         {
            int a = temp.remove();
            queue.add(a);
         }
      }
   }