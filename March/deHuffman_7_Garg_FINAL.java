   import java.util.Scanner;
   import java.io.*;
   public class deHuffman_7_Garg_FINAL
   {
      public static void main(String[] args) throws IOException
      {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter message to decode");
         String s = sc.next();
         Scanner infile = new Scanner(new File("message." + s + ".txt"));
         System.out.println("Enter scheme");
         String s2 = sc.next();
         Scanner scheme = new Scanner(new File("scheme." + s2 + ".txt"));
         TreeNode node = huffmanTree(scheme);   
         System.out.println("" + dehuff(infile.next(), node));
      }
      public static TreeNode huffmanTree(Scanner huffLines)
      {
         TreeNode head = new TreeNode(null);
         while(huffLines.hasNext())
         {
            
            String str = huffLines.nextLine();
            String character = str.substring(0,1);
            str = str.substring(1);
            TreeNode tree = head;
            while(str.length() != 0)
            {
               if(str.substring(0,1).equals("0"))
               {
                  if(tree.getLeft() == null)
                     tree.setLeft(new TreeNode(null));
                  tree = tree.getLeft();
                  str = str.substring(1);
               }
               else
               {
                  if(tree.getRight() == null)
                     tree.setRight(new TreeNode(null));
                  tree = tree.getRight();
                  str = str.substring(1);
               }	
            }
            tree.setValue(character);
         }
         return head;
      }      
      public static String dehuff(String text, TreeNode root)
      {
         String s = "";
         TreeNode tree = root;
         while(!text.equals(""))
         {
            if(text.substring(0,1).equals("0"))
            {
               tree = tree.getLeft();
               text = text.substring(1);
            }
            else
            {
               tree = tree.getRight();
               text = text.substring(1);
            }
            if(tree.getRight() == null && tree.getLeft() == null)
            {
               s += tree.getValue();
               tree = root;
            }
         }
         return s;
      }
   }