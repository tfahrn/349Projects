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


   }



}
