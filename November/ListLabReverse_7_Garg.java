   public class ListLabReverse_7_Garg
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
            new ListNode("coffee", head))));
            
         System.out.print("original: \t\t");
         ListLab1_7_Garg.print(head);
         
         System.out.print("printReverse: \t");
         printReverse(head);
      
         System.out.println();
         System.out.print("original: \t\t");
         ListLab1_7_Garg.print(head);
              
         System.out.print("reverse with 2 pointers:");
         head = reverse(null, head);
         ListLab1_7_Garg.print(head);
      		       	
         System.out.print("iterative reverse:\t");
         head = reverseIterate(head);
         ListLab1_7_Garg.print(head);
      				         
         System.out.print("reverse in place \t");
         head = reverseInPlace(head);
         ListLab1_7_Garg.print(head);
      	
         System.out.print("reverse a linked list \t");
         head = reverseLL(head);
         ListLab1_7_Garg.print(head);
      
      //          System.out.print("Mind Bender reverse\t");
      //          head = mindBender(head);
      //          ListLab1.print(head);
      }
   	/*********************************************
   	These two methods don't reverse the list.  They only print out
   	the list in reverse order.  printReverse() prints the square 
   	brackets and calls helper().  helper() is recursive.
   	********************************************************/
      public static void printReverse(ListNode h)
      {
         System.out.print("	[");
         helper(h);
         System.out.print("]");
      }  
      
      private static void helper(ListNode p)
      {
         ListNode node = p;
         if(node.getNext() != null)
         {
            helper(node.getNext());
         }
         System.out.print(node.getValue() +", ");
      }
   
      /*********************************************
   	This iterative method (for or while) produces a copy of the 
   	reversed list.	 For each node going forward, make a new node and 
   	link it to the list.	The list will naturally be in reverse. 
   	***********************************************************/
      public static ListNode reverseIterate(ListNode head)
      {
         ListNode node = null;
         while(head != null)
         {
            node = new ListNode(head.getValue(), node);
            head = head.getNext();
         }
         return node;
      }     
          
      /*******************************************
   	This iterative method (while) uses 3 pointers to reverse 
   	the list in place.   The two local pointers are called
   	prev and next.
      ********************************************************/
      public static ListNode reverseInPlace(ListNode head)
      {
         if(head == null)
         {
            return null;
         }
         ListNode prev = null;
         ListNode next = head;
         while(head != null)
         {
            next = next.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
         }
         return prev;
      }
      	
   	/**************************************************
   	This method uses two pointers as arguments to reverse 
   	the list in place. It is recursive.
   	*********************************************************/
      public static ListNode reverse(ListNode prev, ListNode head)
      {
         if(head.getNext() == null)
         {
            head.setNext(prev);
            return head;
         }
         ListNode node = reverse(head, head.getNext());
         head.setNext(prev);
         return node;
      } 
   	/**********************************************
   	Each time, do pointerToLast() and nextToLast(), and link (append())
   	them together.  ReverseLL is recursive.
   	********************************************************/
      public static ListNode reverseLL(ListNode head)
      {
         if(head.getNext() == null)
            return null;
         ListNode node = append(nextToLast(head), pointerToLast(head));
         reverseLL(head);
         return node;
      }
      private static ListNode pointerToLast(ListNode head)
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
      private static ListNode nextToLast(ListNode head)
      {
         while(head.getNext().getNext() != null)
         {
            head = head.getNext();
         }
         return head;
      }
      private static ListNode append(ListNode h1, ListNode h2)
      {
         h2.setNext(h1);
         h1.setNext(null);
         return h2;
      }
       /**********************************************
      This difficult method reverses the list in place, using one
      local pointer. Start with pointerToLast(). The helper method
      is recursive.
   	********************************************************/
   //        public static ListNode mindBender(ListNode head)
   //       {
   //          ListNode temp = pointerToLast(head);
   //          mindBenderHelper(head);
   //          head.setNext(null);
   //          return temp;
   //       }
   //        public static void mindBenderHelper(ListNode head)
   //       {
   //   
   //       }
     
   }