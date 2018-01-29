public class MatrixTest {

   public static void main(String[] args) {
      System.out.println("testIsValid1: " + testIsValid1());
      System.out.println("testIsValid2: " + testIsValid2());
      System.out.println("testIsValid3: " + testIsValid3());
      System.out.println("testIsValid4: " + testIsValid4());


      System.out.println("testDAC1: " + testDAC1());


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
      int[][] B = {{3,4},{1,2}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      for(int row = 0; row < A.length; row++) {
         for(int col = 0; col < A[0].length; col++) {
            System.out.print(C[row][col] + " ");
         }
      }

      return true;
   }
}
