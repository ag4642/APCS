   interface Checker
   {
   /** @param text a string to consider for acceptance
   * @return true if this Checker accepts text; false otherwise
   */
      boolean accept(String text);
   }
   //  Part A
   public class SubstringChecker implements Checker
   {
      private String goalString;
      public SubstringChecker(String goal)
      {
         goalString = goal;
      }
    /** @param text a string to consider for acceptance
   * @return true if this Checker contains text; false otherwise
   */
      public boolean accept(String text)
      {
         return (text.indexOf(goalString) != -1);
      }
   }
   
	//Part B  -- AndChecker
   class AndChecker implements Checker
   {
      private Checker checker1;
      private Checker checker2;
   /*The constructor takes two Checker parameters.
   */
      public AndChecker(Checker chk1, Checker chk2)
      {
         checker1 = chk1;
         checker2 = chk2;
      }
   /** @param text a string to consider for acceptance
   * @return true if and only if the string is accepted
   * by both of the Checker objects with which it was constructed.
   */
      public boolean accept(String text)
      {
         return checker1.accept(text) && checker2.accept(text);
      }
   }

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
   
