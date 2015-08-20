   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;


   public class PrimeCheckTest {
   
      /** Fixture initialization (common initialization
       *  for all tests). **/
      @Before public void setUp() {
      }
     /** A test that always fails. **/
      @Test public void prime2()
      {
         Assert.assertEquals("2 is prime.", true, PrimeCheck.isPrime(2));
      }
      @Test public void prime3()
      {
         Assert.assertEquals("3 is prime.", true, PrimeCheck.isPrime(3));
      }
   
      @Test public void prime5()
      {
         Assert.assertEquals("5 is prime.", true, PrimeCheck.isPrime(5));
      }
   
      @Test public void prime4()
      {
         Assert.assertEquals("4 is prime.", false, PrimeCheck.isPrime(4));
      }
   
      @Test public void prime6()
      {
         Assert.assertEquals("6 is prime.", false, PrimeCheck.isPrime(6));
      }
      @Test public void prime7()
      {
         Assert.assertEquals("7 is prime.", true, PrimeCheck.isPrime(7));
      }
     
      @Test public void prime8()
      {
         Assert.assertEquals("8 is prime.", false, PrimeCheck.isPrime(8));
      }
      @Test public void prime9()
      {
         Assert.assertEquals("9 is prime.", false, PrimeCheck.isPrime(9));
      }
      @Test public void prime10()
      {
         Assert.assertEquals("10 is prime.", false, PrimeCheck.isPrime(10));
      }
   
   }
