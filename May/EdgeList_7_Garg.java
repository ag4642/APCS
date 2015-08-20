   import java.util.*;
   import java.io.*;
   class Vertex 
   {
      private final String name;
      private List<Vertex> edges = new ArrayList<Vertex>();
      Vertex()
      {
         name = null;
      }
      Vertex(String str)
      {
         name = str;
      }
      public void addEdge( Vertex c ) 
      {
         edges.add( c );
      }
      public void removeEdge( Vertex c )
      
      {
         edges.remove( c );
      } 
      public String getName()
      {
         return name;
      }
      public List<Vertex> getEdges()
      {
         return edges;
      }
      public String toString()
      {
         String temp = name + "-->" ;
         for(Object v : edges)
            temp += ((Vertex)v).name+" ";
         return temp;
      }
   }
   
   public class EdgeList_7_Garg
   {  
      public static void main(String[] args)throws FileNotFoundException
      {
         System.out.println("Edge List Representation! ");
         List<Vertex> vertices = read();
      //   List<Vertex> vertices = read2();
         System.out.println(vertices);				//let's look at it first
         System.out.println();     
         for (Vertex v : vertices)
            System.out.println( findReachableDepth(v) );
            //System.out.println( findReachableBreadth(v) );
      		//System.out.println ( findReachableRecur(v) );
      }
      
      public static List<Vertex> read() 
      {
         Vertex a = new Vertex("Pendleton");
         Vertex b = new Vertex("Pensacola");
         Vertex c = new Vertex("Peoria");
         Vertex d = new Vertex("Phoenix");
         Vertex e = new Vertex("Pierre");
         Vertex f = new Vertex("Pittsburgh");
         Vertex g = new Vertex("Princeton");
         Vertex h = new Vertex("Pueblo");
         a.addEdge(h);
         b.addEdge(d);
         c.addEdge(f);
         c.addEdge(h);
         d.addEdge(f);
         d.addEdge(h);
         e.addEdge(a);
         f.addEdge(b);
         g.addEdge(f);
         g.addEdge(g);
         h.addEdge(e);
         List<Vertex> list = new ArrayList<Vertex>();
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
     
      public static List<Vertex> read2() throws FileNotFoundException
      {
        
         Scanner infile = new Scanner(new File("cities.txt"));
         List<Vertex> list = new ArrayList<Vertex>();
         while(infile.hasNext())
            list.add(new Vertex(infile.next()));
         Scanner g = new Scanner(new File("citydata.txt"));
         int r = g.nextInt();
         int c = g.nextInt();
         int[][] array = new int[r][c];
         for(int x = 0; x < r; x++)
         {
            for(int i = 0; i < c; i++)
            {
               array[x][i] = infile.nextInt();
            }
         }
         infile.close();
         return array;
      }
      public static List<Vertex> findReachableDepth(Vertex v)
      {
         Stack<Vertex> stack = new Stack<Vertex>();
         List<Vertex> list = new ArrayList<Vertex>();
         List<Vertex> edges = new ArrayList<Vertex>();
         stack.push(v);
         while(!stack.isEmpty())
         {
            Vertex v1 = stack.pop();
            list.add(v1);
            edges = v1.getEdges();
            for(int x = 0; x < edges.size(); x++)
            {
               if(!list.contains(edges.get(x)))
                  stack.push(edges.get(x));
            }
         }
         return list;
      }
      //public static List<Vertex> findReachableBreadth(Vertex v)
      {
      
      }
     //  public static List<Vertex> findReachableRecur(Vertex v)
      // {
         // ArrayList<Vertex> reachable = new ArrayList<Vertex>();
         // findReachableRecurHelper(v, reachable);
         // return reachable;
      // }  
   	
      //private static void findReachableRecurHelper(Vertex v, ArrayList<Vertex> reachable)
      {
      
      }
   }