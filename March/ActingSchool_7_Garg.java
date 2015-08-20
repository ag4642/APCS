   import java.util.*;
   public class ActingSchool_7_Garg
   {
      public static void main(String[] args)
      {
         Map<String,String> sGrades = new TreeMap<String, String>();
         sGrades.put("Jack Nicholson", "A-");
         sGrades.put("Humphrey Bogart", "A+");
         sGrades.put("Audrey Hepburn", "A");
         sGrades.put("Meryl Streep", "A-");
         sGrades.put("Jimmy Stewart", "A");
         
         for(String s : sGrades.keySet())
         {
            System.out.println(s + " (" + sGrades.get(s) + ")");
         }
         System.out.println();
         TreeMap gStudents = new TreeMap();
         Iterator it = sGrades.keySet().iterator();
         it = sGrades.keySet().iterator();
         while(it.hasNext())
         {
            Object x = it.next();
            Object y = sGrades.get(x);
            if(!gStudents.containsKey(y))
            {
               ArrayList al = new ArrayList();
               al.add(x);
               gStudents.put(y, al);
            }
            else
               ((ArrayList)gStudents.get(y)).add(x);
         }
         it = gStudents.keySet().iterator();
         while(it.hasNext())
         {
            Object x = it.next();
            Object y = gStudents.get(x);
            System.out.println(x + ": " + y);      
         }
      }
   }