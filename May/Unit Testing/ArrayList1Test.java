   import static org.junit.Assert.*;
   import org.junit.Before;
   import org.junit.Test;
  
   public class ArrayList1Test {
      private ArrayList1<Double> a;
        /** Fixture initialization (common initialization
         *  for all tests). **/
      @Before public void setUp() {
         a = new ArrayList1<Double>();
      }
      @Test public void testSize() {
         assertEquals(0,a.size());
         a.add(1.0);
         assertEquals(1,a.size());
         a.add(2.0);
         assertEquals(2,a.size());
         a.remove(1);
         assertEquals(1,a.size());
         a.remove(0);
         assertEquals(0,a.size());
      }
      @Test public void testAddGet() {
         for(int i = 0; i < 10; i++)
            a.add(i*1.0);
         for(int i = 0; i < 10; i++)
            assertEquals(i,a.get(i),1E-6);
      }  
      @Test public void testAddGet2() {
         for(int i = 0; i < 10; i++)   
            a.add(0,i*1.0);
         for(int i = 0; i < 10; i++)
            assertEquals(9-i,a.get(i),1E-6);
      }
      @Test public void testAddGet3() {
         for(int i = 0; i < 10; i++)   
            a.add(0,i*1.0);
         for(int i = 0; i < 10; i++)
            assertEquals(9-i,a.get(i),1E-6);
      }
      @Test public void testRemove() {
         a.add(5.6);
         a.add(0,4.2);
         a.add(3.9);
         assertEquals(4.2,a.get(0),1E-6);
         a.remove(0);
         assertEquals(5.6,a.get(0),1E-6);
         a.remove(1);
         assertEquals(5.6,a.get(0),1E-6);
      }
      @Test public void testRemove2() {
         a.add(5.6);
         a.add(1,4.2);
         a.add(3.9);
         assertEquals(4.2,a.get(1),1E-6);
         a.remove(1);
         assertEquals(5.6,a.get(0),1E-6);
         a.remove(0);
         assertEquals(3.9,a.get(0),1E-6);
      }
      @Test public void testRemove3() {
         a.add(5.6);
         a.add(1,4.2);
         a.add(3.9);
         a.remove(2);
         assertEquals(4.2,a.get(1),1E-6);
         a.remove(1);
         assertEquals(5.6,a.get(0),1E-6);
      }  
   }