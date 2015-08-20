//Name:          date:  
    public class Sentence_shell
   {
       public static void main(String[] args)
      {
         System.out.println("PALINDROME TESTER");
         Sentence s = new Sentence( "\"Hello there!\" she said." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
         s = new Sentence( "A Santa lived as a devil at NASA." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
        
      
         s = new Sentence( "Flo, gin is a sin! I golf." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      
         s = new Sentence( "Eva, can I stab bats in a cave?" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
      
         s = new Sentence( "Madam, I'm Adam." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      // Lots more test cases.  Test every line of code.  Test
      // the extremes, test the boundaries.  How many test cases do you need?
      
      }
   }
    class Sentence
   {
      private String mySentence;
      private int myNumWords;
      
      //Constructor.  Creates sentence from String str.
      //						Finds the number of words in sentence.
      //Precondition:  Words in str separated by exactly one blank.
       public Sentence( String str )
      { 
         
      }
      
       public int getNumWords()
      {  
         return myNumWords;  
      }
      
       public String getSentence()
      {
         return mySentence; 
      }
      
      //Returns true if mySentence is a palindrome, false otherwise.
       public boolean isPalindrome()
      {
         
      }
      //Precondition: s has no blanks, no punctuation, and is in lower case.
      //Returns true if s is a palindrome, false otherwise.
       private static boolean isPalindrome( String s, int start, int end )
      {
         
      }
      //Returns copy of String s with all blanks removed.
      //Postcondition:  Returned string contains just one word.
       private static String removeBlanks( String s )
      {  
         
      }
      
      //Returns copy of String s with all letters in lowercase.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String lowerCase( String s )
      {  
         
      }
      
      //Returns copy of String s with all punctuation removed.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String removePunctuation( String s )
      { 
         
      }
   }
