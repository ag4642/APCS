   //Name:     Date:
   import java.io.*;
   import java.util.*;
   public class Dictionary
   {
      public static void main(String[] args) throws Exception
      {
         try
         {
            System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
         }
            catch(Exception e)
            {
            }
         Map<String, Set<String>> eng2spn = new TreeMap<String, Set<String>>();
         Scanner infile = new Scanner(new File("spanglish.txt"));
         while(infile.hasNext())
         {
            add(eng2spn, infile.next(), infile.next());
         }
         infile.close();
         System.out.println("ENGLISH TO SPANISH");
         display(eng2spn);
      
         Map<String, Set<String>> spn2eng = reverse(eng2spn);
         System.out.println("SPANISH TO ENGLISH");
         display(spn2eng);
      }
      public static void display(Map<String, Set<String>> m)
      {
         for(String k: m.keySet())
         {
            System.out.println(k + "" + m.get(k));
         }
         System.out.println();
      }
      public static void add(Map<String, Set<String>> dictionary, String word, String translation)
      {
         boolean tf = false;
         for(String m: dictionary.keySet())
         {
            if(m.equals(word) == true)
            {
               tf = true;
               dictionary.get(m).add(translation);
            }
         }
         if(tf == false)
         {
            TreeSet<String> translate = new TreeSet<String>();
            translate.add(translation);
            dictionary.put(word, translate);
         }
       
      }
      public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
      {
         TreeSet<Set> fromenglish = new TreeSet<Set>();
         for(String k: dictionary.keySet())
         {
            fromenglish.add(dictionary.get(k));
         }
         Map<String, Set<String>> mapfromeng = new TreeMap<String, Set<String>>();
         return dictionary;
      
      
      }
   }
      /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/