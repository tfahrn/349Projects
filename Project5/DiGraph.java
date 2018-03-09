import java.util.*;

public class DiGraph {

   private LinkedList<Integer>[] graph;

   public DiGraph(int N) {
      graph = new LinkedList[N];
   }

   public void addEdge(int from, int to) {
      int fromIndex = from-1;
      int toIndex = to-1;

      //from vertex does not exist
      if(graph[fromIndex] == null) {
         graph[fromIndex] = new LinkedList<Integer>();
      }

      if(!pathExists(fromIndex, toIndex) && !(graph[fromIndex].contains(toIndex))) {
         graph[fromIndex].add(toIndex);
         System.out.println("(" + (fromIndex+1) + "," + (toIndex+1) + ") edge is now added to the graph");
      }
   }

   private boolean pathExists(int fromIndex, int toIndex) {
      if(graph[fromIndex] == null || graph[fromIndex].size() > 0) {
         return false;
      }

      for(int i : graph[fromIndex]) {
         if(i == toIndex) {
            return true;
         }
      }

      return false;
   }

   //check edge exists?
   public void deleteEdge(int from, int to) {
      int fromIndex = from-1;
      int toIndex = to-1;

      graph[fromIndex].removeFirstOccurrence(toIndex);
   }

   public int edgeCount() {
      int count = 0;

      for(int fromIndex = 0; fromIndex < graph.length; fromIndex++) {
         if(graph[fromIndex] != null && graph[fromIndex].size() > 0) {
            for(int toIndex : graph[fromIndex]) {
               count += 1;
            }
         }
      }

      return count;
   }

   public int vertexCount() {
      return graph.length;
   }

   public void print() {
      for(int fromIndex = 0; fromIndex < graph.length; fromIndex++) {
         System.out.print((fromIndex+1) + " is connected to: ");

         if(graph[fromIndex] != null && graph[fromIndex].size() > 0) {
            for(int i = 0; i < graph[fromIndex].size()-1; i++) {
               System.out.print((graph[fromIndex].get(i)+1) + ", ");
            }
            System.out.print(graph[fromIndex].get(graph[fromIndex].size()-1) + 1);
         }

         System.out.println();
      }
   }

   private int[] indegrees() {
      int[] indegrees = new int[graph.length];

      for(LinkedList<Integer> fromVertex : graph) {
         if(fromVertex != null && fromVertex.size() > 0) {
            for(int toIndex : fromVertex) {
               indegrees[toIndex] += 1;
            }
         }
      }

      return indegrees;
   }

   public int[] topSort() {
      int[] indegrees = indegrees();
      int[] topSort = new int[graph.length];

      LinkedList<Integer> waiting = new LinkedList<Integer>();

      for(int toIndex = 0; toIndex < indegrees.length; toIndex++) {
         if(indegrees[toIndex] == 0) {
            waiting.add(toIndex);
         }
      }

      int topSortIndex = 0;

      while(waiting.peek() != null) {
         int toIndex = waiting.remove();
         topSort[topSortIndex] = toIndex+1;
         topSortIndex += 1;

         if(graph[toIndex] != null && graph[toIndex].size() > 0) {
            for(int totoIndex : graph[toIndex]) {
               indegrees[totoIndex] -= 1;
               if(indegrees[totoIndex] == 0) {
                  waiting.add(totoIndex);
               }
            }
         }
      }

      //check for cycle
      if(topSortIndex != graph.length) {
         throw new IllegalArgumentException();
      }

      return topSort;
   }
}
