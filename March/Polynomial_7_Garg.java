   import java.util.*;
   public class Polynomial_7_Garg
   {
      public static void main(String[] args)
      {
         Polynomial poly = new Polynomial();
         poly.addTerm(-4, 1);
         poly.addTerm(2, 3);
         poly.addTerm(2, 0); 
         System.out.println(poly.toString());
         System.out.println(poly.getValue(2.0));
      	
         Polynomial poly2 = new Polynomial();
         poly2.addTerm(2, 3);
         poly2.addTerm(1, 2);
         poly2.addTerm(-4, 1);
         poly2.addTerm(3, 0); 
         System.out.println(poly2.toString());
         poly.addPolynomial(poly2);
         System.out.println(poly);
         poly.multiplyByPolynomial(poly2);
         System.out.println(poly);
      }
      static class Polynomial
      {
         private TreeMap termMap;
         private Term[] termArray;
      
         public Polynomial()
         {
            this(null);
         }
         public Polynomial(Polynomial polynomial)
         {
            setToZero();
            if(polynomial != null)
            {
               Iterator iterator = polynomial.termMap.entrySet().iterator();
               while (iterator.hasNext())
               {
                  Map.Entry entry = (Map.Entry)iterator.next();
                  termMap.put(entry.getKey(), new Term((Term)entry.getValue()));
               }
               termArray = polynomial.termArray;
            }
         }
      
         public void setToZero()
         {
            termMap = new TreeMap();
            termArray = null;
         }
         public void addTerm(double coefficient, int exponent)
         {
            termArray = null;
            Integer key = new Integer(exponent);
            Term term = (Term)termMap.remove(key);
            if (term == null) term = new Term(0D, exponent);
            term.coefficient += coefficient;
            if (term.coefficient != 0D) termMap.put(key, term);
         }
      
         private void addTerm(Term term)
         {
            addTerm(term.coefficient, term.exponent);
         }     
         public void addPolynomial(Polynomial polynomial)
         {
            Iterator iterator = polynomial.termMap.values().iterator();
            while (iterator.hasNext())
            {
               addTerm((Term)iterator.next());
            }
         }
         public void multiplyByTerm(double coefficient, int exponent)
         {
            TreeMap oldTermMap = termMap;
            setToZero();
            if (coefficient != 0D)
            {
               Iterator iterator = oldTermMap.values().iterator();
               while (iterator.hasNext())
               {
                  Term term = (Term)iterator.next();
                  term.exponent += exponent;
                  term.coefficient *= coefficient;
                  termMap.put(new Integer(term.exponent), term);
               }
            }
         }
         private void multiplyByTerm(Term term)
         {
            multiplyByTerm(term.coefficient, term.exponent);
         }
         public void multiplyByPolynomial(Polynomial polynomial)
         {
            TreeMap oldTermMap = termMap;
            setToZero();
         
            if (polynomial.termMap.size() == 0) 
               return;
         
            Iterator iterator1 = oldTermMap.values().iterator();
            while (iterator1.hasNext())
            {
               Term term1 = (Term)iterator1.next();
               Iterator iterator2 = polynomial.termMap.values().iterator();
               while (iterator2.hasNext())
               {
                  Term term2 = (Term)iterator2.next();
                  addTerm(term1.coefficient * term2.coefficient, term1.exponent + term2.exponent);
               }
            }
         }
         public double getValue(double x)
         {
            if (termArray == null) calculateTermArray();
         
            double result = 0D;
            for (Term term : termArray)
            {
               result += term.coefficient * Math.pow(x, term.exponent);
            }
            return result;
         }
                
         public String toString()
         {
            Iterator iterator = termMap.values().iterator();
            if (iterator.hasNext())
            {
               StringBuffer buffer = new StringBuffer();
               while (iterator.hasNext())
               {
                  if (buffer.length() > 0) buffer.append(" + ");
                  buffer.append(iterator.next());
               }
               return buffer.toString();
            }
            return "0"; 
         }
         private void calculateTermArray()
         {
            if (termArray == null)
            {
               termArray = new Term[termMap.size()];
               termMap.values().toArray(termArray);
            }
         }
      
         public class Term implements Comparable
         {
            private double coefficient;
            private int exponent;  
                   
            public Term(Term term)
            {
               this(term.coefficient, term.exponent);
            }
         
            public Term(double coefficient, int exponent)
            {
               this.coefficient = coefficient;
               this.exponent = exponent;
            }
            public int compareTo(Object other)
            {
               Term otherTerm = (Term)other;
               return exponent == otherTerm.exponent ? Double.compare(coefficient, otherTerm.coefficient) : (exponent - otherTerm.exponent);
            }
            public String toString()
            {
               StringBuffer buffer = new StringBuffer();
               buffer.append(coefficient);
               if (exponent != 0)
               {
                  buffer.append("x^");
                  buffer.append(exponent);
               }
               return buffer.toString();
            }
         }
      }
   }
    	/*  
	expected output
		2x^3 + -4x + 2
		10.0
		2x^3 + x^2 + -4x + 3
		4x^3 + x^2 + -8x + 5
		4x^6 + 2x^5 + -16x^4 + 6x^3 + 18x^2 + -20x + 6
	 */