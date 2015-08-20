   import java.util.*;
   import java.io.*;
    public class RoboCourier_shell
   {
       public static void main(String[] args) throws Exception
      {
         System.out.println("RoboCourier");
         System.out.print("Enter rc number: ");
         Scanner sc = new Scanner(System.in);
         String rcnumber = sc.next();
         Scanner file = new Scanner(new File("rc" + rcnumber + ".txt"));
         ArrayList<String> movesArray = new ArrayList<String>();
         while(file.hasNextLine())
            movesArray.add(file.nextLine());
         String[] moves	= new String[movesArray.size()];
         moves = movesArray.toArray(moves);
         
         RoboCourier rc = new RoboCourier();
           
         int totalTime = rc.timeToDeliver(moves);
         System.out.println("Returns: " + totalTime);
      }
   }	
    class RoboCourier
   {
       public RoboCourier()
      {
      }
       public int timeToDeliver(String[] path)
      {
         return -99;
      }
      
   }