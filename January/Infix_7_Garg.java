   import java.util.*;
   public class Infix_7_Garg
   {
   
      public static void main(String[] args)
      {
         Scanner infile = new Scanner(System.in);
         System.out.println("Enter Infix");
         String s = infile.next();
         System.out.println("Postfix Expression: " + convert(s));
         String st = convert(s);
         System.out.println("Postfix Evalutation: " + Postfix_7_Garg.eval(st)); 
      
      }
      public static String convert(String str)
      {
         String postfix = "";
         Stack<Character> stack = new Stack<Character>();
         for(int x = 0; x < str.length(); x++)
         {
            char c = str.charAt(x);
            if(!Postfix_7_Garg.isOperator(c) && c != '(' && c != ')')
            {
               postfix += c;
            }
            else if(c == '(')
            {
               stack.push(c);
            }
            else if(c == ')')
            {
               while(stack.peek() != '(')
               {
                  postfix += stack.pop();  
               }
               stack.pop();
            }
            
            else if(Postfix_7_Garg.isOperator(c))
            {
               if(stack.isEmpty() || isLower(stack.peek(), c) || stack.peek() == '(')
               {
                  stack.push(c);
               }
               else
               {
                  while(!stack.isEmpty() && stack.peek() != '(')
                  {
                     postfix += stack.pop();
                  }   
                  if(stack.isEmpty() || isLower(stack.peek(), c) || stack.peek() == '(')
                  {
                     stack.push(c);
                  }
               }
            }
         }
         while(!stack.isEmpty())
         {
            if(stack.peek() != '(')
            {
               postfix += stack.pop();
            }
         }
         return postfix;
      }
      public static boolean isLower(char c1, char c2)
      {
         if((c1 == '+' || c1 == '-')&& (c2 == '*' || c2 == '/'))
         {
            return true;
         }
         else if(c2 == '^')
         {
            return true;
         }
         else if(c1 == '%' && c2 == '!')
         {
            return true;
         }
         else if(c1 == '^')
         {
            return false;
         }
         else if((c1 == '%' || c1 == '!') && (c2 == '*' || c2 == '/' || c2 == '+' || c2 == '-'))
         {
            return false;
         }
         else if(c1 == c2)
         {
            return false;
         }
         return false;
      }
   }