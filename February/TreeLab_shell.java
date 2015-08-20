   import java.util.*;         //for the queue interface
    public class TreeLab_shell
   {
       public static void main(String[] args)
      {
         String s = "XCOMPUTERSCIENCE";
			//String s = "XThomasJeffersonHighSchool";
         TreeNode root = new TreeNode("" + s.charAt(1), null, null);
         for(int pos = 2; pos < s.length(); pos++)
            insert(root, "" + s.charAt(pos), pos, 
               (int)(1 + Math.log(pos) / Math.log(2)));
      
         insert(root, "A", 17, 5); 
         insert(root, "B", 18, 5); 
         insert(root, "C", 37, 6); //B's right child
      
         display(root, 0);
      
         System.out.print("\nPreorder: ");
         preorderTraverse(root);
         System.out.print("\nInorder: ");
         inorderTraverse(root);
         System.out.print("\nPostorder: ");
         postorderTraverse(root);
      
         System.out.println("\n\nNodes = " + countNodes(root));
         System.out.println("Leaves = " + countLeaves(root));
         System.out.println("Grandparents = " + countGrands(root));
         System.out.println("Only childs = " + countOnlys(root));	
      
         System.out.println("\nDepth = " + depth(root));
         System.out.println("Height = " + height(root));
         System.out.println("Width = " + width(root));
         System.out.println("Min = " + min(root));
         System.out.println("Max = " + max(root));	
      
         System.out.println("\nBy Level: ");
         displayLevelOrder(root);
      }
       public static void insert(TreeNode t, String s, int pos, int level)
      {
         TreeNode p = t;
         for(int k = level - 2; k > 0; k--)
            if((pos & (1 << k)) == 0)
               p = p.getLeft();
            else
               p = p.getRight();
         if((pos & 1) == 0)
            p.setLeft(new TreeNode(s, null, null));
         else
            p.setRight(new TreeNode(s, null, null));
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
       public static void preorderTraverse(TreeNode t)
      {
         if(t == null)
            return;
         System.out.print(t.getValue() + " ");  //preorder visit
         preorderTraverse(t.getLeft());         //recurse left
         preorderTraverse(t.getRight());        //recurse right
      }
       public static void inorderTraverse(TreeNode t)
      {
        
         
      	       						 		//recurse left
            				 					//inorder visit
                								//recurse right
      }
       public static void postorderTraverse(TreeNode t)
      {
        
        
                    							//
             									//
         										//
      }
       public static int countNodes(TreeNode t)
      {
         return -1;
      }
       public static int countLeaves(TreeNode t)
      {
         return -1;
      }
       public static int countGrands(TreeNode t)
      {
         return -1;
      }
       public static int countOnlys(TreeNode t)
      {
         return -1;
      }
       public static int depth(TreeNode t)
      {
         return -1;
      }
       public static int height(TreeNode t)
      {
         return -1;
      }
      /* "width" is the longest path from leaf to leaf */
       public static int width(TreeNode t)
      {
         return -1;
      }
       public static Object min(TreeNode t)
      {
         return null;
      }
       public static Object max(TreeNode t)
      {
         return null;
      }
      /* this method is not recursive.  Use a local queue
   	to store the children of the current node.*/
       public static void displayLevelOrder(TreeNode t)
      {
      
      }
   }
   /***************************************************
	  
      ----jGRASP exec: java Lab01
    
    			E
    		E
    			C
    	M
    			N
    		T
    			E
    C
    			I
    		U
    			C
    	O
    			S
    					C
    				B
    		P
    				A
    			R
    
    Preorder: C O P R A S B C U C I M T E N E C E 
    Inorder: R A P B C S O C U I C E T N M C E E 
    Postorder: A R C B S P C I U O E N T C E E M C 
    
    Nodes = 18
    Leaves = 8
    Grandparents = 5
    Only childs = 3
    
    Depth = 6
    Height = 5
    Width = 8
    Min = A
    Max = U
    
    By Level: 
    COMPUTERSCIENCEABC
   
    *******************************************************/
	  /* TreeNode class for the AP Exams */

    class TreeNode
   {
      private Object value; 
      private TreeNode left, right;
   
       public TreeNode(Object initValue)
      { 
         value = initValue; 
         left = null; 
         right = null; 
      }
   
       public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
       public Object getValue()
      { 
         return value; 
      }
   
       public TreeNode getLeft() 
      { 
         return left; 
      }
   
       public TreeNode getRight() 
      { 
         return right; 
      }
   
       public void setValue(Object theNewValue) 
      { 
         value = theNewValue; 
      }
   
       public void setLeft(TreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
       public void setRight(TreeNode theNewRight)
      { 
         right = theNewRight;
      }
   }
