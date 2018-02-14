import java.util.*;
import java.io.*;
import java.lang.*;

public class GameProblem {

   public static void main(String[] args) throws FileNotFoundException {

      System.out.println("Please provide input file name: ");

      Scanner input = new Scanner(System.in);
      String fileName = input.nextLine();
      File file = new File(fileName);
      Scanner sc = new Scanner(file);

      int n = sc.nextInt();
      int m = sc.nextInt();

      int[][] A = new int[n][m];

      for(int i = 0; i < n; i++) {
         for(int j = 0; j < m; j++) {
            A[i][j] = sc.nextInt();
         }
      }

      /*
      System.out.println("n: " + n);
      System.out.println("m: " + m);
      for(int row = 0; row < n; row++) {
         System.out.println(Arrays.toString(A[row]));
      }
      */

      game(n, m, A);
   }

   public static void game(int n, int m, int[][] A) {

      int[][] S = new int[n][m];
      char[][] R = new char[n][m];
      int max = Integer.MIN_VALUE;
      int maxRow = 0;
      int maxCol = 0;

      for(int row = n-1; row >= 0; row--) {
         for(int col = m-1; col >= 0; col--) {
            if(row == n-1 && col == m-1) {
               S[row][col] = A[row][col];
               R[row][col] = 'e';
            }
            else if(col == m-1) {
               S[row][col] = Math.max(S[row+1][col], 0) + A[row][col];
               R[row][col] = (S[row+1][col] > 0) ? 'd' : 'e';
            }
            else if(row == n-1) {
               S[row][col] = Math.max(S[row][col+1], 0) + A[row][col];
               R[row][col] = (S[row][col+1] > 0) ? 'r' : 'e';
            }
            else {
               S[row][col] = Math.max(S[row+1][col], S[row][col+1]) + A[row][col];
               R[row][col] = (S[row+1][col] > S[row][col+1]) ? 'd' : 'r';
            }

            if(S[row][col] > max) {
               max = S[row][col];
               maxRow = row;
               maxCol = col;
            }
         }
      }

      System.out.println("Best score: " + max);
      System.out.print("Best route: ");

      while(R[maxRow][maxCol] != 'e') {
         System.out.print("[" + (maxRow + 1) + "," + (maxCol + 1) + "] to ");
         if(R[maxRow][maxCol] == 'd') {
            maxRow++;
         }
         else {
            maxCol++;
         }
      }
      
      System.out.print("[" + (maxRow + 1) + "," + (maxCol + 1) + "] to ");
      System.out.println("exit");
   }
}
