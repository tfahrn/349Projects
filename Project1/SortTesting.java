import java.util.Arrays;

public class SortTesting {

   public static void main(String[] args) {
      int[] testArr1 = {3, 5, 6, 3, 3, -2, 9, 3};

      System.out.println("Pre sort: " + Arrays.toString(testArr1));
      /*
      Sorts.selectionSort(testArr1, testArr1.length);
      System.out.println("Post sort: " + Arrays.toString(testArr1));
      */


      /*
      Sorts.mergeSort(testArr1, testArr1.length);
      System.out.println("Post sort: " + Arrays.toString(testArr1));
      */

      Sorts.quickSort(testArr1, testArr1.length);
      System.out.println("Post sort: " + Arrays.toString(testArr1));


   }




}
