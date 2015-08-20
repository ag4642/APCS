    
   import java.util.*;
   import java.io.*;
   import javax.swing.JOptionPane;
	
   public class Josephus
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         Scanner names = new Scanner(new File("J_names.txt"));
         Scanner scan = new Scanner(new File("numbers.txt")); //Scanner with names
         int[] fakeArray = new int[123]; //New int Array of unscathed value
         String[] strFakeArray = new String[123]; //New String array of unscathed value
      	
         int q = 0; //Arbitrary value to get size of array
         while(scan.hasNextInt())
         {
            fakeArray[q] = scan.nextInt(); //Fills fake array
            strFakeArray[q] = names.next(); //Fills String fake array
            q++; //Increments array value q
         }
         int[] numArray = new int[q]; //q == array size
         String[] nameArray = new String[q]; //Read comment above
      	
         for(int i = 0; i < numArray.length; i++) //Fills real arrays
         {
            numArray[i] = fakeArray[i]; //Integer array
            nameArray[i] = strFakeArray[i]; //String array
         }
      		
         Scanner input = new Scanner(System.in);
         ListNode linkedList = null; //Null linked list
      	
         System.out.print("Enter the list size: "); //Friendly prompt
         int size = input.nextInt(); //Gets size from Scanner input
         System.out.print("Enter the value N: ");
         int n = input.nextInt(); //Get value N
      	
         for(int i = 0; i < size; i++)
         {
            if(linkedList == null) //Iff null, give it a value
            {
               linkedList = new ListNode(numArray[i], linkedList);
               linkedList.setNext(linkedList);
            }
            else
               linkedList = insert(linkedList, numArray[i]); //Else, insert more values
         }	
         print(linkedList);
      	
         ListNode temp = linkedList;
      	
         while(temp.getNext() != temp)
            temp = remove(temp, n-1); //n-1 for getNext()s
      		
         int loc = (Integer)temp.getValue(); //Fetches integer value
      	//System.out.println(loc); //The value is equal to the position
      	
         ListNode strList = null; //Null name lsit
      	
         for(int i = 0; i < size; i++)
         {
            if(strList == null) //Iff null, give it a value
            {
               strList = new ListNode(nameArray[i], strList);
               strList.setNext(strList);
            }
            else
               strList = insert(strList, nameArray[i]); //Else, insert more values
         }
      	
         replaceAt(strList, "Josephus", loc); //Replaces winning node with Josephus
      	
         System.out.println("***\tNow start all over.\t***");
         print(strList);
         ListNode temp2 = strList;
      	
         while(temp2.getNext() != temp2)
            temp2 = remove(temp2, n-1); //n-1 for getNext()s
      
      
      }
   	
      /* removes the node p after counting n nodes.
   	  */      
      private static ListNode remove(ListNode p, int n)
      {
         ListNode head = p; //Pointer to p, holds current position of p
         for(int i = 0; i < n; i++)
            head = head.getNext(); //Changes current array position by n nodes
         if(head.getNext() == p) //If at the final node of the circle
         {
            ListNode next = head.getNext().getNext(); //Moves to the next node
            head.setNext(next); //Sets head at the next node
            p = head; //Main ListNode is equal to pointer head
            print(head); //Prints head
         }
         
         else //If not at the final node
         {
            ListNode next = head.getNext().getNext();
            head.setNext(next);
            print(head);
         }
         return head; //Returns the new list
      }
   	
      /* prints the circular linked list.
   	  */      
      public static void print(ListNode p)
      {
         if(p == null) //Likely not going to be null
            System.out.print("[]"); //unless a FileNotFoundException is thrown
         else
         {
            ListNode temp = p.getNext(); //Pointer to the next position of p
            while(temp != p) //While the pointer does not equal p
            {
               System.out.print(temp.getValue() + " "); //Prints position # and \s
               temp = temp.getNext(); //Get next temp to continue the loop
            }
            System.out.println(temp.getValue() + "");
         }
      }
   	
    /* helper method to build the list.  Creates the node, then
       inserts it in the circular linked list.
   	 */  
      private static ListNode insert(ListNode p, Object obj)
      {
         ListNode temp = new ListNode(obj, p.getNext()); //Object Integer or String, reference to itself
         p.setNext(temp); //Sets the next p to temp
         p = temp; //Makes p equal to temp
         return p;
      }
   
   	
   	/* replaces the value (the string) at the winning node.
          */	
      private static void replaceAt(ListNode p, Object obj, int pos)
      {
         ListNode temp = p; //Pointer for the real strList
         for(int i = 0; i < pos; ++i) //Moves to the position to alter
            temp = temp.getNext();
         temp.setValue(obj);
      	//p.getNext(temp);
         p = temp;
      }
   }