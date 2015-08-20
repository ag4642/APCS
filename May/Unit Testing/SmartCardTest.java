   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;


   public class SmartCardTest {
   
   
   
      /** Fixture initialization (common initialization
       *  for all tests). **/
     
      @Test public void boardTest() {
        
      }
      @Test public void costTest() {
         SmartCard jimmy = new SmartCard(20.00); 
         Station center = new Station("Center City", 1);
         jimmy.board(center);
         Station uptown = new Station("Uptown", 2);
         Assert.assertEquals(1.25, jimmy.cost(uptown), 1E-6);
      }
      @Test public void costTest2() {
         SmartCard jimmy = new SmartCard(20.00); 
         Station center = new Station("Center City", 1);
         jimmy.board(center);
         Station uptown = new Station("Uptown", 1);
         Assert.assertEquals(.5, jimmy.cost(uptown), 1E-6);
      }
      @Test public void costTest3() {
         SmartCard jimmy = new SmartCard(20.00); 
         Station center = new Station("Center City", 1);
         jimmy.board(center);
         Station uptown = new Station("Uptown", 2);
         Assert.assertEquals(1.25, jimmy.cost(uptown), 1E-6);
      }
      @Test public void disembarkTest() {
         SmartCard jimmy = new SmartCard(20.00); 
         Station uptown = new Station("Uptown", 2); 
         Station center = new Station("Center City", 1);
         jimmy.board(uptown);
         jimmy.disembark(uptown);
         jimmy.board(center);
         jimmy.disembark(center);  
      }  
   }