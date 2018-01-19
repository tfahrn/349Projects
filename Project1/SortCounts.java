/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 1/19/2018
 * Project 1
 */

import java.util.Random;
public class SortCounts{
   public static void main(String args[]){
      int[] listOne = new int[12800];
      int[] listTwo = new int[12800];
      int[] listThree = new int[12800];
      Random rnd = new Random();
      for(int i = 100; i <= 12800 ; i *= 2){

         long selectCount = 0;
         long mergeCount = 0;
         long quickCount = 0;

         for(int k = 0; k < 100; k++) {
            for(int j = 0; j < i; j++) {
               int randNum = rnd.nextInt();
               listOne[j] = randNum;
               listTwo[j] = randNum;
               listThree[j] = randNum;
            }
            selectCount += Sorts1.selectionSort(listOne,i);
            mergeCount += Sorts1.mergeSort(listTwo,i);
            quickCount += Sorts1.quickSort(listThree,i);
         }
         
         System.out.format("N=%d: C_ss=%d, C_ms=%d, C_qs=%d\n",i,(selectCount)/100, (mergeCount)/100, (quickCount)/100);
      }
   }

   /*expected at N = 12800
    * ss = 81913600
    * ms = 158...
    * qs = 202...
    */
}
