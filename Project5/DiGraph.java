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

      if(!pathExists(fromIndex, toIndex)) {
         graph[fromIndex].add(toIndex);
      }
   }

   private boolean pathExists(int fromIndex, int toIndex) {
      if(graph[fromIndex] == null) {
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
         if(graph[fromIndex] != null) {
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

         for(int i = 0; i < graph[fromIndex].size()-1; i++) {
            System.out.print((graph[fromIndex].get(i)+1) + ", ");
         }
         System.out.print(graph[fromIndex].get(graph[fromIndex].size()-1) + 1);
      }
   }


}
