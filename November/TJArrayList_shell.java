//  name:        date: 
//  implements the List interface with a backing array of Objects. 
//	 also overrides toString().
    
    public class TJArrayList_shell
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
      
      }
       public int size()
      {
      
      }
    	/* appends obj to end of list; increases size;
   	  @return true  */
       public boolean add(Object obj)
      {
      
      }
      /* inserts obj at position index.  increments size. 
   		*/
       public void add(int index, Object obj)
      {
      
      }
      /* return obj at position index.  
   		*/
       public Object get(int index)
      {
      
      }
    /* replaces obj at position index.  
   		*/
       public void set(int index, Object obj)
      {
      
      }
    /*  removes the node from position index. shifts elements 
        to the left.   Decrements size.
   	  @return the object at position index.
   	  */
       public Object remove(int index)
      {
      
      }
      /*returns the Objects in the array, nicely formatted, 
   	   e.g. [Apple, Banana, Cucumber, Date]
        	*/
       public String toString()
      {
      
      }
   }