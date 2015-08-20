	//This code uses raw arrays.  Change it to use ArrayList<E> instead.

   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   import java.io.*;      //the File class
   import java.util.*;    //ArrayList & the Scanner class in Java 1.5
     
    public class SortingWidgets_shell
   {
       public static void main(String[] args) throws Exception
      {
         Comparable[] apple = input("widget.txt");  
         sort(apple);
         output(apple);
      }
       public static Comparable[] input(String filename) throws Exception
      {
         Scanner infile = new Scanner( new File(filename) );
         Comparable[] array = new Comparable[20];	
         for (int k =0; k<20; k++)    		    // read all data in the file
         {								  
            int x = infile.nextInt();
            int y = infile.nextInt();
            array[k] = new Widget(x, y);
         }
         infile.close();
         return array;
      }
       public static void sort(Comparable[] array)
      {
         int maxPos;
         for(int k = 0; k < array.length; k++)		
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
       public static int findMax(Comparable[] array, int upper)
      {
         int maxPos = 0;
         for(int j = 1; j <= upper; j++)			
            if(array[j].compareTo(array[maxPos]) > 0)	
               maxPos = j;					
         return maxPos;
      }
       public static void swap(Object[] array, int a, int b)
      {
         Object temp = array[a];				
         array[a] = array[b];
         array[b] = temp;
      }
       public static void output(Object[] array)
      {
         for(int k = 0; k < array.length; k++)		//use the for-each loop
            System.out.println(array[k]);
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