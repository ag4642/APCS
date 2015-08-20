   import java.util.Scanner;
   public class ListLab1_7_Garg
   {
      public static void main(String[] args)
      {
         ListNode head = new ListNode("hello", null);
         head = new ListNode("foo", head);
         head = new ListNode("boo", head);
         head = new ListNode("nonsense", head);
         head = new ListNode("computer",
            	new ListNode("science",
            		new ListNode("java",
            			new ListNode("coffee", head)
            		)
            	)
            );
         print(head);
         
         System.out.println("First = " + first(head));
         System.out.println("Second = " + second(head));
         ListNode p = pointerToLast(head);
         System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
         ListNode c = copyOfLast(head);
         System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
      	 	
         Scanner in = new Scanner(System.in);
         System.out.print("Insert what? ");
         String x = in.next();
         head = insertFirst(head, x);
         head = insertLast(head, x);
         print(head);
      }
      public static void print(ListNode head)
      {
         System.out.print("[");
         while(head != null)
         {
            System.out.print(head.getValue());
            head = head.getNext();
            if(head != null)
               System.out.print(", ");
         }
         System.out.println("]");
      }
      public static Object first(ListNode head)
      {
         if(head  == null)
            return null;
         else
            return head.getValue(); 
      }
      public static Object second(ListNode head) 
      {
         if(head == null)
         {
            return null;
         }
         else
            return head.next.getValue();
      
      }
      public static ListNode pointerToLast(ListNode head) 
      {
         if(head == null)
         {
            return null;
         }
         while(head.getNext() !=null)
         {
            head = head.getNext();
         }
         return head;
      }
      public static ListNode copyOfLast(ListNode head) 
      {
         if(head == null)
         {
            return null;
         }
         while(head.getNext() !=null)
         {
            head = head.getNext();     
         }    
         ListNode copy = new ListNode(head.getValue(), null);                     
         return copy;     
      }
      public static ListNode insertFirst(ListNode head, Object arg) 
      {
         ListNode node = new ListNode(arg, head);
         return node;
      }
      public static ListNode insertLast(ListNode head, Object arg) 
      {
         ListNode temp = new ListNode(arg, null);
         pointerToLast(head).setNext(temp);
         return head;
      }
   }
   class ListNode
   {
      public Object value;
      public ListNode next;
      public ListNode(Object v, ListNode n)
      {
         value=v;
         next=n;
      }
      public Object getValue()
      {
         return value;
      }
      public ListNode getNext()
      {
         return next;
      }
      public void setValue(Object newv)
      {
         value=newv;
      }
      public void setNext(ListNode newn)
      {
         next=newn;
      }
   }