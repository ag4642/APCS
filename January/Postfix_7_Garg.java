   import java.util.*;
   public class Postfix_7_Garg
   {
   
      public static void main(String[] args)
      {
         Scanner infile = new Scanner(System.in);
         System.out.println("Enter Postfix");
         String s = infile.next();
         System.out.print(eval(s));
      }
      public static int eval(String str)
      {
         Stack<Integer> stack = new Stack<Integer>();
         for(int x = 0; x < str.length(); x++)
         {
            char s = str.charAt(x);
            if(isOperator(s))
            {
               int a = stack.pop();
               int b = stack.pop();
               int c = eval(b, a, s);
               stack.push(c);
            }
            else if(!isOperator(s))
            {
               String so = "" + s;
               stack.push(Integer.parseInt(so));
            }
         }
         return stack.pop();
      }
      private static int eval(int a, int b, char ch)
      {
         int ans = 0;
         if(ch == '*')
         {
            ans = a * b;
         }
         else if(ch == '+')
         {
            ans = a + b;
         }  
         else if(ch == '-')
         {
            ans = a - b;
         }
         else if(ch == '/')
         {
            if(b == 0)
            {
               System.out.println("Divide by 0 error");
               System.exit(0);
            }
            ans = a/b;
         }
         else if(ch == '^')
         {
            ans = a; 
            for(int x = 1; x < b; x++)
            {
               ans *= a;
            }
         }
         else if(ch == '%')
         {
            ans = a % b;
         }
         else if(ch == '!')
         {
            ans = 1;
            for(int x = 1; x < b; x++)
            {
               ans *= x;
            }
         }
         return ans;
      }
     
      public static boolean isOperator(char ch)
      {
         if(ch == '+' ||ch == '-' ||ch == '*' ||ch == '/'||ch == '%'||ch == '!'||ch == '^')
            return true;
         return false; 
      }
   }