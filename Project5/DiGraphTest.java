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
      
      System.out.println("Choose one of the following operations:\n- add edge (enter a)\n- delete edge (enter d)\n- edge count (enter e)\n- vertex count(enter v)\n- print graph (enter p)\n- topological sort (enter t)\n- Quit (enter q)");

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
         else if(nextInput != 'q'){
            System.out.println("Invalid menu choice");
         }

      }

      System.out.println("Goodbye.");
   }
}
