   import java.util.Scanner;
   import java.io.*;
   public class deHuffman_7_Garg
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
         TreeNode root = new TreeNode(null);
         TreeNode current = root;
         while(huffLines.hasNextLine())
         {
            current = root;
            String s = huffLines.nextLine();
            if(s.length() != 0) 
            {
               String character = s.substring(0,1);
                  
               for(int x = 0; x < s.substring(1, s.length()).length() - 1; x++) 
               {
                  if(s.substring(1, s.length()).substring(x, x+1).equals("0"))
                  {
                     if(current.getLeft() == null)
                     {
                        current.setLeft(new TreeNode(null, null, null));
                     }
                     current = current.getLeft();
                  }
                  else 
                  {
                     if(current.getRight() == null) 
                     {
                        current.setRight(new TreeNode(null, null, null));
                     }
                     current = current.getRight();
                  }
               }   
               if(s.substring(1, s.length()).substring(s.substring(1, s.length()).length() - 1, s.substring(1, s.length()).length()).equals("0"))
               {
                  current.setLeft(new TreeNode(character, null, null));
               }
               else 
               {
                  current.setRight(new TreeNode(character, null, null));
               }
            }
         } 
         return root;     
      }      
      public static String dehuff(String text, TreeNode root)
      {
         String s = "";
         TreeNode t = root;
         for(int x = 1; x <= text.length(); x++)
         {
            if(Integer.parseInt(text.substring(x - 1, x)) == 0)
            {
               t = t.getLeft();
            }
            else
            {
               t = t.getRight();
            }
            if(t.getValue() != null)
            {
               s += t.getValue();
               t = root;
            }  
         }
         return s;
      }
   }