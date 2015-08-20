   import java.io.*;
   import java.util.*;
   public class Huffman_7_Garg
   {
      public static void main(String[] args) throws IOException
      {
         Scanner keyboard = new Scanner(System.in);
         System.out.println ("Enter string: ");
         String string = keyboard.nextLine();
         TreeMap<String,Integer> map = new TreeMap<String,Integer>();
         for(int x = 0; x < string.length();x++)
         {
            if(!map.containsKey(string.substring(x,x+1)))
            {
               map.put(string.substring(x,x+1),1);
            }
            else
            {
               int i = map.get(string.substring(x,x+1))+1;
               map.put(string.substring(x,x+1),i);
            }
         }
         FileOutputStream scheme = new FileOutputStream("scheme." + string + ".txt");
         FileOutputStream message = new FileOutputStream("message." + string + ".txt");
         PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
         for(String key:map.keySet())
         {
            pq.add(new HuffmanTreeNode(key,map.get(key),null,null));
         }
         while(pq.size() != 1)
         {
            HuffmanTreeNode tn1 = pq.remove();
            HuffmanTreeNode tn2 = pq.remove();
            HuffmanTreeNode tn3 = new HuffmanTreeNode("*",tn1.getValue()+tn2.getValue(),tn1,tn2);
            pq.add(tn3);
         }
         String s = toHuff(string, pq.peek(), map);
         System.out.println(s);
      }
      public static String toHuff(String s, HuffmanTreeNode tree, TreeMap<String, Integer> map)
      {
         String temp = "";
         for(int a = 0; a < s.length();a++)
         {
            toHuff(s.substring(a,a+1),"",tree,map.get(s.substring(a,a+1)));
         }
         return temp;
      }
      public static String toHuff(String target, String answer, HuffmanTreeNode tree, int freq)
      {
         String temp = "";
         if(tree == null)
         {
            return "";
         }
         if(tree.getValue()==freq && tree.getKey().equals(target))
         {
            return answer;
         }
         if(tree.getValue()==freq)
         {
            return "";
         }
         temp = toHuff(target,answer,tree.getRight(),freq);
         answer+=temp;
         temp = toHuff(target,answer,tree.getLeft(),freq);
         answer+=temp;
         if(temp.equals(""))
         {
            return temp;
         }
         return answer;
      }
   }
   class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
   {
      private int frequency;
      private String key;
      private HuffmanTreeNode left, right;
      
      public HuffmanTreeNode(String keyValue, int initValue, HuffmanTreeNode initLeft, HuffmanTreeNode initRight)
      { 
         frequency = initValue; 
         left = initLeft; 
         right = initRight; 
         key = keyValue;
      }
   
      public int getValue()
      { 
         return frequency; 
      }
   
      public HuffmanTreeNode getLeft() 
      { 
         return left; 
      }
   
      public HuffmanTreeNode getRight() 
      { 
         return right; 
      }
   
      public String getKey()
      {
         return key;
      }
        
      public void setLeft(HuffmanTreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
      public void setRight(HuffmanTreeNode theNewRight)
      { 
         right = theNewRight;
      }
      
      public void setKey(String newkey)
      {
         key = newkey;
      }
      
      public void setfrequency(int newfrequency)
      {
         frequency = newfrequency;
      }
      public int compareTo(HuffmanTreeNode thingy)
      {
         return frequency - thingy.frequency;
      }
      public String toString()
      {
         return key;
      }
   }