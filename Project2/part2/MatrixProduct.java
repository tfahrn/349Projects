import java.lang.*;

public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) throws IllegalArgumentException {
   
      if(!isValidMultiplication(A, B)) {
         throw new IllegalArgumentException("Invalid matrices");
      }
   
      return matrixProduct_DAC(A,0,0,B,0,0,A.length);
   }

   private static int[][] matrixProduct_DAC(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {

      int[][] C = new int[n][n];
      
      if(n == 1) {
         C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
      }
      else {
         int[][] C11 = addMatrices(matrixProduct_DAC(A, startRowA+0, startColA+0, B, startRowB+0, startColB+0, n/2), matrixProduct_DAC(A, startRowA+0, startColA+n/2, B, startRowB+n/2, startColB+0, n/2)); 

         int[][] C12 = addMatrices(matrixProduct_DAC(A, startRowA+0, startColA+0, B, startRowB+0, startColB+n/2, n/2), matrixProduct_DAC(A, startRowA+0, startColA+n/2, B, startRowB+n/2, startColB+n/2, n/2));

         int[][] C21 = addMatrices(matrixProduct_DAC(A, startRowA+n/2, startColA+0, B, startRowB+0, startColB+0, n/2), matrixProduct_DAC(A, startRowA+n/2, startColA+n/2, B, startRowB+n/2, startColB+0, n/2));

         int[][] C22 = addMatrices(matrixProduct_DAC(A, startRowA+n/2, startColA+0, B, startRowB+0, startColB+n/2, n/2), matrixProduct_DAC(A, startRowA+n/2, startColA+n/2, B, startRowB+n/2, startColB+n/2, n/2));

         int row = 0;
         int col = 0;

         for(int subrow = 0; subrow < C11.length; subrow++) {
            for(int subcol = 0; subcol < C11[0].length; subcol++) {
               C[row][col] = C11[subrow][subcol];

               col++;
            }

            col = 0;
            row++;
         }

         row = 0;
         col = n/2;

         for(int subrow = 0; subrow < C12.length; subrow++) {
            for(int subcol = 0; subcol < C12[0].length; subcol++) {
               C[row][col] = C12[subrow][subcol];

               col++;
            }

            col = n/2;
            row++;
         }

         row = n/2;
         col = 0;

         for(int subrow = 0; subrow < C21.length; subrow++) {
            for(int subcol = 0; subcol < C21[0].length; subcol++) {
               C[row][col] = C21[subrow][subcol];

               col++;
            }

            col = 0;
            row++;
         }

         row = n/2;
         col = n/2;

         for(int subrow = 0; subrow < C22.length; subrow++) {
            for(int subcol = 0; subcol < C22[0].length; subcol++) {
               C[row][col] = C22[subrow][subcol];

               col++;
            }

            col = n/2;
            row++;
         }
      }

      return C;    
   }

   private static int[][] addMatrices(int[][] A, int[][] B) {
      for(int row = 0; row < A.length; row++) {
         for(int col = 0; col < A[0].length; col++) {
            A[row][col] += B[row][col];
         }
      }

      return A;
   }

   private static void printMatrix(int[][] matrix) {
      for(int row = 0; row < matrix.length; row++) {
         System.out.println();
         for(int col = 0; col < matrix[0].length; col++) {
            System.out.print(matrix[row][col] + " ");
         }
      }
   }
   
   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) throws IllegalArgumentException {
   
      if(!isValidMultiplication(A, B)) {
         throw new IllegalArgumentException("Invalid matrices");
      }
   
   
      return null;
   }
   
   public static boolean isValidMultiplication(int[][] A, int[][] B) {
      
      //check both are square matrices
      //TODO: check assumptions on input
      if(A.length != A[0].length || B.length != B[0].length) {
         return false;
      }
   
      //check same size
      if(A.length != B.length) {
         return false;
      }
   
      //check size is power of 2
      if((A.length & (A.length - 1)) != 0) {
         return false;
      }
   
      return true;
   }
}
