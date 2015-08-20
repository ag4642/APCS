//  Name:      date:
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.
   import java.util.*;
   import java.io.*;

   public class IndexMaker_7_Garg
   {
      public static void main(String[] args) throws IOException
      {
         Scanner keyboard = new Scanner(System.in);
         System.out.print("\nEnter input file name: ");
         String fileName = keyboard.nextLine().trim();
         Scanner inputFile = new Scanner(new File(fileName));
         System.out.print("\nEnter output file name: ");
         fileName = keyboard.nextLine().trim();
         PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
         DocumentIndex index = new DocumentIndex(); 	
         String line = null;
         int lineNum = 0;
         while(inputFile.hasNextLine())
         {
            lineNum++;
            index.addAllWords(inputFile.nextLine(), lineNum);
         }
         for(IndexEntry entry : index)
            outputFile.println(entry);
         inputFile.close(); 						
         outputFile.close();
         System.out.println("Done.");	
      }
   }
   class DocumentIndex extends ArrayList<IndexEntry>
   {
      public DocumentIndex()
      {
         super();
      }
   
    /** append num to the array in IndexEntry for word by calling that IndexEntry's  
    add(num) method. */
      public void addWord(String word, int num)
      {
         int index = foundOrInserted(word);
         this.get(index).add(num);
      }
      
    /** extracts all the words from str, skipping punctuation and whitespace 
    and for each word calls addWord(word, num).  A good way to skip punctuation 
    and whitespace is to use String's split method, e.g., split("[., "!?]") */
      public void addAllWords(String str, int num) 
      { 
         String[] strArray = str.split("[., \"!?]");
         for(String s : strArray) 
            if(!s.equals(""))  
               addWord(s, num);     
      }
      
    /** traverses this DocumentIndex and compares word to the words in the 
    IndexEntry objects in this list, looking for the correct position of 
    word. If an IndexEntry with word is not already in that position, the 
    method creates and inserts a new IndexEntry at that position. The 
    method returns the position of either the found or the inserted 
    IndexEntry.*/
      private int foundOrInserted(String word)
      {
         IndexEntry k = new IndexEntry(word); 
         this.add(k);
         for(IndexEntry element : this) 
         {
            if(element == get(indexOf(element)))
               return 0; 
         }	
         for(IndexEntry element : this) 
         {
            if(word.compareTo(element.getWord()) > 0) 
            {
               add(indexOf(element) - 1, k); 
               return indexOf(element) - 1; 
            }
         }
         return -1;
      }
   }
   class IndexEntry implements Comparable<IndexEntry>
   {
      private String word;
      private ArrayList<Integer> numsList; 
        
      public IndexEntry(String s)
      {
         word = s.toUpperCase(); 
         numsList = new ArrayList<Integer>();
      }
      void add(int num)
      {
         if(!numsList.contains(num))
         {
            numsList.add(num);
         }
      }
      	/** this is a standard accessor method  */
      public String getWord()
      {
         return word;
      }
      public int compareTo(IndexEntry entry)
      {
         return word.compareTo(entry.toString()); 
      }
               /**  returns a string representation of this Index Entry in the format as 
      shown on each line of the output file--see the previous page.  */
      public String toString()
      {
         String s = word + "";
         for(Integer e : numsList)
         {
            s+= e + "";
         }
         return s;
      }
   }