public class MatrixTest {

   public static void main(String[] args) {
      System.out.println("testIsValid1: " + testIsValid1());
      System.out.println("testIsValid2: " + testIsValid2());
      System.out.println("testIsValid3: " + testIsValid3());
      System.out.println("testIsValid4: " + testIsValid4());


      System.out.println("testDAC1: " + testDAC1());
      System.out.println("testStrassen1: " + testStrassen1());
      /*
      System.out.println("testDAC2: " + testDAC2());
      System.out.println("----testing dac3-----");
      System.out.println("testDAC3: " + testDAC3());
      System.out.println("----testing dac4-----");
      System.out.println("testDAC4: " + testDAC4());
      */


   }

   private static boolean testIsValid1() {
      int[][] A = {{2,3,4},{2,3,4}};
      int[][] B = {{1}};

      return MatrixProduct.isValidMultiplication(A, B) == false;
   }

   private static boolean testIsValid2() {
      int[][] A = {{2,3,4},{2,3,4}};
      int[][] B = {{1},{3,4,5}};

      return MatrixProduct.isValidMultiplication(A, B) == false;
   }
   
   private static boolean testIsValid3() {
      int[][] A = {{2,3,4},{2,3,4}};
      int[][] B = {{3,4,5},{1}};

      return MatrixProduct.isValidMultiplication(A, B) == false;
   }
   
   private static boolean testIsValid4() {
      int[][] A = {{2,3},{2,3}};
      int[][] B = {{3,4},{1,2}};

      return MatrixProduct.isValidMultiplication(A, B) == true;
   }

   private static boolean testDAC1() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,2},{3,4}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      printMatrix(C);

      return true;
   }

   private static boolean testDAC2() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,1},{1,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      printMatrix(C);

      return true;
   }

   private static boolean testDAC3() {
      int[][] A = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      printMatrix(C);

      return true;
   }

   private static boolean testDAC4() {
      int[][] A = {{3,4,-2,5},{2,-5,-1,0},{0,2,4,3},{3,-2,1,9}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      printMatrix(C);

      return true;
   }
   
   private static boolean testStrassen1() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,2},{3,4}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);

      printMatrix(C);

      return true;
   }

   private static void printMatrix(int[][] matrix) {
      for(int row = 0; row < matrix.length; row++) {
         System.out.println();
         for(int col = 0; col < matrix[0].length; col++) {
            System.out.print(matrix[row][col] + " ");
         }
      }
   }
}
