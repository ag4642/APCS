   import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
		Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from Lab01).  Prompt the user for a target and search the tree 
	for it.  Display the tree's minimum and maximum values.  Print 
	the data in order from smallest to largest.
	*****************************************************************/
   public class BinarySearchTree_7_Garg
   {
      public static void main(String[] args)
      {   
         System.out.println("Input String");
         Scanner sc = new Scanner(System.in);
         String s = sc.next(); 
         TreeNode tree = new TreeNode(s);
         for(int pos = 0; pos < s.length(); pos++)
            insert(tree, s.charAt(pos) + ""); 
         display(tree, 0);   	
         System.out.println("Min Value " + min(tree));
         System.out.println("Max Value = " + max(tree));
         System.out.println("Input target");   
         Scanner sca = new Scanner(System.in);
         String target = sca.next();
         System.out.println("Find Target = " + find(tree, target));
           
      }
   	/**************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************/
      public static TreeNode insert(TreeNode t, String s)
      {  
         if(t == null)
            return new TreeNode(s);
         else if((s.compareTo((String)t.getValue()) < 0))
            t.setLeft(insert(t.getLeft(), s));
         else if((s.compareTo((String)t.getValue()) > 0))
            t.setRight(insert(t.getRight(), s));
      
         return t;	
            
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
   	/********************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
   .    	*****************************/    
      public static boolean find(TreeNode t, Comparable x)
      {
         TreeNode p = t;
         if(p == null)
            return false;
         if(x.compareTo((Comparable)p.getValue()) < 0)
            return find(t.getLeft(), x);
         if(x.compareTo((Comparable)p.getValue()) > 0)
            return find(t.getRight(), x);
         return true;
      }
      /**************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	******************************/
      public static Object min(TreeNode t)
      {
         if(t == null)
            return null;
         while(t.getLeft() != null)
            t = t.getLeft();
         return t.getValue();
      }
      /*****************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
   	********************/
      public static Object max(TreeNode t)
      {
         if(t == null)
            return null;
         else if(t.getRight() != null)
                 
            return max(t.getRight());
         return t.getValue(); 
      }
      public static void smallToLarge(TreeNode t)
      {
         if( t != null )
         {
            smallToLarge( t.getLeft() );
            System.out.println( "" + t.getValue() );
            smallToLarge( t.getRight() );
         }
      }
   }