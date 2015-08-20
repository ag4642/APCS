// name:        date: 


   import java.util.*;
   import java.io.*;
   public class Huffman_7_Sardana
   {
	private static String results = "";
      public static void main(String[] args) throws IOException
      {
     PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<HuffmanTreeNode>();

         Scanner sc = new Scanner (System.in);
         String k = sc.next();
         TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();          
         for(int i = 0; i < k.length(); i++){
            char c = k.charAt(i);
           if(map.containsKey(c))
			  {
			     map.put(c, map.get(c) + 1);
            }
            else{
               map.put(c,1);
            }
         }
               	int index = 0;
         for(char x: map.keySet())
      	{
      	      	queue.add(new HuffmanTreeNode(x, map.get(x)));
     
      	}
        while(queue.size() > 1)
        {
        HuffmanTreeNode temp1 = queue.remove();
        HuffmanTreeNode temp2 = queue.remove();
        int sum = (Integer)temp1.getValue2() + (Integer)temp2.getValue2();
        HuffmanTreeNode tempp = new HuffmanTreeNode('*', sum, temp1, temp2);
        queue.add(tempp);
        }
      HuffmanTreeNode root = queue.remove();
		HuffmanTreeNode temp = root;
		 try
         {
            System.setOut(new PrintStream(new FileOutputStream("scheme." + k + ".txt")));
         }
            catch(Exception e)
            {
            }
		String list = "";
		String codes = "";
		for(char m: map.keySet())
		{
		
		Comparable g = (Comparable)m;
		list += m + "";
		list += find(temp, g);
		codes += results;
		System.out.println(list);
		
		list = "";
		results = "";
		}
		try
         {
            System.setOut(new PrintStream(new FileOutputStream("message." + k + ".txt")));
         }
            catch(Exception e)
            {
            }
				System.out.println(codes);

		
		
      	
      	
      }
		public static  String find(HuffmanTreeNode t, Comparable x)
      {
       
  if(t == null) 
  {
   return "";
  }
  if(((Comparable)t.getValue()).compareTo(x) == 0)
  {
  return results;
  }
  
if(((Comparable)t.getLeft().getValue()).compareTo(x) == 0)
{
results += "0";
return results;
}
else
{
results += "1";
 return find(t.getRight(), x);
 }
 




   }		 

   }
   
	
      

 class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
   {
    private Object value, value2;
      private HuffmanTreeNode left, right;
		private static String results = "";
		
   
       public HuffmanTreeNode(Object initValue, Integer val2)
      { 
         value = initValue; 
			value2 = val2;
         left = null; 
         right = null; 
      }
   
       public HuffmanTreeNode(Object initValue, Integer valuee,  HuffmanTreeNode initLeft, HuffmanTreeNode initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
			value2 = valuee;
      }
   
       public Object getValue()
      { 
         return value; 
      }
   public int getValue2()
	{
	return (Integer)value2;
	}
	
       public HuffmanTreeNode getLeft() 
      { 
         return left; 
      }
   
       public HuffmanTreeNode getRight() 
      { 
         return right; 
      }
   
       public void setValue(Object theNewValue) 
      { 
         value = theNewValue; 
      }
   
       public void setLeft(HuffmanTreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   public void setValue2(int value2new)
	{
	value2 = value2new;
	}
       public void setRight(HuffmanTreeNode theNewRight)
      { 
         right = theNewRight;
      }
		public int compareTo(HuffmanTreeNode other)
		{
		if((Integer)value2 < other.getValue2())
		{
		return -1;
		}
		else if((Integer)value2 > other.getValue2())
		{
		return 1;
		}
		else return 0;
		}
		}

   
