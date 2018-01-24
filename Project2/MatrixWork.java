import java.util.*;
import java.io.*;
public class MatrixWork{
   public static int[][] matrixProduct(int[][] A, int[][]B) throws IllegalArgumentException{

      if(A[0].length != B.length)
         throw new IllegalArgumentException();
      int[][] productMatrix = new int[A.length][B[0].length];
      for(int i = 0; i < A.length; i++){
         for(int j = 0; j < B[0].length ;j++){
            int sum = 0;
            for(int l = 0; l < B.length; l++){
               sum += A[i][l] * B[l][j];
            }
            productMatrix[i][j] = sum;

         }
      }
      return productMatrix;
   }

   public static void main(String args[]) throws FileNotFoundException{
      System.out.println("Please provide inout file name: ");
      Scanner input = new Scanner(System.in);
      String fileName = input.nextLine();
      File file = new File(fileName);
      Scanner sc = new Scanner(file);
      int aRow = sc.nextInt();
      int aCol = sc.nextInt();
      int[][] A = new int[aRow][aCol];
      for(int i = 0; i < aRow; i++){
         for(int j = 0; j < aCol; j++){
            A[i][j] = sc.nextInt();
         }
      }
      int bRow = sc.nextInt();
      int bCol = sc.nextInt();
      int[][] B = new int[bRow][bCol];
      for(int i = 0; i < bRow; i++){
         for(int j = 0; j < bCol; j++){
            B[i][j] = sc.nextInt();
         }
      }
      try{
         int[][] productMatrix = matrixProduct(A,B);
         System.out.println("Product Matrix\n");
         for(int i = 0; i < productMatrix.length; i++){
            System.out.println();
            for(int j = 0; j < productMatrix[0].length; j++){
               System.out.print(productMatrix[i][j] + " ");
            }
      }
      System.out.println();


      }
      catch (IllegalArgumentException e){
         System.out.println("Incorrect file format\n");
      }



   }
}
