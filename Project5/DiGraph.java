/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 3/14/2018
 * Project 5
 */

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

   private class VertexInfo {
      //distance from s
      private int distance;
      //index of predecessor on path from s
      private int parent;

      public VertexInfo(int d, int p) {
         this.distance = d;
         this.parent = p;
      }

      public void setDistance(int d) {
         this.distance = d;
      }
      public int getDistance() {
         return this.distance;
      }

      public void setParent(int p) {
         this.parent = p;
      }
      public int getParent() {
         return this.parent;
      }
   }

   private VertexInfo[] BFS(int s) {
      int N = graph.length;
      VertexInfo[] VA = new VertexInfo[N];

      for(int i = 0; i < N; i++) {
         VA[i] = new VertexInfo(-1, -1);
      }

      VA[s].setDistance(0);

      LinkedList<Integer> queue = new LinkedList<Integer>();
      queue.add(s);

      while(queue.size() != 0) {
         int u = queue.remove();

         if(graph[u] != null) {
            for(int v : graph[u]) {
               if(VA[v].getDistance() == -1) {
                  VA[v].setDistance(VA[u].getDistance() + 1);
                  VA[v].setParent(u);
                  queue.add(v);
               }
            }
         }
      }

      return VA;
   }

   public boolean isTherePath(int from, int to) {
      VertexInfo[] VA = BFS(from);

      if(VA[to].getDistance() != -1) {
         return true;
      }

      return false;
   }

   public int lengthOfPath(int from, int to) {
      VertexInfo[] VA = BFS(from);
      
      return VA[to].getDistance();
   }

   public String printPath(int from, int to) {
      VertexInfo[] VA = BFS(from);

      if(VA[to].getDistance() == -1) {
         return null;
      }
      else {
         StringBuilder sb = new StringBuilder();

         while(from != to) {
            sb.append((to+1) + ">--");
            to = VA[to].getParent();
         }

         sb.append((from+1));

         return sb.reverse().toString();
      }
   }

   private class TreeNode {
      private int vertexNumber;
      private LinkedList<TreeNode> children;

      public TreeNode(int vertexNumber) {
         this.vertexNumber = vertexNumber;
      }

      public void addChild(TreeNode child) {
         if(this.children == null) {
            this.children = new LinkedList<TreeNode>();
         }

         this.children.add(child);
      } 

      public LinkedList<TreeNode> getChildren() {
         return this.children;
      }
   }

   private TreeNode buildTree(int s) {
      VertexInfo[] VA = BFS(s);
      TreeNode[] allNodes = new TreeNode[VA.length];

      for(int i = 0; i < VA.length; i++) {
         allNodes[i] = new TreeNode(i);
      }

      for(int i = 0; i < VA.length; i++) {
         for(int j = 0; j < VA.length; j++) {
            if(i != j) {
               if(VA[j].getParent() == i) {
                  allNodes[i].addChild(allNodes[j]);
               }
            }
         }
      }

      return allNodes[s];
   }

   public void printTree(int s) {
      TreeNode root = buildTree(s);

      printTreeRecur(root, 0);
   }

   private void printTreeRecur(TreeNode curRoot, int numSpaces) {
      for(int i = 0; i < numSpaces; i++) {
         System.out.print(" ");
      }

      System.out.println(curRoot.vertexNumber + 1);

      if(curRoot.getChildren() != null) {
         for(TreeNode child : curRoot.getChildren()) {
            printTreeRecur(child, numSpaces + 4);
         }
      }
   }
}
