   import java.io.*;
   import java.util.*;
   import javax.swing.JOptionPane;
	
   public class Josephus_7_Garg
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         Scanner names = new Scanner(new File("J_names.txt"));
         Scanner scanner = new Scanner(new File("numbers.txt")); 
         int[] array = new int[100]; 
         String[] array1 = new String[100];
         int z = 0;
         while(scanner.hasNextInt())
         {
            array[z] = scanner.nextInt();
            array1[z] = names.next(); 
            z++; 
         }
         int[] numArray = new int[z]; 
         String[] nameArray = new String[z]; 
         for(int i = 0; i < numArray.length; i++)
         {
            numArray[i] = array[i];
            nameArray[i] = array1[i];
         }
      		
         Scanner input = new Scanner(System.in);
         ListNode node1 = null; 
         System.out.print("Enter the list size: "); 
         int size = input.nextInt();
         System.out.print("Enter the value N: ");
         int n = input.nextInt(); 
         for(int i = 0; i < size; i++)
         {
            if(node1 == null) 
            {
               node1 = new ListNode(numArray[i], node1);
               node1.setNext(node1);
            }
            else
               node1 = insert(node1, numArray[i]);
         }	
         print(node1);
         ListNode node2 = node1;
         while(node2.getNext() != node2)
            node2 = remove(node2, n-1); 
      		
         int loc = (Integer)node2.getValue();
         ListNode strList = null; 
      	
         for(int i = 0; i < size; i++)
         {
            if(strList == null) 
            {
               strList = new ListNode(nameArray[i], strList);
               strList.setNext(strList);
            }
            else
               strList = insert(strList, nameArray[i]);
         }
         replaceAt(strList, "Josephus", loc); 
      	
         System.out.println("***\tNow start all over.\t***");
         print(strList);
         ListNode temp = strList;
      	
         while(temp.getNext() != temp)
            temp = remove(temp, n-1);
      }
   	
      /* removes the node p after counting n nodes.
   	  */      
      private static ListNode remove(ListNode p, int n)
      {
         ListNode head = p;
         for(int x = 0; x < n; x++)
         {
            head = head.getNext();
         }
         if(head.getNext() == p)
         {
            ListNode node = head.getNext().getNext();
            head.setNext(node);
            p = head;
            print(head);
         }
         else
         {
            ListNode node = head.getNext().getNext();
            head.setNext(node);
            print(head);
         }  
         return head;
      }
      	
      /* prints the circular linked list.
   	  */      
      public static void print(ListNode p)
      {
         if(p == null)
         {
            System.out.println("[]");
            return;
         }
         else
         {
            ListNode node = p.getNext();
            while(node != p)
            {
               System.out.print(node.getValue() + " ");
               node = node.getNext();
            }
            System.out.println(node.getValue() + "");
         }	
      }
   	
    /* helper method to build the list.  Creates the node, then
       inserts it in the circular linked list.
   	 */  
      private static ListNode insert(ListNode p, Object obj)
      {
         ListNode node = new ListNode(obj, p.getNext());
         p.setNext(node);
         p = node;
         return p;
      }
   	
   	/* replaces the value (the string) at the winning node.
          */	
      private static void replaceAt(ListNode p, Object obj, int pos)
      {
         ListNode node = p;
         for(int x = 0; x < pos; x++)
         {
            node = node.getNext();
         }
         node.setValue(obj);
         p = node;   
      }
   }