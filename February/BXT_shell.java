   //Name:      Date:
   import java.util.*;

 	/***********************************
	Represents a binary expression tree.
	The BXT can build itself from a postorder expression.  It can
	evaluate and print itself. It also prints an inorder string and a preorder string.  
	************************************/
    class BXT
   {
      private int count;
      private TreeNode root;
   
       public BXT()
      {
         count = 0;
         root = null;
      }
       public BXT(Object obj)
      {
         count = 1;
         root = new TreeNode(obj, null, null);
      }
      /***********************
   	Builds a BXT from a postfix expression.  Uses a helper stack of TreeNodes.
   	****************************/
       public void buildTree(String str)
      {
         //enter code here
      }
       public double evaluateTree()
      {
         return evaluateNode(root);
      }
       private double evaluateNode(TreeNode root)  //recursive
      {
          //enter code here
      }
       private double computeTerm(String s, double a, double b)
      {
          //enter code here
      }
       private boolean isOperator(String s)
      {
          //enter code here
      }
     //display() from TreeLab01
   	 
     // inorder traverse
   	 
     // preorder traverse
   }
	
	/*******************
	Driver for a binary expression tree class.
	Input: a postfix string, each token separated by a space.
	**********************/
    public class BXT_shell
   {
       public static void main(String[] args)
      {
         BXT tree = new BXT();
         Scanner sc = new Scanner(System.in);
         System.out.print("Input postfix string: ");
         String s =  sc.nextLine();   // 14 -5 / ,   3 4 5 + *  ,  2 3 + 5 / 4 5 - *
         tree.buildTree(s);
         tree.display();
         System.out.print("Infix order:  ");
         tree.inorderTraverse();
         System.out.print("\nPrefix order:  ");
         tree.preorderTraverse();
         System.out.print("\nEvaluates to " + tree.evaluateTree());
      }
   }
	
