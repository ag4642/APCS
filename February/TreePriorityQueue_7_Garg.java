   //name:      date:   
   public class TreePriorityQueue_7_Garg
   {
      public static void main(String[] args)
      {
         TreePriorityQueue tpq = new TreePriorityQueue();
         int[] array = {13, 11, 14, 11, 15, 14, 14};
       //	int[] array = {4, 6, 5, 7}; 
      //  int[] array = {7, 6, 4, 5}; 
         //int[] array = {7, 6, 4, 5, 4, 4};
      //   int[] array = {4, 5, 4, 4, 7, 6, 7, 7};
        
         for( int x : array )
            tpq.add(x);       
         System.out.println("Peek min: " + tpq.peekMin());
         System.out.println("Removing");
         while( !tpq.isEmpty() )
            System.out.println( "     " + tpq.removeMin() );
      }
   }

   class TreePriorityQueue
   {
      private TreeNode root;
   
      public TreePriorityQueue()
      {
         root = null;
      }
   
      public boolean isEmpty()
      {
         return root == null;
      }
   
      public void add(Object obj)
      {
         root = addHelper((Comparable)obj, root);
      }
   
      private TreeNode addHelper(Comparable obj, TreeNode t)
      {
         if(t == null)
         {
            return new TreeNode(new Item(obj));
         }
         Item item = (Item)t.getValue();  
         int compareValue = item.getData().compareTo(obj);
         if(compareValue == 0)
         {
            item.incrementCount();
         }
         else if(compareValue > 0)
         {
            t.setLeft(addHelper(obj,t.getLeft()));
         }
         else 
         {
            t.setRight(addHelper(obj,t.getRight()));
         }
         return t;
      }
   
      public Object removeMin()
      {
         TreeNode t = root;
         TreeNode ti = root;
         Object x;
         if(t.getLeft()==null)
         {
            root = t.getRight();
            return t.getValue();
         }
         if(t.getLeft()!=null)
            t = t.getLeft();
         while(t.getLeft()!=null)
         {
            t=t.getLeft();
            ti = ti.getLeft();
         }
         x = t.getValue();
         ti.setLeft(t.getRight());
         return x;
      
      }
      public Object peekMin()
      {
         TreeNode current = root;
         while(current.getLeft() != null)
         {
            current = current.getLeft();
         }
         Item item = (Item)current.getValue();
         return item.getData();
      }
   }
  
   class Item
   {
      private Comparable data;
      private int count;
      public Item(Comparable d)
      {  
         data = d; 
         count = 1;  
      }
      public void incrementCount()
      {	
         count++; 
      }
      public void decrementCount()
      {  
         count--;  
      }
      public int getCount()
      {	
         return count;  
      }
      public Comparable getData()
      {  
         return data;  
      }
      public String toString()
      {
         return "[ " + data + " | " + count + " ]";
      }
   }