   import java.util.*;

   public class AssemblyLine_7_Garg
   {
      static int NDISKS = 50;
      static int MAXRADIUS = 100;
      public static void main(String[] args)
      {
         AssemblyLine a = new AssemblyLine(NDISKS, MAXRADIUS);
         a.showInput();
         a.process();
         a.showOutput();
      }
   }
   
   class AssemblyLine
   {
      private Queue<Disk> assemblyLineIn;
      private Queue<Pyramid> assemblyLineOut;
      private Pyramid robotArm;
   	/**
   		* initializes this object so the assemblyLineIn contains 
   		* nDisks with random radii;  assemblyLineOut is initialized to * an empty Queue; robotArm is initialized to an empty Pyramid.
   		**/
   	//Part A
      public AssemblyLine(int nDisks, int maxRadius)
      {	
         assemblyLineIn = new LinkedList<Disk>();
         for(int x = 0; x < nDisks; x++)
         {
            assemblyLineIn.add(new Disk((int)(Math.random()*100 + 1)));
         }
         assemblyLineOut = new LinkedList<Pyramid>();
         robotArm = new Pyramid();   
      }
   
   	/**
   		* "flips over" the pyramid in the robotArm and adds it to the
   		* assemblyLineOut queue.
   		* Precondition:  robotArm is not empty and holds an inverted 
   		*				pyramid of disks
   		**/
   	// Part B
      private void unloadRobot()
      { 
         Pyramid temp = new Pyramid();
         while(!robotArm.isEmpty())
         {
            temp.push(robotArm.pop());
         }
         assemblyLineOut.add(temp);
      }
   
   	/**
   		* processes all disks from assemblyLineIn; a disk is processed
   		* as follows:  if robotArm is not empty and the next disk does
   		* not fit on top of robotArm (which must be an inverted 
   		* pyramid) then robotArm is unloaded first; the disk from
   		* assemblyLineIn is added to robotArm; when all the disks
   		* have been retrieved from assemblyLineIn, robotArm is unloaded.
   		*  Precondition:  robotArm is empty;
   		*				assemblyLineOut is empty
   		**/
   	//Part C
      public void process()
      {
         while(!assemblyLineIn.isEmpty())
         {
            Disk temp = assemblyLineIn.remove();
            if(!(robotArm.isEmpty()) && (robotArm.peek().compareTo(temp) > 0))
            {
               unloadRobot();
               robotArm.add(temp);
            } 
            else if(!robotArm.isEmpty() && temp.compareTo(robotArm.peek()) > 0)
            {
               robotArm.push(temp);
            }
            else if(robotArm.isEmpty())
            {
               robotArm.push(temp);
            }
            unloadRobot();
         }
      }
      
      public void showInput()
      {
         System.out.println(assemblyLineIn);
      }
      public void showOutput()
      {
         System.out.println(assemblyLineOut);
      }
   }
   //Disk is standard and straightforward.
   class Disk implements Comparable<Disk>
   {
      private int myRadius;
      public Disk(int r)
      {
         myRadius = r;
      }
      public int getRadius()
      {
         return myRadius;
      }
      public void setRadius(int r)
      {
         myRadius = r;
      }
      public int compareTo(Disk d)
      {
         if(myRadius < d.getRadius())
         {
            return -1;
         }
         else
            return 1;
      }
      public String toString()
      {
         return "" + myRadius;
      }
   }
   //Pyramid is sly.
   class Pyramid extends Stack<Disk>
   {
     	
   }