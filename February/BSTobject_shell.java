 //name:    date:  
   import java.util.*;
   import java.io.*;
    public class BSTobject_shell
   {
       public static void main( String[] args ) throws Exception
      {
         BSTobject<String> tree = new BSTobject<String>("F");
         System.out.print(tree);
            		//	System.out.print(tree.toString());
         System.out.println(tree.size());
         System.out.println(tree.isEmpty()); 
      }
   }
   	////////////////////////////////
    class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
   {
      // 2 fields 
      // 2 constructors, one default and one one-arg
      
      
      //methods
      
      
      
      /***************************private inner class **************/  
       private class Node<E>
      {
         // 2 fields 
         
         // 2 constructors, one default and one one-arg
         
         
         
         
         //methods--Use TreeNode as an example
         
         
      }
   }
	//////////////////////////////////
    interface BSTinterface<E extends Comparable<E>>
   {
       public E add( E element );     //returns the object
       public boolean contains( E element );
       public boolean isEmpty();
       public E remove( E element );  //returns the object
       public int size();
       public String toString();
   }
//////////////////////////////////