   public class DLL_7_Garg
   {
      public static void main(String args[])
      {
         DLL list = new DLL();	
      
         list.addLast("Apple");
         list.addLast("Banana");
         list.addLast("Cucumber");
         list.addLast("Dumpling");
         list.addLast("Escargot");
         System.out.println(list);
         System.out.println(list.size());
         Object obj = list.remove(3);
         System.out.println(list);
         System.out.println(list.size());
         System.out.println("Removed "+ obj);
         System.out.print("Add at 3:   ");
         list.add(3,"Cheese");
         System.out.println(list);
         System.out.print("Add first:  ");
         list.addFirst("Anchovie");
         System.out.println(list);
         System.out.println(list.size());
      }
   }
 
   class DLL       
   {
      private int size;
      private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
      public int size()
      {
         return size;
      }
    	/* appends obj to end of list; increases size;
   	  @return true  */
      public boolean add(Object obj)
      {
         addLast(obj);
         size++;
         return true;
      }
      /* inserts obj at position index.  increments size. 
   		*/
      public void add(int index, Object obj)
      {
         if(size==0)
         {
            head.setNext(new DLNode(obj, head, head));
         }
         else
         {
            DLNode point = head;
            for(int x = 0; x < index-1; x++)
            {
               point = point.getNext();
            }
            DLNode node = new DLNode(obj, point, point.getNext());
            point.setNext(node);
         }
         size++;
      }
      /* return obj at position index.  
   		*/
      public Object get(int index)
      {
         for(int x = 1; x <= index; x++)
         {
            head = head.getNext();
         }
         Object obj = head.getValue();
         return obj;
      }
    /* replaces obj at position index.  
   		*/
      public void set(int index, Object obj)
      {
         for(int x = 1; x <= index; x++)
         {
            head = head.getNext();
         }
         head.setValue(obj);
      
      }
    /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
      public Object remove(int index)
      {
         if(size == 0)
         {
            head.setNext(null);
         }
         DLNode point = head;
         for(int x = 1; x <= index; x++)
         {
            point = point.getNext();
         }
         point.getPrev().setNext(point.getNext());
         point.getNext().setPrev(point.getPrev());
         Object obj = point.getValue();
         size--;
         return obj;     
      }
    /* inserts obj at front of list; increases size;
   	  */
      public void addFirst(Object obj)
      {
         add(1, obj);
      }
   	/* appends obj to end of list; increases size;
   	    */
      public void addLast(Object obj)
      {
         add(size + 1, obj);
      }
      public Object getFirst()
      {
         return head.getNext().getValue();
      }
      public Object getLast()
      {
         while(head.getNext() != head)
         {
            head = head.getNext();
         }
         return head;
      }
      public Object removeFirst()
      {
         return remove(1);
      }
      public Object removeLast()
      {
         return remove(size - 1);      
      }
      public String toString()
      {
         String str = "";
         DLNode point = head.getNext();
         for(int x = 0; x< size; x++)
         {
            str += point.getValue() + " ";
            point = point.getNext();
         }         
         return "[" + str + "]";
      }
   }
	
	///////////////////////////////////////

	  
   class DLNode 
   {
      private Object value;
      private DLNode prev;
      private DLNode next;
      public DLNode(Object arg, DLNode p, DLNode n)
      {
         value=arg;
         prev=p;
         next=n;
      }
      public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
      public void setValue(Object arg)
      {
         value=arg;
      }
      public void setNext(DLNode arg)
      {
         next=arg;
      }
      public void setPrev(DLNode arg)
      {
         prev=arg;
      }
      public DLNode getNext()
      {
         return next;
      }
      public DLNode getPrev()
      {
         return prev;
      }
      public Object getValue()
      {
         return value;
      }
   }
