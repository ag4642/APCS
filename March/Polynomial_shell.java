  //Name:   Date:
   import java.util.*;
    public class Polynomial_shell
   {
       public static void main(String[] args)
      {
         Polynomial poly = new Polynomial();
         poly.addTerm(1, -4);
         poly.addTerm(3, 2);
         poly.addTerm(0, 2);
         System.out.println(poly.toString());
         System.out.println(poly.evaluate(2.0));
      	
         Polynomial poly2 = new Polynomial();
         poly2.addTerm(1, -4);
         poly2.addTerm(3, 2);
         poly2.addTerm(0, 3);
         poly2.addTerm(2, 1); 
         System.out.println(poly2.toString());
      	
         System.out.println(poly.add(poly2));
         System.out.println(poly.multiply(poly2));
      }
   }


    class Polynomial
   {
   
   }
	/*  
	expected output
		2x^3 + -4x + 2
		10.0
		2x^3 + x^2 + -4x + 3
		4x^3 + x^2 + -8x + 5
		4x^6 + 2x^5 + -16x^4 + 6x^3 + 18x^2 + -20x + 6
	 */