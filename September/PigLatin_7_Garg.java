   import java.util.*;
   import java.io.*;

   public class PigLatin_7_Garg
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         //part_1();
         part_2();
         
      }
      public static String pig(String s)
      {
         String latin = "";
         char c = 'a';
         String b = "";
         char m = s.charAt(0);
         char n = s.charAt(1);
         char p = s.charAt(s.length() - 1);
         char q = s.charAt(s.length() - 2);
         boolean capital = false;
         String punctuation = "";
         String punct1= "";
         String punct2="";
         String punct3="";
         String f = s.substring(0,1);
         if(Character.isUpperCase(m) || Character.isUpperCase(n))
            capital = true;
        
         if(p == '.' || p == '"' || p == '!' || p == '?')
         {
            punct1 = Character.toString(p);
            s = s.substring(0, s.length() - 1);
         }
      
         if(m == '.' || m == '"' || m == '!' || m == '?')
         {
            punct2 = Character.toString(m);
            s = s.substring(1, s.length());
         }
         if(q == '.' ||q == '"' ||q == '!' || q == '?')
         {
            punct3 = Character.toString(q);
            s = s.substring(0, s.length() - 1);
         } 
           
         for(int x = 0; x < s.length(); x++)
         {
            c = s.charAt(x);
            b = s.substring(x, x+1);
            if(m == 'a' ||m == 'e' || m == 'i' || m == 'o' || m == 'u')
            {
               latin = s + "way";
            }
            else if(c == 'u' && s.charAt(x-1) =='q')
            {
               latin = s.substring(x+1) + "quay";
            }
            else if( x >0 && c == 'y')
            {
               latin = s.substring(x) + s.substring(0,x) + "ay";
               x = s.length() + 1;
            }
            else if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u')
            {
               latin = s.substring(x) + s.substring(0, x) + "ay";
               x= s.length() + 1;
            }
            else
            {
               latin = "INVALID";
            }   
         }
         if(capital)
            return punct2 + latin.substring(0, 1).toUpperCase() + latin.substring(1).toLowerCase() + punct3 + punct1;
         else 
         {
            return punct2 + latin + punct3 + punct1; 
         }
      }
      
      public static void part_1()
      {
         Scanner sc = new Scanner(System.in);
         while(true)
         {
            System.out.print("\nWhat word? ");
            String s = sc.next();
            if (s.equals("-1")) 
               break;
            String p = pig(s);
            System.out.println("***** " + p + " *****");
         }		
      }
      public static void part_2() throws FileNotFoundException
      {
         try
         {
            System.out.println("Enter file: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            Scanner sca = new Scanner(new File(s));
            String fileout= pig(s.substring(0, s.indexOf('.')))+".txt";
            PrintStream outfile= new PrintStream(new FileOutputStream(fileout));
            while(sca.hasNext())
            {
               String g = sca.next();
             
               if(g.charAt(g.length()-1)== '.')
               {
                  outfile.println(pig(g));
                  outfile.println(" ");  
                  outfile.println(" ");        
               }
               else
               {
                  outfile.println(pig(g));
                  outfile.print(" ");
               }
            }
         }  
            catch (FileNotFoundException e) 
            {
               System.err.println("FileNotFoundException: "
                        + e.getMessage());
            }
      }
   }