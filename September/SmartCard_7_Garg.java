   import java.text.DecimalFormat;
   
   class Station
   { 
      public String myName;
      public int myZone;
      
      public Station(String a, int b)
      {
         myName = a;
         myZone = b;
      }
      public String getName()
      {
         return myName;
      }
      public int getZone()
      {
         return myZone;
      }
      public void setName(String a)
      {
         myName = a;
      }
      public void setZone(int b)
      {
         myZone = b;
      }
   }
   public class SmartCard_7_Garg
   {
      public static void main(String[] args) 
      {
         Station downtown = new Station("Downtown", 1);
         Station center = new Station("Center City", 1);
         Station uptown = new Station("Uptown", 2);
         Station suburbia = new Station("Suburb", 4);
        
         SmartCard jimmy = new SmartCard(20.00); 
         jimmy.board(center);            		    
         jimmy.disembark(suburbia);
         jimmy.addMoney(6);					 
         jimmy.disembark(uptown);
         		
      }
   }
   class SmartCard 
   {
      private double myMoney, myCost;
      private  String board,disembark,myStation;
      private int startZone, stopZone; 
      private Station station; 
   	
      public SmartCard(double s)
      {
         myMoney = s;
      }
      public void addMoney(double m)
      {
         myMoney+= m;
         System.out.println("Money added " + m + " New Balance: " + myMoney);
      }
      public void board(Station boarded)
      {
         board = boarded.getName();
         startZone = boarded.getZone();
         if(board.equals(myStation))
         {
            System.out.println("Can't board without disembarking");
            System.exit(0);
         }
         else myStation = board;
         System.out.println("Boarded at: " + myStation);
         if(myMoney<.50)
         {
            System.out.println("Not enough money");
            System.exit(0);
         }
      }
      public double cost(Station start, Station stop)
      {
         double cost = 0.00;
         int travelled = 0;
         int zone1 = start.getZone();
         int zone2 = stop.getZone();
         if(zone2 == zone2 && start == stop)
         {cost = 0.50;
         }
         else if(zone2 > zone1)
         {
            travelled = zone2 - zone1;
            cost = (0.75 * travelled) + 0.50;
         }
         else if(zone1 > zone2)
         {
            travelled = zone1 - zone2;
            cost = (0.75 * travelled) + 0.50;
         }
         return cost;
      }
      public void disembark(Station disembarked)
      {
         Station boardable = new Station("Placeholder", 6);
         boardable.setName(board);
         boardable.setZone(startZone);
         double price = cost(boardable, disembarked);
         disembark = disembarked.getName();
         stopZone = disembarked.getZone();
         
         if(board.equals("none"))
         {
            System.out.println("Unable to disembark");
            System.exit(0);
         
            System.out.println("" + board + disembark + myCost + myMoney);
         }   
         else myStation = disembark;
      	 
         myMoney -= price;
         System.out.println("Boarded at: " + board + ". Disembarked at: " + disembark + ". The Price was " + price + ". Your smart card balance is " + myMoney + "."); 
         board = "none";
      } 	 	
   }