/**
 * @(#)HuffmanTreeNode
 *
 *
 * @Himanshu Pagey
 * @version 1.00 2006/11/4
 * @version 1.01 2007/04/11 (april 11th) Merrill McKee
 * Modified to take any comparable type (usually floats or ints)
 */


   public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
   {
   
      private int weight;      				// frequency
      private int character;   				// symbol, label
      private String code;     				// binary code
      private HuffmanTreeNode left;       	// left child
      private HuffmanTreeNode right;      	// right child
      private boolean[] boolCode;             // binary code in booleans
    
    // Constructor
      public HuffmanTreeNode(int w,int ch) {
         weight=w;
         character=ch;
         left=null;
         right=null;
         code=null;
         boolCode=null;
      }
    
    // CompareTo since this implements Comparable
      public int compareTo(HuffmanTreeNode node)
      {
         if( node.weight != weight )
         {
            return (weight - node.weight);
         }
         return 0;
      }
    
    // Accessor Methods
      public int getWeight() {
         return weight;}
      public int getCharacter() {
         return character;}
      public String getCode() {
         return code;}
      public HuffmanTreeNode getLeftNode() {
         return left;}
      public HuffmanTreeNode getRightNode() {
         return right;}
      public boolean[] getBoolCode() {
         return boolCode;}
    
    // Set Methods
      public void setWeight(int weight) {this.weight = weight;}
      public void setCharacter(int character) {this.character = character;}
      public void setCode(String code) {this.code = code;}
      public void setLeftNode(HuffmanTreeNode left) {this.left = left;}
      public void setRightNode(HuffmanTreeNode right) {this.right = right;}
      public void setBoolCode(boolean [] boolCode)
      {
         this.boolCode = new boolean[boolCode.length];
         for(int i=0; i<boolCode.length; i++)
         {
            this.boolCode[i] = boolCode[i];
         }
      }
   }