import java.util.Random;
public class SortTimes{

   public static void main(String args[]){
      int[] listOne = new int[160000];
      int[] listTwo = new int[160000];
      int[] listThree = new int[160000];
      Random rnd = new Random();
      for(int i = 5000; i <= 160000 ; i *= 2){
         for(int k = 0; k < 5; k++){
               for(int j = 0; j < i; j++){
               int randNum = rnd.nextInt();
               listOne[j] = randNum;
               listTwo[j] = randNum;
               listThree[j] = randNum;
            }
            long start = System.nanoTime();

            Sorts.selectionSort(listOne,i);
            long selectTime = System.nanoTime();
            Sorts.mergeSort(listTwo,i);
            long mergeTime = System.nanoTime();

            Sorts.quickSort(listThree,i);
            long endTime = System.nanoTime();


            System.out.format("N=%d: T_ss=%d, T_ms=%d, T_qs=%d\n",i,(selectTime - start)/1000000,
                 ( mergeTime - selectTime)/1000000, (endTime - mergeTime)/1000000);
         }

      }

   }
}
