//Name:                Date:
/*************************************** 
Modify the Widget class so that it hashes on its
values, not on its address.  Be sure that compareTo(),
equals(Object) and hashCode() agree with each other.
****************************************/

    public class Widget_7_Garg implements Comparable<Widget>
   {
   	//data fields
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
   
   	//public int compareTo(Widget w)
   	//public boolean equals(Widget arg)  
   	//public String toString()
   	//public boolean equals(Object arg)
      //public int hashCode()
   }