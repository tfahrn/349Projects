import java.util.Arrays;
import java.util.Random;

public class SortTesting {

   public static void main(String[] args) {
      Random rnd = new Random();

      int[] testArray1 = new int[200000];
      int[] testArray2 = new int[200000];
      int[] testArray3 = new int[200000];
      int[] sortedArray = new int[200000];
      for(int i = 0; i < testArray1.length; i++) {
         testArray1[i] = rnd.nextInt();
         testArray2[i] = testArray1[i];
         testArray3[i] = testArray1[i];
         sortedArray[i] = testArray1[i];
      }

      Arrays.sort(sortedArray);

      Sorts.selectionSort(testArray1, 200000);

      for(int i = 0; i < testArray1.length; i++) {
         if(testArray1[i] != sortedArray[i]) {
            System.out.println("failed selectionsort");
         }
      }

      Sorts.mergeSort(testArray2, 200000);

      for(int i = 0; i < testArray2.length; i++) {
         if(testArray1[i] != sortedArray[i]) {
            System.out.println("failed quicksort");
         }
      }

      Sorts.quickSort(testArray3, 200000);

      for(int i = 0; i < testArray3.length; i++) {
         if(testArray1[i] != sortedArray[i]) {
            System.out.println("failed quicksort");
         }
      }


   }




}
