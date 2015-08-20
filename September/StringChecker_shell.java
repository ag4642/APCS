   //2008 Syllabus "A", Question #4.  
   //The Design Question.
    public class StringChecker_shell
   {
       public static void main(String [] args)
      {
         System.out.println("-------Part A ---------------");
         Checker broccoliChecker = new SubstringChecker("broccoli");
         System.out.println(broccoliChecker.accept("broccoli")); 				//true
         System.out.println(broccoliChecker.accept("I like broccoli")); 	//true
         System.out.println(broccoliChecker.accept("carrots are great")); 	//false
         System.out.println(broccoliChecker.accept("Broccoli Bonanza")); 	//false
        
         System.out.println("-------Part B ---------------");
         Checker bChecker = new SubstringChecker("beets");
         Checker cChecker = new SubstringChecker("carrots");
         Checker bothChecker = new AndChecker(bChecker, cChecker);
         Checker aChecker = new SubstringChecker("artichokes");
         Checker veggies = new AndChecker(bothChecker, aChecker);
         System.out.println(bothChecker.accept("I love beets and carrots")); 	//true
         System.out.println(bothChecker.accept("beets are great")); 				//false
         System.out.println(veggies.accept("artichokes, beets, and carrots"));//true
        
         System.out.println("-------Part C ---------------");
         Checker artiChecker = new SubstringChecker("artichokes");
         Checker kChecker = new SubstringChecker("kale");
         Checker yummyChecker;
         yummyChecker = /* write this line */  
            System.out.println(yummyChecker.accept("chocolate truffles")); 		//true
         System.out.println(yummyChecker.accept("kale is great")); 				//false
         System.out.println(yummyChecker.accept("Yuck: artichokes & kale")); 	//false 
      }
   }
   //examines strings and accepts those strings that meet a particular criterion.
    interface Checker
   {
   /** @param text a string to consider for acceptance
   * @return true if this Checker accepts text; false otherwise
   */
       boolean accept(String text);
   }
   
	// Part A  -- SubstringChecker
   class SubstringChecker implements Checker
	{
		public String check;
		public SubstringChecker(String c)
		{
			check = c;
		}
		public boolean accept(String text)
		{
			//write
		}
	
   
   // Part B  -- AndChecker
   
   
   
    class NotChecker implements Checker
   {
      private Checker checker1;
      /*A one-parameter constructor that takes one Checker object
   	*/
       public NotChecker(Checker chk1)
      {
         checker1 = chk1;
      }
   /*
   * returns true if and only if its Checker object does NOT accept the string
   */
       public boolean accept(String text)
      {
         return !checker1.accept(text);
      }
   }

/*   Sample Run   


-------Part A ---------------
true
true
false
false
-------Part B ---------------
true
false
true
-------Part C ---------------
true
false
false
  
*/