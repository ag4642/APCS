	//mlbillington@fcps.edu     4/25/2007
   import java.util.*;
   public class WidgetsInSets
   {
      public static void main(String[] args)
      {
         Set<Widget> tSet = new TreeSet<Widget>();
         Set<Widget> hSet = new HashSet<Widget>();
      	
         Widget a = new Widget(2,3);   //same or different?
         Widget b = new Widget(2,3);
         Widget c = new Widget(2,3);
         //c = b;
         
         tSet.add(a); 
         tSet.add(b);
         tSet.add(c);
       
         hSet.add(a); 
         hSet.add(b);
         hSet.add(c); 
         
         System.out.println(a.hashCode() + " " + b.hashCode() + " " + c.hashCode());
         
         System.out.println("TreeSet:  " + tSet);
         System.out.println("HashSet:  " + hSet);
      }
   }