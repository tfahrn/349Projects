import java.util.*;
import java.io.*;

public class DiGraphTest {

   public static void main(String[] args) {

      System.out.println("Enter the number of vertices: ");
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();

      DiGraph myGraph = new DiGraph(N);

      char nextInput = 'o';

      while(nextInput != 'q') {
         System.out.println("Choose one of the following operations:\n- add edge (enter a)\n- delete edge (enter d)\n- edge count (enter e)\n- vertex count(enter v)\n- print graph (enter p)\n- Quit (enter q)");

         nextInput = input.next().charAt(0);

         if(nextInput == 'a' || nextInput == 'd') {
            System.out.println("Enter the from index: ");
            System.out.println("Enter the to index: ");
            int fromIndex = input.nextInt();
            int toIndex = input.nextInt();

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
      }

      System.out.println("Goodbye.");
   }
}
