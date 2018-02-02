import java.lang.*;

public class MatrixTest {

   public static void main(String[] args) {
      /*
      System.out.println("testIsValid1: " + testIsValid1());
      System.out.println("testIsValid2: " + testIsValid2());
      System.out.println("testIsValid3: " + testIsValid3());
      System.out.println("testIsValid4: " + testIsValid4());
      System.out.println("testIsValid5: " + testIsValid5());
      */

      System.out.println("testDAC1: " + testDAC1());
      System.out.println("testStrassen1: " + testStrassen1());

      System.out.println("testDAC2: " + testDAC2());
      System.out.println("testStrassen2: " + testStrassen2());

      System.out.println("testDAC3: " + testDAC3());
      System.out.println("testStrassen3: " + testStrassen3());

      System.out.println("testDAC4: " + testDAC4());
      System.out.println("testStrassen4: " + testStrassen4());
      
      System.out.println("testDAC5: " + testDAC5());
      System.out.println("testStrassen5: " + testStrassen5());
      
      System.out.println("testDAC6: " + testDAC6());
      System.out.println("testStrassen6: " + testStrassen6());

      System.out.println("testDAC7: " + testDAC7());
      System.out.println("testStrassen7: " + testStrassen7());
   }

   /*
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

   private static boolean testIsValid5() {
      int[][] A = {{2,3},{2,3},{2,3}};
      int[][] B = {{3,4},{1,2},{2,3}};

      return MatrixProduct.isValidMultiplication(A, B) == false;
   }
   */

   private static boolean testDAC1() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,2},{3,4}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
      int[][] result = {{7,10},{15,22}};

      return isEqual(C, result); 
   }
   
   private static boolean testStrassen1() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,2},{3,4}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      int[][] result = {{7,10},{15,22}};

      return isEqual(C, result); 
   }

   private static boolean testDAC2() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,1},{1,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
      int[][] result = {{3,3},{7,7}};

      return isEqual(C, result);
   }
   
   private static boolean testStrassen2() {
      int[][] A = {{1,2},{3,4}};
      int[][] B = {{1,1},{1,1}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      int[][] result = {{3,3},{7,7}};

      return isEqual(C, result); 
   }

   private static boolean testDAC3() {
      int[][] A = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
      int[][] result = {{40,30,20,10},{40,30,20,10},{40,30,20,10},{40,30,20,10}};

      return isEqual(C, result); 
   }

   private static boolean testStrassen3() {
      int[][] A = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      int[][] result = {{40,30,20,10},{40,30,20,10},{40,30,20,10},{40,30,20,10}};

      printMatrix(C);

      return isEqual(C, result); 
   }

   private static boolean testDAC4() {
      int[][] A = {{3,4,-2,5},{2,-5,-1,0},{0,2,4,3},{3,-2,1,9}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
      int[][] result = {{40,30,20,10},{-16,-12,-8,-4},{36,27,18,9},{44,33,22,11}};
      
      return isEqual(C, result); 
   }
   
   private static boolean testStrassen4() {
      int[][] A = {{3,4,-2,5},{2,-5,-1,0},{0,2,4,3},{3,-2,1,9}};
      int[][] B = {{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      int[][] result = {{40,30,20,10},{-16,-12,-8,-4},{36,27,18,9},{44,33,22,11}};
      
      return isEqual(C, result); 
   }

   private static boolean testDAC5() {
      int[][] A = {{3}};
      int[][] B = {{-3}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
      int[][] result = {{-9}};
      
      return isEqual(C, result); 
   }
   
   private static boolean testStrassen5() {
      int[][] A = {{3}};
      int[][] B = {{-3}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      int[][] result = {{-9}};
      
      return isEqual(C, result); 
   }

   private static boolean testDAC6() {
      int[][] A = {{}};
      int[][] B = {{}};
      int[][] C;

      try {
         C = MatrixProduct.matrixProduct_DAC(A, B);
      }
      catch(IllegalArgumentException e) {
         return true;
      }

      return false;
   }
   
   private static boolean testStrassen6() {
      int[][] A = {{}};
      int[][] B = {{}};
      int[][] C;

      try {
         C = MatrixProduct.matrixProduct_Strassen(A, B);
      }
      catch(IllegalArgumentException e) {
         return true;
      }

      return false;
   }

   private static boolean testDAC7() {
      int[][] A = {{1,2,3,4,5,6,7,8},{-2,3,4,7,-3,0,2,1},{4,-2,3,0,0,5,-6,-3},{5,6,2,1,3,4,-3,2},{-5,3,-2,-1,-1,-1,-1,5},{4,2,3,5,1,2,3,4},{-2,0,0,0,-3,3,5,5},{3,2,1,4,-3,2,4,5}};
      int[][] B = {{1,2,3,4,5,6,7,8},{-2,3,4,7,-3,0,2,1},{4,-2,3,0,0,5,-6,-3},{5,6,2,1,3,4,-3,2},{-5,3,-2,-1,-1,-1,-1,5},{4,2,3,5,1,2,3,4},{-2,0,0,0,-3,3,5,5},{3,2,1,4,-3,2,4,5}};
      int[][] C = MatrixProduct.matrixProduct_DAC(A, B);

      int[][] result = {{38,69,44,79,-33,81,61,133},{57,32,39,27,-4,47,-36,-11},{43,0,25,15,58,25,-21,-4},{19,51,55,88,14,44,34,68},{-6,2,-7,16,-49,-38,-1,-22},{46,53,47,60,9,79,35,83},{30,3,14,30,-34,22,43,31},{53,39,45,63,-1,68,56,69}};
      
      return isEqual(C, result); 
   }

   private static boolean testStrassen7() {
      int[][] A = {{1,2,3,4,5,6,7,8},{-2,3,4,7,-3,0,2,1},{4,-2,3,0,0,5,-6,-3},{5,6,2,1,3,4,-3,2},{-5,3,-2,-1,-1,-1,-1,5},{4,2,3,5,1,2,3,4},{-2,0,0,0,-3,3,5,5},{3,2,1,4,-3,2,4,5}};
      int[][] B = {{1,2,3,4,5,6,7,8},{-2,3,4,7,-3,0,2,1},{4,-2,3,0,0,5,-6,-3},{5,6,2,1,3,4,-3,2},{-5,3,-2,-1,-1,-1,-1,5},{4,2,3,5,1,2,3,4},{-2,0,0,0,-3,3,5,5},{3,2,1,4,-3,2,4,5}};
      int[][] C = MatrixProduct.matrixProduct_Strassen(A, B);
      
      int[][] result = {{38,69,44,79,-33,81,61,133},{57,32,39,27,-4,47,-36,-11},{43,0,25,15,58,25,-21,-4},{19,51,55,88,14,44,34,68},{-6,2,-7,16,-49,-38,-1,-22},{46,53,47,60,9,79,35,83},{30,3,14,30,-34,22,43,31},{53,39,45,63,-1,68,56,69}};

      return isEqual(C, result); 
   }

   private static void printMatrix(int[][] matrix) {
      for(int row = 0; row < matrix.length; row++) {
         System.out.println();
         for(int col = 0; col < matrix[0].length; col++) {
            System.out.print(matrix[row][col] + " ");
         }
      }
   }

   private static boolean isEqual(int[][] A, int[][] B) {
      if(A.length != B.length || A[0].length != B[0].length) {
         return false;
      }

      for(int row = 0; row < A.length; row++) {
         for(int col = 0; col < A[0].length; col++) {
            if(A[row][col] != B[row][col]) {
               return false;
            }
         }
      }

      return true;
   }
}
