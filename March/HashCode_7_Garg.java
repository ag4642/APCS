   //name:            date:
	 /*  Assignment:  A simple hashing program is given below. Compile 
	 and run.  Notice that collisions occur.  You are to implement 
	 three different collision schemes, namely, linear probing, 
	 rehashing, and chaining.
	 */
   import java.util.*;
   public class HashCode_7_Garg
   {
      public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);  
         System.out.print("Enter the size of the array:  ");
         int arrayLength = keyboard.nextInt();       //20
         Hashtable table = new Hashtable(arrayLength);   
         System.out.print("\nEnter the number of items:  ");
         int numItems = keyboard.nextInt();          //15
         System.out.print("\nThe Load Factor is " + (double)numItems/arrayLength);
         System.out.println();
         for(int i = 0; i < numItems; i++)
            table.add("Item "+i);
         System.out.println();
         System.out.print("Search for:  Item ");
         int i = keyboard.nextInt();
         String key = "Item " + i; 
         if(!table.contains(key))
            System.out.println(key + " NOT found");
      }
   }
      
   class Hashtable
   {
      private int size;
      private Object[] table;
      public Hashtable(int numSlots)
      {
         size = numSlots;
         table = new Object[size];
      }
      public void add(Object obj)
      {
         int code = obj.hashCode();
         int index = Math.abs(code % size);
         if(table[index] == null)
         {
            table[index] = obj;
            System.out.println(obj + "\t" + code + "\t" + index);
         }
         else
         {
            System.out.println(obj + "\t" + code + "\tCollision at "+ index);
            //index = linearProbe(index);
            //index = rehash(index);
            obj = chaining(index, obj);
            table[index] = obj;
            System.out.println(obj + "\t" + code + "\t" + index);
         }
      }
      public boolean contains(Object obj)     //Big-O is O(____)
      {
         int index = Math.abs(obj.hashCode() % size);
         //you must implement searching for *each* collision strategy
         Object found = table[index];
         if(found.equals(obj))
         {
            System.out.println(obj + " at index " + index);
            return true;
         }
         else 
            return false;
      }
      public int linearProbe(int x)
      {
         for(int i = x; i < table.length; i++)
         {
            if(table[i] == null)
               x = i;
         }
         return x;
      }
      public int rehash(int x)
      {
         int hash = x;
         while(table[hash] != null)
            hash = Math.abs((hash+3) % size);
         return hash;
      }
      public ArrayList<Object> chaining(int x, Object obj)
      {
         ArrayList<Object> a = new ArrayList<Object>();
         ArrayList<Object> array = null;
         Object o = table[x];
         if(o instanceof ArrayList)
            array = (ArrayList<Object>)table[x];
         else
         {
            array = a;
            if(o != null)
               array.add(o);
         }
         array.add(obj);
         return array;
      }
   }