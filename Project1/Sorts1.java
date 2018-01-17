public class Sorts1 {
   private static long selectionSortCounter = 0;
   private static long mergeSortCounter = 0;
   private static long quickSortCounter = 0;

   public static long selectionSort(int[] arr, int N) {

      selectionSortCounter = 0;

      for(int curIndex = 0; curIndex < N; curIndex++) {
         int curMin = arr[curIndex];
         int curMinIndex = curIndex;

         for(int movingIndex = curIndex + 1; movingIndex < N; movingIndex++) {

            selectionSortCounter += 1;

            if(arr[movingIndex] < curMin) {
               curMin = arr[movingIndex];
               curMinIndex = movingIndex;
            }
         }

         int tmp = arr[curIndex];
         arr[curIndex] = curMin;
         arr[curMinIndex] = tmp;
      }

      return selectionSortCounter;
   }

   public static long mergeSort(int[] arr, int N ) {
      mergeSortCounter = 0;

      mergeSort(arr, 0, N-1);
      return mergeSortCounter;
   }

   private static void mergeSort(int[] list, int first, int last) {
      if(first < last) {
         int middleIndex = (first+last)/2;

         mergeSort(list, first, middleIndex);
         mergeSort(list, middleIndex+1, last);

         mergeSortedHalves(list, first, middleIndex, last);
      }
   }

   /*
    * left,middle,right are indices
    */
   private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
      int[] tmp = new int[right-left+1];

      int i = left;
      int j = middle+1;
      int k = 0;

      while(i <= middle && j <= right) {
         mergeSortCounter += 1;

         if(arr[i] < arr[j]) {
            tmp[k] = arr[i];
            i++;
         }
         else if(arr[i] >= arr[j]) {
            tmp[k] = arr[j];
            j++;
         }

         k++;
      }

      while(i <= middle) {
         tmp[k] = arr[i];
         i++;
         k++;
      }
      while(j <= right) {
         tmp[k] = arr[j];
         j++;
         k++;
      }

      k = 0;
      for(i = left; i <= right; i++) {
         arr[i] = tmp[k];
         k++;
      }
   }

   public static long quickSort(int[] arr, int N) {
      quickSortCounter = 0;

      quickSort(arr, 0, N-1);
      return quickSortCounter;

   }

   private static void quickSort(int[] list, int first, int last) {
      if(first < last) {
         setPivotToEnd(list, first, last);
         int pivotIndex = splitList(list, first, last);

         quickSort(list, first, pivotIndex-1);
         quickSort(list, pivotIndex+1, last);
      }
   }

   private static void setPivotToEnd(int[] arr, int left, int right) {
      int middle = (left+right)/2;

      int smallest;
      int median;
      int biggest;

      quickSortCounter += 2;

      /* TODO
       * split if statements:
       * count++
       * if:
       *    count++:
       *    if:
       */

      if(arr[left] <= arr[middle] && arr[middle] <= arr[right]) {
         smallest = arr[left];
         median = arr[middle];
         biggest = arr[right];
      }
      else if(arr[left] >= arr[middle] && arr[left] <= arr[right]) {
         smallest = arr[middle];
         median = arr[left];
         biggest = arr[right];
      }
      else {
         smallest = arr[left] <= arr[right] ? arr[left] : arr[right];
         median = arr[right];
         biggest = smallest == arr[left] ? arr[right] : arr[left];
      }

      arr[left] = smallest;
      arr[right] = median;
      arr[middle] = biggest;
   }

   private static int splitList(int[] arr, int left, int right) {
      int indexL = left;
      int indexR = right-1;
      int pivot = arr[right];

      while(indexL < indexR) {

         quickSortCounter += 2;

         /*
          * TODO
          * rewrite
          */

         if(arr[indexL] < pivot) {
            indexL += 1;
         }
         if(arr[indexR] > pivot) {
            indexR -= 1;
         }
         if(indexL < indexR) {
            int tmp = arr[indexL];
            arr[indexL] = arr[indexR];
            arr[indexR] = tmp;
            indexL += 1;
            indexR -= 1;
         }
      }

      arr[right] = arr[indexL];
      arr[indexL] = pivot;

      return indexL;
   }

}
