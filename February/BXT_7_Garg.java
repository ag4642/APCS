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
         Stack<TreeNode> stack = new Stack<TreeNode>(); 
         StringTokenizer token = new StringTokenizer(str); 
         while(token.hasMoreTokens()) 
         { 
            String temp = token.nextToken(); 
            if(!isOperator(temp)) 
            { 
               stack.push(new TreeNode(temp)); 
            } 
            else 
            { 
               TreeNode tree1 = (TreeNode)stack.pop(); 
               TreeNode tree2 = (TreeNode)stack.pop(); 
               TreeNode tree = new TreeNode(temp, tree2, tree1); 
               stack.push(tree); 
            } 
         } 
         root = (TreeNode)stack.pop();
      }      
      public double evaluateTree()
      {
         return evaluateNode(root);
      }
      private double evaluateNode(TreeNode root)  //recursive
      {
         if(isOperator((String)root.getValue()))
         {
            return computeTerm((String)root.getValue(), evaluateNode(root.getLeft()), evaluateNode(root.getRight()));
         }
         else
            return Double.parseDouble((String)root.getValue());
      }      
      private double computeTerm(String s, double a, double b)
      {
         if(s.equals("+"))
            return a + b;
         else if(s.equals("-"))
            return a - b;
         else if(s.equals("*"))
            return a * b;
         else
            return a / b;   
      }   
      private boolean isOperator(String s)
      {
         String str = "+-*/";
         return str.contains(s);
               
      }
      public void display()
      {
         TreeLab_7_Garg.display(root, 0);
      }
      public void preorderTraverse()
      {
         TreeLab_7_Garg.preorderTraverse(root);
      }
      public void inorderTraverse() 
      { 
         TreeLab_7_Garg.inorderTraverse(root);
      } 
   }
	
	/*******************
	Driver for a binary expression tree class.
	Input: a postfix string, eas token separated by a space.
	**********************/
   public class BXT_7_Garg
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
	
