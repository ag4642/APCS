   import java.util.Arrays;

   public class ArrayList1<E> {
      private Object[] a;
      private int size = 0;
   
      public ArrayList1() {
         a = (E[])(new Object[10]); //java doesn't support generic array allocation
      }
   
      public ArrayList1(int capacity) {
         if(capacity <= 0)
            throw new IllegalArgumentException("Capacity must be positive.");
         a = (E[])(new Object[capacity]); //java doesn't support generic array allocation
      }
   
      public void add(E obj) {
         if(size == a.length)
            a = Arrays.copyOf(a,size*2);
         a[size++] = obj;
      }
   
      public void add(int i, E obj) {
         if(i < 0 || i > size)
            a = Arrays.copyOf(a, i+1);
         if(size == a.length)
            a = Arrays.copyOf(a,size*2);  
         for(int j = size++; j > i; j--)
            a[j] = a[j-1];
         a[i] = obj;
      }
   
      public E get(int i) {
         return (E)a[i];
      }
   
      public E remove(int i) {
         if(i < 0 || i > size)
            throw new IllegalArgumentException("Index is out of bounds.");		
         E obj = (E)a[i];
         for(int j = i; j < size-1; j++)
            a[j] = a[j+1];			
         // if(size == a.length/4)
            // a = Arrays.copyOf(a,size/2);
         size--;
         return obj;
      }
   
      public int size() {
         return size;
      }
   }
		
