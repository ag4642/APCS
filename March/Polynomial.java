   import java.util.Iterator;
   import java.util.Map;
   import java.util.TreeMap;


/**
 * This class represents a polynomial in one variable.
 * This class is not thread safe.
 * 
 * @author sebster
 */
   public class Polynomial
   {
   
   /**
    * The map of terms from which this polynomial is constructed. The map is
    * sorted from greatest to least exponent.
    */
      protected TreeMap termMap;
   
   /**
    * An array version of the terms, for efficiency when repeatedly calculating
    * the value of this polynomial.
    */
      private Term[] termArray;
   
   /**
    * The derivative of this polynomial, used for finding roots with Newton's
    * method.
    */
      private Polynomial derivative;
   
   /**
    * Construct a new zero polynomial.
    */
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
   
      public Polynomial()
      {
         this(null);
      }
   
   /**
    * Construct a copy of the specified polynomial.
    * 
    * @param polynomial the polynomial to construct a copy of
    */
      public Polynomial(Polynomial polynomial)
      {
      // Initialize the polynomial to the zero polynomial.
         setToZero();
      
      // Copy the specified polynomial.
         if (polynomial != null)
         {
         // Add a copy of each term.
            Iterator iterator = polynomial.termMap.entrySet().iterator();
            while (iterator.hasNext())
            {
               Map.Entry entry = (Map.Entry)iterator.next();
               termMap.put(entry.getKey(), new Term((Term)entry.getValue()));
            }
         // The derivative and the term array never change, so copy them.
            termArray = polynomial.termArray;
            derivative = polynomial.derivative;
         }
      }
   
      public void js_addPolynomial(Polynomial p)
      {
         addPolynomial(p);
      }
   
      public void js_addTerm(double coefficient, int exponent)
      {
         addTerm(coefficient, exponent);
      }
   
      public double js_findRoot(double root, double error, int iterations)
      {
         return findRoot(root, error, iterations);
      }
   
      public Polynomial js_getDerivative()
      {
         return getDerivative();
      }
   
      public double js_getDerivativeValue(double x)
      {
         return getDerivativeValue(x);
      }
   
      public double js_getValue(double x)
      {
         return getValue(x);
      }
   
      public void js_multiplyByPolynomial(Polynomial polynomial)
      {
         multiplyByPolynomial(polynomial);
      }
   
      public void js_multiplyByTerm(double coefficient, int exponent)
      {
         multiplyByTerm(coefficient, exponent);
      }
   
      public void js_setToZero()
      {
         setToZero();
      }
   
   /**
    * Set this polynomial to the zero polynomial.
    */
      public void setToZero()
      {
         termMap = new TreeMap();
         termArray = null;
         derivative = null;
      }
   
   /**
    * Add the specified term to this polynomial.
    * 
    * @param coefficient the coefficient of the term to add
    * @param exponent the exponent of the term to add
    */
      public void addTerm(double coefficient, int exponent)
      {
      // Invalidate the term array and the derivative.
         termArray = null;
         derivative = null;
      
      // Add the specified term to the existing term with the same exponent,
      // or create the term if it does not exist. Don't add terms with a
      // coefficient of 0 to the term map.
         Integer key = new Integer(exponent);
         Term term = (Term)termMap.remove(key);
         if (term == null) term = new Term(0D, exponent);
         term.coefficient += coefficient;
         if (term.coefficient != 0D) termMap.put(key, term);
      }
   
   /**
    * Add the specified term to this polynomial.
    * 
    * @param term the term to add
    */
      private void addTerm(Term term)
      {
         addTerm(term.coefficient, term.exponent);
      }
   
   /**
    * Add the specified polynomial to this polynomial.
    * 
    * @param polynomial the polynomial to add
    */
      public void addPolynomial(Polynomial polynomial)
      {
         Iterator iterator = polynomial.termMap.values().iterator();
         while (iterator.hasNext())
         {
            addTerm((Term)iterator.next());
         }
      }
   
   /**
    * Multiply this polynomial by the specified term.
    * 
    * @param coefficient the coefficient of the term to multiply by
    * @param exponent the exponent of the term to multiply by
    */
      public void multiplyByTerm(double coefficient, int exponent)
      {
      // Save a copy of the terms and set the polynomial to zero.
         TreeMap oldTermMap = termMap;
         setToZero();
      
      // If we are not multiplying by zero (which would annihilate
      // the polynomial), multiply each old term with the specified
      // term and add it to the polynomial again.
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
   
   /**
    * Multiply this polynomial by the specified term.
    * 
    * @param term the term to multiply by
    */
      private void multiplyByTerm(Term term)
      {
         multiplyByTerm(term.coefficient, term.exponent);
      }
   
   /**
    * Multiply this polynomial by the specified polynomial.
    * 
    * @param polynomial the polynomial to multiply by
    */
      public void multiplyByPolynomial(Polynomial polynomial)
      {
      // Save a copy of the terms and set the polynomial to zero.
         TreeMap oldTermMap = termMap;
         setToZero();
      
      // Multiplication by zero?
         if (polynomial.termMap.size() == 0) 
            return;
      
      // Multiply all terms.
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
   
   /**
    * Calculate the value of this polynomial in the specified coordinate.
    * 
    * @param x the coordinate in which to calculate the value of this polynomial
    * 
    * @return the value of this polynomial in the specified coordinate
    */
      public double getValue(double x)
      {
      // Create the array of terms if it has not yet been created.
         if (termArray == null) calculateTermArray();
      
      // Calculate the result.
         double result = 0D;
         for (Term term : termArray)
         {
            result += term.coefficient * Math.pow(x, term.exponent);
         }
         return result;
      }
   
   /**
    * Calculate the value of the derivative of this polynomial in the specified coordinate.
    * 
    * @param x the coordinate in which to calculate the value of the derivative of this polynomial
    * 
    * @return the value of the derivative of this polynomial in the specified coordinate
    */
      public double getDerivativeValue(double x)
      {
      // Calculate the derivative if it has not yet been calculated.
         if (derivative == null) calculateDerivate();
         return derivative.getValue(x);
      }
   
   /**
    * Calculate and return the derivative of this polynomial.
    * 
    * @return the derivative of this polynomial
    */
      public Polynomial getDerivative()
      {
      // Calculate the derivative if it has not yet been calculated.
         if (derivative == null) calculateDerivate();
      
      // Return a copy of the derivative polynomial.
         return new Polynomial(derivative);
      }
   
   /**
    * Use Newton's method to find a root of this polynomial.
    * 
    * @param root the initial guess for the root
    * @param error the maximum allowed error
    * @param iterations the maximum allowed number of iterations
    * 
    * @return the value of the root after the specified number of iterations or as
    * 		soon as the error condition was satisified; returns Double.NaN if at some
    * 		point the derivative was zero
    */
      public double findRoot(double root, double error, int iterations)
      {
         double value = getValue(root);
         while (Math.abs(value) > error && iterations > 0)
         {
            double derivative = getDerivativeValue(root);
            if (derivative == 0D) 
               return Double.NaN;
            root = root - value / derivative;
            value = getValue(root);
            iterations--;
         }
      
         return root;
      }
   
   /**
    * Return a string representation of this polynomial as a sum of terms with
    * the terms with the smaller exponents to the left of terms with larger
    * exponents.
    * 
    * @return a string representation of this polynomial
    */
      @Override
      public String toString()
      {
         Iterator iterator = termMap.values().iterator();
         if (iterator.hasNext())
         {
            StringBuffer buffer = new StringBuffer();
            while (iterator.hasNext())
            {
               if (buffer.length() > 0) buffer.append(" + "); //$NON-NLS-1$
               buffer.append(iterator.next());
            }
            return buffer.toString();
         }
         return "0"; //$NON-NLS-1$
      }
   
   /**
    * Calculate the term array.
    */
      private void calculateTermArray()
      {
         if (termArray == null)
         {
            termArray = new Term[termMap.size()];
            termMap.values().toArray(termArray);
         }
      }
   
   /**
    * Calculate the derivate.
    */
      private void calculateDerivate()
      {
      // Calculate the derivative if it has not yet been calculated.
         if (derivative == null)
         {
            derivative = new Polynomial();
            Iterator iterator = termMap.values().iterator();
            while (iterator.hasNext())
            {
               Term term = (Term)iterator.next();
               if (term.exponent != 0)
               {
                  derivative.addTerm(term.exponent * term.coefficient, term.exponent - 1);
               }
            }
         }
      }
   
   /**
    * The Term class represents a term of a polynomial in one variable.
    * The term represented is <i>coefficient * x^exponent</i>.
    * 
    * @author sebster
    */
      public class Term implements Comparable
      {
      /**
       * The coefficient of the term.
       */
         protected double coefficient;
      
      /**
       * The exponent of the term.
       */
         protected int exponent;
      
      /**
       * Construct a copy of the specified term.
       * 
       * @param term
       */
         public Term(Term term)
         {
            this(term.coefficient, term.exponent);
         }
      
      /**
       * Construct a term with the specified coefficient and exponent.
       * 
       * @param coefficient the coefficient of this term
       * @param exponent the exponent of this term
       */
         public Term(double coefficient, int exponent)
         {
            this.coefficient = coefficient;
            this.exponent = exponent;
         }
      
      /**
       * Compare this term to another term. Terms are ordered lexicographically
       * by their exponent and coefficient.
       * 
       * @throws NullPointerException if the other object is null
       * @throws ClassCastException if the other object is not a Term
       */
         public int compareTo(Object other)
         {
            Term otherTerm = (Term)other;
            return exponent == otherTerm.exponent ? Double.compare(coefficient, otherTerm.coefficient) : (exponent - otherTerm.exponent);
         }
      
      /**
       * Returns the string representation coefficient*x^exponent of this term.
       * 
       * @return the string representation of this term
       */
         @Override
         public String toString()
         {
            StringBuffer buffer = new StringBuffer();
            buffer.append(coefficient);
            if (exponent != 0)
            {
               buffer.append("x^"); //$NON-NLS-1$
               buffer.append(exponent);
            }
            return buffer.toString();
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