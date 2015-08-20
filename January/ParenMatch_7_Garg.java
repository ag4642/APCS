   import java.util.*;

   public class ParenMatch_7_Garg
   {
      public static final String LEFT  = "([{<";
      public static final String RIGHT = ")]}>";
      public static String s;
   
   		
      public static void main(String[] args)
      {
      
         Scanner infile = new Scanner(System.in);
         System.out.println("Enter expression");
         while(infile.hasNext())
         {
            s = infile.next();
            if(check(s) == true)
               System.out.println(s + " is good.");
            else
               System.out.println("No. Bad. " + s);
         }
      }
      public static boolean check(String input)
      {
         Stack<Character> stack = new Stack<Character>();
         for(int i = 0; i < input.length(); i++)
         {
            char c = input.charAt(i);
         
            if((c == '{') || (c == '[') || (c == '(') || (c == '<'))
            {
               stack.push(c);
            }
            else if((c == ')') || (c == ']') || (c == '}' || (c == '>')))
            {
               if(stack.isEmpty())
               {
                  return false;
               }
            
               char lastChar = stack.pop();
            
               if(((c == ')') && (lastChar != '(' )) || ((c == ']') && (lastChar != '[')) || ((c == '}') && (lastChar != '{' ) || c == '<' && lastChar != '>'))
               {
                  return false;
               }
            }
         }
      
         return stack.isEmpty();
      }
   }