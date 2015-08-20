// name:        date: 
   import java.util.*;
   import java.io.*;
   public class Huffman_1L_Liu
   {
   
   	// 
   // 	1.	Use the priority queue of nodes to make the Huffman tree, as follows:
   //            Repeat until one node is in the priority queue:
   // a.	remove the two pairs with the lowest frequency.
   // b.	make them children of a third node, with a frequency equal to the sum of frequencies of the children.  The "letter" of this third node can be "*".
   // c.	put the third node into the priority queue.
   
      public static void main(String[] args) throws IOException
      {
         Scanner scanner = new Scanner(System.in);
         System.out.println("What string would you like to encode?");
         String str = scanner.nextLine();
         System.out.println("What is the name of string: this will replace the xxx in message.xxx.txt and scheme.xxx.txt");
         String name = scanner.next();
         HashMap<String, Integer> map = frequencytable(str);
         for(String str1 : map.keySet())
            System.out.println(str1 + " " + map.get(str1));
         PriorityQueue<HuffmanTreeNode> q = priorityq(map);
         HuffmanTreeNode father = new HuffmanTreeNode("*",0);
         while(q.size()>1)
         {
         
            HuffmanTreeNode t =  q.remove();
            HuffmanTreeNode t1 = q.remove();
            int frequency = t.getFrequency() + t1.getFrequency();
            q.add(new HuffmanTreeNode("*", frequency, t, t1));
         
         }
         System.setOut(new PrintStream(new FileOutputStream("scheme." + name + ".txt")));
         HashMap<String,String> map1 = new HashMap<String,String>();
         find(q.peek(), "", map1);
         System.setOut(new PrintStream(new FileOutputStream("message." + name + ".txt")));
         char[] array = str.toCharArray();
         for(int x =0; x<array.length; x++)
            System.out.print(map1.get(String.valueOf(array[x])));
      
      
      
      	
      }
      
      public  static HashMap<String, Integer> frequencytable(String str)
      {
         HashMap<String, Integer>  freq = new HashMap<String, Integer>();
         int count = 1;
         for(int x = 0; x <str.length(); x ++)
         {
         	
            String part = str.substring(x,x+1);
            if(freq.containsKey(part))
               freq.put(part, freq.get(part) +1);//count needs to be accessed from map
            
            else
               freq.put(part, count); 
         }
         return freq;
      }
      public static PriorityQueue<HuffmanTreeNode> priorityq(HashMap<String, Integer> map)
      {
         PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
         for(String str: map.keySet())
            pq.add(new HuffmanTreeNode(str, map.get(str)));
         return pq;
      } 
   // 		public static HuffmanTreeNode makeTree(PriorityQueue<HuffmanTreeNode> q)
   // 		{
   // 		HuffmanTreeNode father = new HuffmanTreeNode("*",0);
   // 		while(q.size()>1)
   // 		{
   // 		
   // 		HuffmanTreeNode t =  q.remove();
   // 		HuffmanTreeNode t1 = q.remove();
   // 		int frequency = t.getFrequency() + t1.getFrequency();
   // 	 	q.peek().setRight(new HuffmanTree("*", frequency, t, t1));
   // 		
   // 		}
   // 		return father;
   // 		}
      public static void find(HuffmanTreeNode t,String code, HashMap<String,String> map)
      {
      
         if(t == null)
            return;
         if(!t.getLetter().equals("*"))
         {
            System.out.print(t.getLetter() + code);
            System.out.println();
            map.put(t.getLetter(), code);
         }
         find(t.getLeft(),code + "0", map);
         find(t.getRight(), code + "1", map);
      }
   		  
      		
      
   }
		
         
	
   
	
   class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
   {
      private String letter;
      private int  freq;
      private HuffmanTreeNode left, right;
      public HuffmanTreeNode(String str, int i)
      {
         letter = str;
         freq = i;
         left = null;
         right = null;
      }
      public HuffmanTreeNode(String str, int i, HuffmanTreeNode initLeft, HuffmanTreeNode initRight)
      {
         letter = str;
         freq = i;
         left = initLeft;
         right = initRight;
      
      }
      public int getFrequency()
      {
         return freq;
      }
      public int compareTo(HuffmanTreeNode t)
      {
         if(this.getFrequency()-t.getFrequency() > 0)
            return 1;
         if(this.getFrequency()-t.getFrequency() ==0)
            return 0;
         else
            return -1;
      }
      public String getLetter()
      {
         return letter;
      }	
   
   
      public HuffmanTreeNode getLeft() 
      { 
         return left; 
      }
   
      public HuffmanTreeNode getRight() 
      { 
         return right; 
      }
   
      public void setValue(String newStr, int newfreq) 
      { 
         letter= newStr;
         freq = newfreq;
      }
   
      public void setLeft(HuffmanTreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
      public void setRight(HuffmanTreeNode theNewRight)
      { 
         right = theNewRight;
      }
      public String toString()
      {
         return letter + "" + freq;
      }
   
   }
