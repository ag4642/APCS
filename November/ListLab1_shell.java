  //your name and date
  //import java.util.Scanner;
    public class ListLab1_shell
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
         print(head);
         
         /**** uncomment the code below for ListLab1 Extension  ****/
         
      	// System.out.println("First = " + first(head));
         // System.out.println("Second = " + second(head));
         // ListNode p = pointerToLast(head);
         // System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
         // ListNode c = copyOfLast(head);
         // System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
      	// 	
         // Scanner in = new Scanner(System.in);
         // System.out.print("Insert what? ");
         // String x = in.next();
         // head = insertFirst(head, x);
         // head = insertLast(head, x)
         // print(head);
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
   }
