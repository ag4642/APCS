   import java.util.*;
   import java.io.*;
   public class BSTobject_7_Garg
   {
      public static void main( String[] args ) throws Exception
      {
         //BSTobject<String> tree = new BSTobject<String>("F");
         //System.out.println("Input String");
         //Scanner sc = new Scanner(System.in);
         //String s = sc.next();
         //BSTobject<String> tree = new BSTobject<String>(s);
         // for(int x = 0; x < s.length(); x++)
         // {
            // tree.add(s.charAt(x) + "");
         // }   
         Scanner sc = new Scanner( new File("widget.txt"));
         BSTobject<Integer> tree = new BSTobject<Integer>();
         while(sc.hasNextInt()){
         
            tree.insert(new Widget(sc.nextInt(), sc.nextInt()));   
         }
         //System.out.print(tree);
         System.out.print(tree.toString());
         System.out.println(tree.size());
         //System.out.println(tree.isEmpty()); 
      }
   }
   class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
   {
      private Node<E> root;
      private int mySize;
      public BSTobject()
      {
         root = null;
         mySize = 0;
      }      
      public BSTobject(E e)
      {
         root = new Node<E>(null, e, null);
         mySize = 1;
      }
      public boolean remove(Node<E> e)
      {
         return remove(root, e);
      }
      private boolean found = false;
      private boolean remove(Node<E> current, Object target)
      { 
         if(current == null)
            return false;
         System.out.println(current.toString());
         int compare = ((Comparable)target).compareTo(current.toString());
         if(compare == 0){
            if(isLeaf(current))
            {
               current = null;
               return true;
            }
            else
               if(current.getLeft() != null)
               {
                  String temp = (String)(current.toString());
                  current.setValue(current.getLeft().toString());
                  current.getLeft().setValue(temp);
                  return delete(current.getLeft(),target);
               }
               else{
                  String temp = (String)(current.toString());
                  current.setValue(current.getRight().toString());
                  current.getRight().setValue(temp);
                  return delete(current.getRight(),target);
               }
         }
         else
            if(compare < 0)
               return delete(current.getLeft(),target);
            else
               return delete(current.getRight(),target);
      }
      public boolean contains(Node<E> e)
      {
         if(root == null)
            return false;
         if(e.compareTo(root) > 0)
         {
            root = root.getRight();
            return contains(e);
         }
         else if(e.compareTo(root) < 0)
         {
            root = root.getLeft();
            return contains(e);
         }
         else if(root.compareTo(root) == 0)
         {
            return true;
         }
         return false;
      }
         // private String toString(Widget<E> t, int l)
      // {   
         // if(t != null)
         // {
            // s += toString(t.getRight(), l+1);
            // s += t.value.toString() + "\n";
            // s += toString(t.getLeft(), l+1);
         // }
         // return s;
      // }
      public String toString()
      {
         return display(root, 0);
      }
      private String res = "";
      private String display(Node<E> t, int level)
      {
         if(t == null)
            return "";
         
         display(t.getRight(), level + 1); //recurse right
         for(int k = 0; k < level; k++)
            res += "\t";
         res += t.toString() + "" + "\n";
         display(t.getLeft(), level + 1); //recurse left
         return res;
      }
   
      public int size()
      {
         return mySize;
      }
      public boolean isEmpty()
      {
         if(mySize == 0)
            return true;
         else
            return false;
      }
      public E add(E e)
      {
         return e;
      }
      private Node<E> insert(Node<E> t, E e)
      {  
         if(t == null)
            return new Node<E>(e);
         else if((e.compareTo(t.toString()) <= 0))
            t.setLeft(insert(t.getLeft(), e));
         else if((e.compareTo(t.toString()) > 0))
            t.setRight(insert(t.getRight(), e));
         return t;	
      }  
      public Node<E> insert(E e)
      {  
         if(root == null)
         {
            root = new Node<E>(e);
            mySize++;
            return e;
         }
         
         else if(((Comparable)e).compareTo((Comparable)root.getPounds()) <= 0)
         {
            root.setLeft(insert(root.getLeft(), e, o));
            mySize++;
         }
         else if(((Comparable)e).compareTo((Comparable)root.getPounds()) > 0)
         {
            root.setRight(insert(root.getRight(), e, o));
            mySize++;
         }	
         
         return e;
      }
   
      private Node<E> insert(Node<E> t, E s, E k)
      {
         if(t == null)
         {
            t = new Widget<E>(s, k);
         }
         
         else if(((Comparable)s).compareTo((Comparable)t.getPounds()) <= 0)
         {
            t.setLeft(insert(t.getLeft(), s, k));
         }
         else if(((Comparable)s).compareTo(t.getPounds()) > 0)
         {
            t.setRight(insert(t.getRight(), s, k));
         }	
         
         return t;
      } 
      private class Widget implements Comparable<Widget>
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
      /***************************private inner class **************/  
      private class Node<E>
      {
         private Node<E> left;
         private Node<E> right;
         private E value;
         private Node(E value)
         {
            this(null, value, null);
         }
         private Node(Node<E> lt, E v, Node<E> rt)
         {
            this.left = lt;
            this.value = v;
            right = rt;  
         } 
         public E toString()
         { 
            return value; 
         }
      
         public Node<E> getLeft() 
         { 
            return left; 
         }
      
         public Node<E> getRight() 
         { 
            return right; 
         }
      
         public void setValue(E theNewValue) 
         { 
            value = theNewValue; 
         }
      
         public void setLeft(Node<E> theNewLeft) 
         { 
            left = theNewLeft;
         }
      
         public void setRight(Node<E> theNewRight)
         { 
            right = theNewRight;
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
   }