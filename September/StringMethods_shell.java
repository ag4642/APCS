    public class StringMethods_shell
   {
       public static void main(String[] args)
      {
         String s = "Internet",  s2 = "net", s3 = "   Internet ";
         
         String s7 = s.substring(5);   			// "net"    
         String s8 = s.substring(0, 5);			// "Inter"
         String s9 = s.substring(2, 6);			// "tern"
         
         int pos11 = s.indexOf('e');				// 3
         int pos12 = s.indexOf('x');				// -1
         int pos13 = s.indexOf('e', 4);			// 6
         int pos14 = s.lastIndexOf('e');			// 6
         int pos15 = s.lastIndexOf('e', 4);		// 3	
         int pos16 = s.lastIndexOf('e', 2);		// -1
         int pos17 = s.indexOf(s2);					// 5
         int pos18 = s.indexOf(s2, 6);		   	// -1
         int pos19 = s.lastIndexOf(s2);	 		// 5
         int pos20 = s.lastIndexOf(s2, 6);		// 5
      
         boolean isSame22 = s.equals(s2);			// false
         boolean isSame23 = s.equalsIgnoreCase("internet");// true
         int result24 = s.compareTo("internet");// some number < 0, because "I" < "i"
         int result25 = s2.compareTo(s);			// some number > 0, because "i" > "I"
         int result26 = s.compareToIgnoreCase("internet");// 0
      	
         String s28 = s.toUpperCase();				//"INTERNET"
         String s29 = s.replace('n', 'N');		//"INterNet"
         String s30 = s3.trim();						//"Internet"
      	//no String method changes the String object for which they are
      	// called.  They build and return a new string instead. For example,
      	// s3.replace('a','A') by itself is useless, because s3 remains unchanged.
			// The technical term is "immutable," as in "Strings are immutable."
      	
         char ch = s.charAt(0);								// 'I'
         boolean isSame36 = (ch == 'I');					// true
         boolean isLetter37 = Character.isLetter(ch);	// true
         boolean isCap38 = Character.isUpperCase(ch);// true
         char ch39 = Character.toLowerCase(ch);			// 'i'
         String s40 = ch39 + s.substring(1);				// "internet"
      	//three ways to visit each character of a string
         for(int i = 0; i < s.length(); i++)
            System.out.print(s.substring(i, i+1)+" ");// I n t e r n e t 
         for(int i = 0; i < s.length(); i++)
            System.out.print(s.charAt(i)+" ");			// I n t e r n e t 
         char[] chArray = s.toCharArray();
         for(int i = 0; i < chArray.length; i++)		
            System.out.print(chArray[i]+" ");			// I n t e r n e t 
         System.out.println();
         String line = "The rain in Spain falls    mainly on the plain.";
         String[] lineSplit = line.split(" ");  //try line.split("in")
         for(int i = 0; i < lineSplit.length; i++)
            System.out.println(lineSplit[i]);			//output: 
      																/*		The
      																		rain
      																		in
      																		Spain
      																		falls
      																		
      																		
      																		
      																		mainly
      																		on
      																		the
      																		plain.  */
         
      //String Exercises, #1      
         String dateStr = "09/16/2008";
         //
			//
         System.out.println(dateStr);       // "16-09-08"
      //String Exercises, #2   
         System.out.println(myIndexOf(s, 'n', 0));    //1
         System.out.println(myIndexOf(s, 'n', 3));    //5
      //String Exercises, #3       
        
		  
      //String Exercises, #4       
         String dirtyStr = "Who. do yo$u th,ink you    are?!";
         System.out.println(scrub(dirtyStr));// Who do yo$u think you    are
      }
   
       public static int myIndexOf(String s, char ch, int fromPos)
      {	
      
      }
   	
      static String punct = ".,?!:;\"(){}{}<>"; 
       public static String scrub(String s)
      { 
      
      }
   
   }
