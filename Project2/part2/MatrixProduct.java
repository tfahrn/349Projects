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

         for(int i = startRowA; i < startRowA + n/2; i++){
           for(int k = startColA; k < startColA + n/2; k++){
               C[i][k] = C11[i][k];
           }
         }    

         for(int i = startRowA; i < startRowA + n/2; i++){
           for(int k = startColA + n/2; k < A.length; k++){
               System.out.println("n: " + n);
               C[i][k] = C12[i][k];
          }
         }    

         for(int i = startRowA + n/2; i < A.length; i++){
           for(int k = startColA; k < startColA + n/2; k++){
               C[i][k] = C21[i][k];
           }
         }    
         for(int i = startRowA + n/2; i < A.length; i++){
           for(int k = startColA + n/2; k < A.length; k++){
               C[i][k] = C22[i][k];
           }
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
