   import java.util.*;
   import java.io.*;

   class wVertex implements Comparable<wVertex>
   {
      private final String name;
      private Map<wVertex, Integer> edges = new HashMap<wVertex, Integer>();
      private int minDistance = Integer.MAX_VALUE;
      public wVertex(String city)
      {
         name = city;
      }
      public String toString()
      {
         return name;
      }
      public void addEdge( wVertex city, Integer weight )
      {
         edges.put(city, weight);
      }
      public Map<wVertex, Integer> getEdges()
      {
         return edges;
      }
      public int getMinDistance() 
      {
         return minDistance;
      }
      public void setMinDistance( int d) 
      {
         minDistance = d;
      }
      public int compareTo(wVertex other)
      { 
         if(minDistance < other.getMinDistance())
            return -1;
         else if(minDistance > other.getMinDistance())
            return 1;
         return 0;
      }
   }

   public class Dijkstra_7_Garg
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         //List<wVertex> vertices = read();
         List<wVertex> vertices = read2();
         int n = enterSource(vertices);    
         wVertex source = vertices.get(n); 
         computePaths(source);   
         System.out.println("Distance from "+ source.toString() );
         for (wVertex v : vertices)
         {
            System.out.print("    to " + v + ": " + v.getMinDistance() );
            System.out.println();
         }
      }
      public static List<wVertex> read()
      {
         List<wVertex> list = new ArrayList<wVertex>();
         wVertex a = new wVertex("Pensacola");
         wVertex b = new wVertex("Pendleton");
         wVertex c = new wVertex("Peoria");
         wVertex d = new wVertex("Phoenix");
         wVertex e = new wVertex("Pierre");
         wVertex f = new wVertex("Pittsburgh");
         wVertex g = new wVertex("Princeton");
         wVertex h = new wVertex("Pueblo");
         a.addEdge(d, 5);
         a.addEdge(f, 4);
         b.addEdge(h, 8);
         b.addEdge(e, 2);
         c.addEdge(h, 3);
         c.addEdge(f, 5);
         d.addEdge(a, 5);
         d.addEdge(f, 10);
         d.addEdge(h, 3);
         e.addEdge(b, 2);
         e.addEdge(h, 3);
         f.addEdge(g, 2);
         f.addEdge(a, 4);
         f.addEdge(c, 5);
         f.addEdge(d, 10);
         g.addEdge(f, 2);
         h.addEdge(e, 3);
         h.addEdge(b, 8);
         h.addEdge(c, 3);
         h.addEdge(d, 3);
         list.add(a);
         list.add(b);
         list.add(c);
         list.add(d);
         list.add(e);
         list.add(f);
         list.add(g);
         list.add(h);
         return list;	  
      }
      public static List<wVertex> read2() throws FileNotFoundException
      {
         List<wVertex> list = new ArrayList<wVertex>();
         Scanner sc1 = new Scanner( new File( "cities.txt" ) );
         Scanner sc = new Scanner( new File( "citydataweighted.txt" ) );
       
         while( sc1.hasNext() == true )
         {
            list.add( new wVertex( sc1.next() ) );
         }
         
         int rows = sc.nextInt();
         int cols = sc.nextInt();
         int[][] array = new int[rows][cols];
         for( int i = 0; i < rows; i++ )
         {
            for( int j = 0; j < cols; j++ )
            {
               array[i][j] = sc.nextInt();
            }
         }
         
         for( int i  = 0; i < array.length; i++ )
         {
            for( int j  = 0; j < array.length; j++ )
            {
               if( array[i][j] >= 0 && array[i][j] < 9999 )
               {
                  list.get( i ).addEdge( list.get( j ) , array[i][j] );
               }
            }
         }
       
         return list;
      }
      public static int enterSource(List<wVertex> theList)
      {
         String city = "";
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the starting city.");
         city = sc.next();
         for(int n = 0; n < theList.size(); ++n)
            if(theList.get(n).toString().compareToIgnoreCase(city) == 0)
               return n;
         while(1 == 1){
            System.out.println("You did not enter a valid city, please try again.");
            city = sc.next();
            for(int n = 0; n < theList.size(); ++n)
               if(theList.get(n).toString().equals(city))
                  return n;
         }
      }
      public static void computePaths(wVertex source)
      {
         PriorityQueue<wVertex> q = new PriorityQueue<wVertex>();
         
         source.setMinDistance(0);
         
         Map<wVertex , Integer> map = source.getEdges();
         Set<wVertex> keys = map.keySet();
         Collection<Integer> values = map.values();
         Iterator<wVertex> it = keys.iterator();
         
         for( wVertex w : keys )
         {
            if( w.getMinDistance() > map.get( w ) + source.getMinDistance()  )
            {
               w.setMinDistance( map.get( w ) + source.getMinDistance() );
               q.add( w );
            }
         }
         
         while( q.isEmpty() != true )
         {
            wVertex thisone = q.remove();
            Map<wVertex , Integer> map1 = thisone.getEdges();
            Set<wVertex> keys1 = map1.keySet();
         
            for( wVertex w : keys1 )
            {
               if( w.getMinDistance() > map1.get( w ) + thisone.getMinDistance()  )
               {
                  w.setMinDistance( map1.get( w ) + thisone.getMinDistance() );
                  q.add( w );
               }
            }
         }
      }
              // public static List<wVertex> getShortestPathTo(wVertex target)
      // {
      // 
      // }
   }