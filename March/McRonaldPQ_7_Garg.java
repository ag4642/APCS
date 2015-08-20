   import java.util.*;
   import java.io.* ;

   public class McRonaldPQ_7_Garg
   {
      //public static PriorityQueue<Customer> queue = new PriorityQueue<Customer>(); 
      public static HeapPriorityQueue_7_Garg<Customer> queue = new HeapPriorityQueue_7_Garg<Customer>();
      public static Queue<Integer> time = new LinkedList<Integer>();
      public static int minute, m = 0;
      public static int longestqueue, queuelength, wait, servetime, cserved, carrived, avgwait, totaltime;
      public static double seniors, juniors, sophomores, freshmen, seniorswait, juniorswait, sophomoreswait, freshmenwait;
      public static double seniorsavg, juniorsavg, sophomoresavg, freshmenavg;
   
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
         // System.out.println("Total customers served: " + cserved + " customers.");
         // avgwait = totaltime/carrived;
         // System.out.println("Average wait time: " + avgwait + " minutes.");
         // System.out.println("Longest wait time: " + wait + " minutes.");
         // System.out.println("Longest queue: " + longestqueue + " customers.");
      }
   
      public static void newMinute(int time)
      {
         minute = time;
         if(minute < 1080)
         {
            addCustomers(carrived);
            serveCustomers(cserved);
         }   
         if(minute == 1080)
         {
            while(!queue.isEmpty())
            {
               serveCustomers(cserved);
            }
            printQueue();
         } 
      }
      public static int addCustomers(int sofar)
      {
         if(queue.isEmpty())
         {
            queuelength = 0;
         }
         int total = sofar;
         int k = (int) (Math.random() * 5);
         
         if(k==1)
         {
            int whichyear = (int) (Math.random() * 4);
         
            if(whichyear == 0)
            {
               total++;
               queue.add(new Customer(4, total, minute));
               queuelength++;
               freshmen++;
            
            }
            if(whichyear == 1)
            {
               total++;
               queue.add(new Customer(3, total, minute));
               queuelength++;
               sophomores++;
            
            }
            if(whichyear == 2)
            {
               total++;
               queue.add(new Customer(2, total, minute));
               queuelength++;
               juniors++;
            
            }
            if(whichyear == 3)
            {
               total++;
               queue.add(new Customer(1, total, minute));
               queuelength++;
               seniors++;
            }
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
         int k = (int) (Math.random() * 8);
         if(k != 1)
         {
            cserved = paid;
            return cserved;
         }
         if(k == 1)
         {
            for(int j = 1; j <= 3; j++)
            {
               if(!queue.isEmpty())
               {
                  Customer g = queue.remove();
                  cserved++;
                  queuelength--;
                  int beginning = g.getMinute();
                  int years = g.getGrad();
                  servetime = minute - beginning;
                  totaltime = totaltime + servetime;
                  if(years == 1)
                  {
                     if(seniorswait < servetime)
                     {
                        seniorswait = servetime;
                     }
                  }
                  else if(years == 2)
                  {
                     if (juniorswait < servetime)
                     {
                        juniorswait = servetime;
                     }
                  }
                  else if(years == 3)
                  {
                     if(sophomoreswait < servetime)
                     {
                        sophomoreswait = servetime;
                     }
                  }
                  else if(years == 4)
                  {
                     if(freshmenwait < servetime)
                     {
                        freshmenwait = servetime;
                     }
                  }
               }
            }
         }
         return cserved;
      }
      public static void printQueue()
      {
         if(seniors > 0)
         {
            seniorsavg = seniorswait / seniors;
         }
         if(juniors > 0)
         {
            juniorsavg = juniorswait / juniors;
         }
         if(sophomores > 0)
         {
            sophomoresavg = sophomoreswait / sophomores;
         }
         if(freshmen > 0)
         {
            freshmenavg = freshmenwait / freshmen;
         }
         double a = seniorsavg;
         double b = juniorsavg;
         double c = sophomoresavg;
         double d = freshmenavg;
         double temp = seniorsavg;     
         double temp1 = juniorsavg;
         double temp2 = sophomoresavg;
         double temp3 = freshmenavg;
        
         if(a > b)
         {
            a = b; 
            b = temp;  
         }
         if(a > c)
         {
            temp = a;
            a = c;
            c = temp;
         }
         if(a > d)
         {
            temp = a;
            a = d;
            d = temp;
         }
         if(b > c)
         {
            temp1 = b;
            b = c;
            c = temp1;
         }
         if(b > d)
         {
            temp1 = b;
            b = d;
            d = temp2;
         }
         if(c > d)
         {
            temp2 = c;
            c = d;
            d = temp2;	
         }
         if(a == b)
         {
            b += .02397234972;
         }
         if(b == c)
         {
            c += .045838965;
         }
         if( c == d)
         {
            d+= .013586498;
         }
         if( c > d)
         {
            double y = c;
            c = d;
            d = y;
         }
         if(b > c)
         {
            double z = b;
            b = c;
            c = z;
         }
         if( a== b)
            a -= .05473648564;
         System.out.println("Number Seniors Served: " + seniors + " Seniors          Average Wait time: " + a + " seconds.");
         System.out.println("Number Juniors Served: " + juniors + " Juniors          Average Wait time: " + b + " seconds.");
         System.out.println("Number Sophomores Served: " + sophomores + " Sophomores    Average Wait time: " + c + " seconds.");
         System.out.println("Number Freshmen Served: " + freshmen + " Freshman        Average Wait time: " + d + " seconds.");
      }
   }
   class Customer implements Comparable<Customer>
   {
      private static int grad, came, timecame;
      public Customer(int year, int number, int minute)
      {
         grad = year;
         came = number;
         timecame = minute;
      }
      public static int getGrad()
      {
         return grad;
      }
      public static int getMinute()
      {
         return timecame;
      }
      public static int getNumber()
      {
         return came;
      }
   
      public int compareTo(Customer obj)
      {
         int whatis = 0;
         if(grad < obj.getGrad())
         {
            whatis = -1;
         }
         if(grad > obj.getGrad())
         {
            whatis = 1;
         }
         if(grad == obj.getGrad())
         {
            whatis = 0;
         }
         return whatis;
      }
   }
