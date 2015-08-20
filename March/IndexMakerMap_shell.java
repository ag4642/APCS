//  Name:      date:
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.

   import java.io.*;
   import java.util.*;

   public class IndexMakerMap_shell
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
         int lineNum = 0;
         while(inputFile.hasNextLine())
         {
            lineNum++;
            index.addAllWords(inputFile.nextLine(), lineNum);
         }
         //print to the outputFile
      	
      	
         inputFile.close(); 						
         outputFile.close();
         System.out.println("Done.");
      }
   }
   
   class DocumentIndex extends TreeMap<String, ArrayList<Integer>>
   {
      public void addWord(String word, int lineNum)
      {
      
      }
      
    /** extracts all the words from str, skipping punctuation and whitespace 
    and for each word calls addWord(word, num).  A good way to skip punctuation 
    and whitespace is to use String's split method, e.g., split("[., \"!?]") */
      public void addAllWords(String str, int lineNum) 
      {
      
      }
   }


