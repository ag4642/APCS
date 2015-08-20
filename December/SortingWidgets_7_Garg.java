   import java.io.*;     
   import java.util.*;  
   import java.io.*;      
   import java.util.*;  
     
   public class SortingWidgets_7_Garg
   {
      public static void main(String[] args) throws Exception
      {
         ArrayList<Comparable> apple = input("widget.txt");  
         sort(apple);
         output(apple);
      }
      public static ArrayList<Comparable> input(String filename) throws Exception
      {
         Scanner infile = new Scanner( new File(filename) );
         ArrayList<Comparable> array = new ArrayList<Comparable>();	
         for (int k =0; k<20; k++)    		
         {								  
            int x = infile.nextInt();
            int y = infile.nextInt();
            array.add(k, new Widget(x, y));
         }
         infile.close();
         return array;
      }
      public static void sort(ArrayList<Comparable> array)
      {
         int maxPos;
         for(int k = 0; k < array.size(); k++)		
         {
            maxPos = findMax(array, array.size() - k - 1);
            swap(array, maxPos, array.size() - k - 1);
         }
      }
      public static int findMax(ArrayList<Comparable> array, int upper)
      {
         int maxPos = 0;
         for(int j = 1; j <= upper; j++)			
            if(array.get(j).compareTo(array.get(maxPos)) > 0)	
               maxPos = j;					
         return maxPos;
      }
      public static void swap(ArrayList<Comparable> array, int a, int b)
      {
         Comparable temp = array.get(a);				
         array.set(a, array.get(b));
         array.set(b, temp);
      }
      public static void output(ArrayList<Comparable> array)
      {
         for(Comparable k : array)
            System.out.println(k + ", ");
      }
   }

///////////////////////////////////////////////////////////////

   class Widget implements Comparable<Widget>
   {
   	//data fields
      private String myName;
      private int myPounds, myOunces;
   
   	//constructors
      public Widget()
      {
         myPounds = myOunces = 0;
      }
      public Widget(int x)
      {
         myPounds = x;
         myOunces = 0;
      }
      public Widget(int x, int y)
      {
         myPounds = x;
         myOunces = y;
      }
      public Widget(Widget arg)
      {
         myPounds = arg.getPounds();
         myOunces = arg.getOunces();
      }
   
   	//accessors and modifiers
      public int getPounds()
      {
         return myPounds;
      }
      public int getOunces()
      {
         return myOunces;
      }
      public void setPounds(int x)
      {
         myPounds = x;
      }
      public void setOunces(int x)
      {
         myOunces = x;
      }
   
   	//other methods
      public int compareTo(Widget w)
      {
        // Widget w = (Widget)arg;     no need to cast
         if(myPounds < w.getPounds())
            return -1;
         if(myPounds > w.getPounds())
            return 1;
         if(myOunces < w.getOunces())
            return -1;
         if(myOunces > w.getOunces())
            return 1;
         return 0;
      }
      public boolean equals(Widget arg)
      {
         return compareTo(arg) == 0;
      }
      public String toString()
      {
         return myPounds + " lbs. " + myOunces + " oz.";
      }
   }