   public class TJArrayList_7_Garg
   {  
      public static void main(String [] args)
      {
         TJArrayList myList = new TJArrayList();	
         myList.add("Apple");
         myList.add("Banana");
         myList.add("Date");
         myList.add(2, "Cucumber");
         System.out.println(myList);
         System.out.println("Size is " + myList.size());
         System.out.println("Get 2: " + myList.get(2));;
         myList.set(2, "Cheese");
         System.out.println(myList);
         Object obj = myList.remove(2);
         System.out.println(myList);
         System.out.println("Removed "+ obj);
         System.out.println("Size is " + myList.size());
         System.out.print("Add 11 elements: ");
         for(int i = 3; i <= 10; i++)
            myList.add(new Integer(i));   
         System.out.println(myList);	
      }
   }
   
   class TJArrayList
   {
      private int size;							//stores the number of objects
      private Object[] myArray;
      public TJArrayList()                //default constructor makes 10 cells
      {
         myArray = new Object[10];
         for(int x = 0; x < 10; x++)
         {
            myArray[x] = null;
         }
      
         size = 10;
      }
      public int size()
      {
         return size;
      }
    	/* appends obj to end of list; increases size;
   	  @return true  */
      public boolean add(Object obj)
      {
         if(myArray.length == size)
         {
            Object[] newArray = new Object[size * 2]; 
            for(int x = 0; x < myArray.length; x++)
               newArray[x] = myArray[x];
            myArray = newArray;
         }
         myArray[size] = obj; 
         size++;
         return true;
      }
      /* inserts obj at position index.  increments size. 
   		*/
      public void add(int index, Object obj)
      {
         myArray[index] = obj;
         size++;
      }
      /* return obj at position index.  
   		*/
      public Object get(int index)
      {
         return myArray[index];
      }
    /* replaces obj at position index.  
   		*/
      public void set(int index, Object obj)
      {
         myArray[index] = obj;
      }
    /*  removes the node from position index. shifts elements 
        to the left.   Decrements size.
   	  @return the object at position index.
   	  */
      public Object remove(int index)
      {
         Object o = myArray[index];
         for(int x = index + 1; x < myArray.length; x++)
         {
            myArray[x - 1] = myArray[x];
         }
         size--;
         return o;
      }
      /*returns the Objects in the array, nicely formatted, 
   	   e.g. [Apple, Banana, Cucumber, Date]
        	*/
      public String toString()
      {
         String s = "";
         for(int i = 0; i < myArray.length; i++)
         {
            if(myArray[i] != null)
            {
               s += myArray[i] + " ";
            }
         }
         System.out.println(s);
         return s;
      }
   }