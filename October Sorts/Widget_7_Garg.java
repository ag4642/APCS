   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   
   public class Widget_7_Garg
   {
      public static final int numberOfWidgets = 57;
      public static void main(String[] args) throws Exception
      {
         Comparable[] array = input("widget.txt");
         Selection.sort(array);
         print(array);
      }
          	
      public static Comparable[] input(String filename) throws Exception
      {
         Scanner infile = new Scanner(new File(filename));
         Comparable[] array = new Widget[numberOfWidgets];
         for(int k = 0; k < numberOfWidgets; k++)
         {
            array[k] = new Widget(infile.nextInt(), infile.nextInt());
         }
         infile.close();
         return array;
      }
            
      public static void print(Object[] mango)
      {
         for(int x = 0; x < mango.length; x++)
         {
            System.out.println("" + mango[x]);
         }
      }
   }
  
   class Widget implements Comparable<Widget>
   {
      private int myPounds = 0;
      private int myOunces = 0;
      public Widget()
      {
         myPounds = myOunces = 0;
      }
      public Widget(int x, int y)
      {
         myPounds = x;
         myOunces = y;
      }
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
      public int compareTo(Widget w)
      {
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
      public String toString()
      {
         return "Widget: " + myPounds + " lbs., " + myOunces + " oz.";
      }
   }