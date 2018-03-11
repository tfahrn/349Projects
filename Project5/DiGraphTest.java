import java.util.*;
import java.io.*;

public class DiGraphTest {

   public static void main(String[] args) {

      System.out.println("Enter the number of vertices: ");
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();
      input.nextLine();

      DiGraph myGraph = new DiGraph(N);

      char nextInput = 'o';
      
      System.out.println("Choose one of the following operations:\n- add edge (enter a)\n- delete edge (enter d)\n- edge count (enter e)\n- vertex count(enter v)\n- print graph (enter p)\n- topological sort (enter t)\n- is path (enter i)\n- length of path (enter l)\n- shortest path (enter s)\n- print breadth-first-tree (enter b)\n- Quit (enter q)");

      while(nextInput != 'q') {


         String nextLine = input.nextLine();

         if(nextLine.length() != 1) {
            System.out.println("Invalid menu choice"); 
            continue;
         }
         
         nextInput = nextLine.charAt(0);

         if(nextInput == 'a' || nextInput == 'd') {
            System.out.println("Enter the from index: ");
            int fromIndex = input.nextInt();
            System.out.println("Enter the to index: ");
            int toIndex = input.nextInt();
            input.nextLine();

            if(nextInput == 'a') {
               myGraph.addEdge(fromIndex, toIndex);
            }
            else {
               myGraph.deleteEdge(fromIndex, toIndex);
            }
         }
         else if(nextInput == 'e') {
            System.out.println("Number of edges is: " + myGraph.edgeCount());
         }
         else if(nextInput == 'v') {
            System.out.println("Number of vertices is: " + myGraph.vertexCount());
         }
         else if(nextInput == 'p') {
            myGraph.print();
         }
         else if(nextInput == 't') {
            int[] topSort;

            try {
               topSort = myGraph.topSort();
            }
            catch(Exception e) {
               System.out.println("Graph is cyclic");
               continue;
            }

            System.out.print("Topological sort: ");
            for(int i = 0; i < topSort.length-1; i++) {
               System.out.print(topSort[i] + ", ");
            }
            System.out.println(topSort[topSort.length-1]);
         }
         else if(nextInput == 'i' || nextInput == 'l' || nextInput == 's') {
            System.out.println("Enter the from index: ");
            int from = input.nextInt()-1;
            System.out.println("Enter the to index: ");
            int to = input.nextInt()-1;
            input.nextLine();

            if(nextInput == 'i') {
               if(myGraph.isTherePath(from, to)) {
                  System.out.println("There is a path from " + (from + 1) + " to " + (to + 1));
               }
               else {
                  System.out.println("No path exists from " + (from + 1) + " to " + (to + 1));
               }
            }
            else if(nextInput == 'l') {
               System.out.println("Length of path from " + (from+1) + " to " + (to + 1) + " is " + myGraph.lengthOfPath(from, to));
            }
            else if(nextInput == 's') {
               String path = myGraph.printPath(from, to);

               if(path == null) {
                  System.out.println("No path exists from " + (from + 1) + " to " + (to + 1));
               }
               else {
                  System.out.println("Path: " + path);
               }
            }
         }
         else if(nextInput == 'b') {
            System.out.println("Enter the source index: ");
            int from = input.nextInt()-1;
            input.nextLine();

            myGraph.printTree(from);
         }
         else if(nextInput != 'q'){
            System.out.println("Invalid menu choice");
         }

      }

      System.out.println("Goodbye.");
   }
}
