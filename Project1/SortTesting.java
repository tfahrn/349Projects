import java.util.Arrays;
import java.util.Random;

public class SortTesting {

   public static void main(String[] args) {
      Random rnd = new Random();
      
      for(int sizeArr = 0; sizeArr < 20; sizeArr++) {
         int[] testArr = new int[sizeArr];

         for(int i = 0; i < sizeArr; i++) {
            testArr[i] = rnd.nextInt() % 1000;
         }

         int[] ssTest = testArr.clone();
         int[] msTest = testArr.clone();
         int[] qsTest = testArr.clone();
         int[] sortedArr = testArr.clone();

         Arrays.sort(sortedArr);
         
         Sorts.selectionSort(ssTest, sizeArr);
         Sorts.mergeSort(msTest, sizeArr);
         Sorts.quickSort(qsTest, sizeArr);

         if(!Arrays.equals(ssTest, sortedArr)) {
            System.out.println("Selection sort failed on test: " + Arrays.toString(testArr));
         }
         if(!Arrays.equals(msTest, sortedArr)) {
            System.out.println("Merge sort failed on test: " + Arrays.toString(testArr));
         }
         if(!Arrays.equals(qsTest, sortedArr)) {
            System.out.println("Quick sort failed on test: " + Arrays.toString(testArr));
            System.out.println("Expected: " + Arrays.toString(sortedArr));
            System.out.println("Actual: " + Arrays.toString(qsTest));
         }
      }
   }
}
