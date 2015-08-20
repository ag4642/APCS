   //Name:      Date:
   import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
		Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from TreeLab).  Prompt the user for a target and delete that node, if it
	exists. 
	*****************************************************************/
    public class BinarySearchTreeDelete_shell
   {
       public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("Input string: ");
         String s = sc.nextLine();
 										//Case 1:  		ECSBPWANR 
										//Case 2a:  	SNTPOR    
      								//Case 2b:	   HBRNVJSZIK  
      								//Case 3.a.i:  DBNACFSEJHM 
      								//Case 3.a.ii: NFSAKPXGQ 
										//Case 3b:     RNVGPCAE  
         TreeNode t = null;
         for(int x = 0; x<s.length(); x++)
            t = insert(t, s.substring(x, x+1));
         display(t, 0);
      
         System.out.print("Delete? ");
         String target = sc.next();
         if(delete(t, target))
            System.out.println("\n" + target+" deleted.");
         else
            System.out.println("\n" + target+" not found");
         display(t, 0);        
      }
      
       public static TreeNode insert(TreeNode t, String s)
      {  	
         return null;
      }
      
       public static void display(TreeNode t, int level)
      {
         if(t == null)
            return;
         display(t.getRight(), level + 1); //recurse right
         for(int k = 0; k < level; k++)
            System.out.print("\t");
         System.out.println(t.getValue());
         display(t.getLeft(), level + 1); //recurse left
      }
   
       private static boolean delete(TreeNode current, Object target)
      {
         TreeNode parent = null;
         int compare = ((Comparable)target).compareTo(current.getValue());
      	//your code goes here  <<-------
      
		
		
			
      
      
         return false;  //never reached
      }
   }