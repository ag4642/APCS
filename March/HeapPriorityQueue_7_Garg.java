   import java.util.*;
   public class HeapPriorityQueue_7_Garg<E extends Comparable<E>> 
   {
      private ArrayList<Customer> myHeap;
      private int size;
      
      public HeapPriorityQueue_7_Garg()
      {
         myHeap = new ArrayList<Customer>();
      }
      public HeapPriorityQueue_7_Garg(int size)
      {
         myHeap = new ArrayList<Customer>(size);
      }
      public void add(Customer e)
      {
         if(myHeap.add(e))
         {
            heapUp(myHeap.indexOf(e));
            size++;
         }   
      }
      public boolean contains(Object obj)
      {
         return myHeap.contains(obj);
      }
      public Customer peek()
      {
         return myHeap.get(1);
      }
      public Customer remove()
      {
         size--;
         return myHeap.remove(0);
      }
      public int size()
      {
         return size;
      }
      public boolean isEmpty()
      {
         if(size == 0)
         {
            return true;
         }
         return false;
      }
      public Customer poll()
      {
         if(size == 0)
         {
            return null;
         }
         else
         {
            Customer e = myHeap.get(0);
            myHeap.remove(myHeap.get(0));
            size--;
            return e;
         }
      }
      public void swap(int a, int b)
      {
         Customer temp = myHeap.get(a);
         myHeap.set(a, myHeap.get(b));
         myHeap.set(b, temp);
      }
      public void heapDown(int k, int size)
      {
         int left = 2*k;
         int right = 2*k+1;
         if(k > size || left > size)
         {
            return;
         }
         if(right > size)
         {
            if(myHeap.get(k).compareTo(myHeap.get(left)) < 0)
            {
               swap(k, left);
            }
         }
         else
         {
            int maxChild = (myHeap.get(left).compareTo(myHeap.get(right)) > 0) ? left:right;
            if(myHeap.get(k).compareTo(myHeap.get(maxChild)) < 0)
            {
               swap(k, maxChild);
               heapDown(maxChild, size);
            }
         }
      }
      public void heapUp(int index)
      {
         while(index > 1 && myHeap.get(index).compareTo(myHeap.get(index)) < 0)
         {
            swap(index, index/2);
            index = index/2;
         }
      }
      public void makeHeap(int size)
      {
         for(int x = size/2; x >= 1; x--)
            heapDown(x, size);
      }
      public String toString()
      {
         String s = "{";
         for(int cell = 0; cell < myHeap.size(); cell ++)
         {
            if(cell < myHeap.size() - 1)
            {
               s = s +(myHeap.get(cell) + ", ");
            }
            else
            {
               s = s + ("" + myHeap.get(cell));
            }
         }
         s = s + "}";
         return s;
      }
   }
