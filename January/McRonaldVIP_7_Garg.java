   import java.util.*;
   import java.io.* ;

   public class McRonaldVIP_7_Garg
   {
      public static Queue<Integer> queue = new LinkedList<Integer>();
      public static Queue<Integer> time = new LinkedList<Integer>();
      public static Queue<Integer> VIPqueue = new LinkedList<Integer>();
      public static Queue<Integer> VIPtimequeue = new LinkedList<Integer>();
      public static int minute, m = 0;
      public static int starting, viparrived, vipserved, vipwait, vipservetime, vipqueuelength;
      public static int longestqueue, queuelength, wait, servetime, cserved, carrived, avgwait, totaltime;
      public static void main(String[] args)
      {
         for(int i = 1; i <= 1080; i++)
         {
            newMinute(i);
         }
         while(!queue.isEmpty())
         {
            newMinute(1079);
         }
         System.out.println("Total customers served: " + cserved + " customers.");
         avgwait = totaltime/carrived;
         System.out.println("Average wait time: " + avgwait + " minutes.");
         System.out.println("Longest wait time: " + wait + " minutes.");
         System.out.println("Longest queue: " + longestqueue + " customers.");
         System.out.println("Number of VIPs arrived: " + viparrived + " VIPs.");
         System.out.println("Number of VIPs served: " + vipserved + " VIPs.");
         int avgvipwait = vipwait / viparrived;
         System.out.println("Average VIP wait time: " + avgvipwait + " minutes.");
         
      }
   
      public static void newMinute(int time)
      {
         minute = time;
         if(minute < 1080)
         {
            addCustomers(carrived);
            printQueue();
            serveCustomers(cserved);
         }   
         if(minute == 1080)
         {
            while(!queue.isEmpty())
            {
               serveCustomers(cserved);
               printQueue();	  
               System.out.println();
            }
         } 
         System.out.println();
      }
      public static int addCustomers(int sofar)
      {
         if(queue.isEmpty())
         {
            queuelength = 0;
         }
         int total = sofar;
         int k = (int) (Math.random() * 5);
         int isVip = (int) (Math.random() * 50);
         if(isVip == 1)
         {
            k = 0;
            viparrived++;
            VIPqueue.add(viparrived);
            vipqueuelength++;
            VIPtimequeue.add(minute);
            return viparrived;
         }
         
         else if(k == 1)
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
         int vipk = (int) (Math.random() * 2);
         if(vipk == 1)
         {
            if(!VIPqueue.isEmpty())
            {
               for(int m = 0; m <= 3; m++)
               {
                  if(!VIPqueue.isEmpty())
                  {
                     VIPqueue.remove();
                  // served = paid;
                     vipserved++;
                     vipqueuelength--;
                     int beginning = VIPtimequeue.remove();
                     vipservetime = minute - beginning;
                     totaltime = totaltime + vipservetime;
                     if(vipwait < vipservetime)
                     {
                        vipwait = vipservetime;
                     }
                  }
               }
            }
            return vipserved;
         }
      
         if(k == 0)
         {
            cserved = paid;
            return cserved;
         }
         else if(k == 0)
         {
            cserved = paid;
            return cserved;
         }
         
         else if(k == 1)
         {
            for(int j = 1; j <= 3; j++)
            {
               if(!queue.isEmpty())
               {
                  queue.remove();
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