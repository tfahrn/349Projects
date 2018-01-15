import java.util.Arrays;

public class SortTesting {

   public static void main(String[] args) {
      int[] testArr1 = {3, 5, 6, 2, -1, 3, 3, -5};

      System.out.println("Pre sort: " + Arrays.toString(testArr1));
      /*
      Sorts.selectionSort(testArr1, testArr1.length);
      System.out.println("Post sort: " + Arrays.toString(testArr1));
      */


      Sorts.mergeSort(testArr1, testArr1.length);
      System.out.println("Post sort: " + Arrays.toString(testArr1));


   }




}
