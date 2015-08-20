   import java.util.*;
   import java.io.*;
   public class SetsOfLetters_7_Garg
   {
      private static int count = 0;
      public static void main(String[] args) throws FileNotFoundException
      {
         Set<Character> set = new TreeSet<Character>();
         Scanner infile = new Scanner(new File("declarationLast.txt"));
         while(infile.hasNext())
         {
            Set<Character> set1 = new HashSet<Character>();
            String str = infile.nextLine();
            for(int i = 0; i < str.length(); i++)
            {
               set1.add(str.charAt(i));
            }
            Set<Character> set2 = new TreeSet<Character>(set1);
            if(count == 0)
            {
               set = set2;
            }
            else
            {
               set.retainAll(set2);
            }
            System.out.println(str);
            String lowercase = "";
            String uppercase = "";
            String other = "";
            for(char x: set2)
            {
               if(!Character.isLetter(x))
               {
                  other += x + " ";
               }
               else if(Character.isLowerCase(x))
               {
                  lowercase += x + " ";
               }
               else if(Character.isUpperCase(x))
               {
                  uppercase += x + " ";
               }
            }
            System.out.println("Lower case: " + lowercase);
            System.out.println("Upper case: " + uppercase);
            System.out.println("Other: " + other);
            System.out.println();
            count++;
         }
      
         String lowercase1 = "";
         String uppercase1 = "";
         String other1 = "";
         for(char x: set)
         {
            if(!Character.isLetter(x))
            {
               other1 += x + " ";
            }
            else if(Character.isLowerCase(x))
            {
               lowercase1 += x + " ";
            }
            else if(Character.isUpperCase(x))
            {
               uppercase1 += x + " ";
            }
         }
         System.out.println("Characters in every line:");
         System.out.println("Lower case: " + lowercase1);
         System.out.println("Upper case: " + uppercase1);
         System.out.println("Other: " + other1);
      }
   }