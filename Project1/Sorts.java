/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 1/19/2018
 * Project 1
 */

public class Sorts {

   public static void selectionSort(int[] arr, int N) {

      for(int curIndex = 0; curIndex < N; curIndex++) {
         int curMin = arr[curIndex];
         int curMinIndex = curIndex;

         for(int movingIndex = curIndex + 1; movingIndex < N; movingIndex++) {
            if(arr[movingIndex] < curMin) {
               curMin = arr[movingIndex];
               curMinIndex = movingIndex;
            }
         }

         int tmp = arr[curIndex];
         arr[curIndex] = curMin;
         arr[curMinIndex] = tmp;
      }
   }

   public static void mergeSort(int[] arr, int N ) {
      mergeSort(arr, 0, N-1);
   }

   private static void mergeSort(int[] list, int first, int last) {
      if(first < last) {
         int middleIndex = (first+last)/2;
         
         mergeSort(list, first, middleIndex);
         mergeSort(list, middleIndex+1, last);

         mergeSortedHalves(list, first, middleIndex, last);
      }
   }

   private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
      int[] tmp = new int[right-left+1];

      int i = left;
      int j = middle+1;
      int k = 0;

      while(i <= middle && j <= right) {
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

   public static void quickSort(int[] arr, int N) {
      quickSort(arr, 0, N-1);

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
