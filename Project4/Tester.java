/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 3/2/2018
 * Project 4
 */

public class Tester{

   public static void main(String args[]){
      int[] US = {100, 50, 25, 10, 5, 1 };
      int[] soviet = {100, 50, 20, 15, 10, 5, 3, 2, 1};
      int[] pow = {64, 32, 16, 8, 4, 2, 1};
      int[] noNickel = {100, 50, 25, 10, 1};
      int[] someSet = {66, 35, 27, 18, 10, 1};
      int USMatches, sovietMatches, powMatches, noNickelMatches, someSetMatches;
      USMatches = sovietMatches = powMatches = noNickelMatches = someSetMatches = 0;

      for(int i = 1; i <= 200; i++){
         USMatches += cointCounter(ChangeMaker.change_DP(i,US), ChangeMaker.change_greedy(i,US)) ? 1 : 0;
         sovietMatches += cointCounter(ChangeMaker.change_DP(i,soviet), ChangeMaker.change_greedy(i,soviet)) ? 1 : 0;
         powMatches += cointCounter(ChangeMaker.change_DP(i,pow), ChangeMaker.change_greedy(i,pow)) ? 1 : 0;
         noNickelMatches += cointCounter(ChangeMaker.change_DP(i,noNickel), ChangeMaker.change_greedy(i,noNickel)) ? 1 : 0;
         someSetMatches += cointCounter(ChangeMaker.change_DP(i,someSet), ChangeMaker.change_greedy(i,someSet)) ? 1 : 0;
      }

      System.out.println("Testing change_DP and change_greedy algorithms");
      System.out.println("Testing set1: " + USMatches + " matches in 200 tests"); 
      System.out.println("Testing set2: " + sovietMatches + " matches in 200 tests"); 
      System.out.println("Testing set3: " + powMatches + " matches in 200 tests"); 
      System.out.println("Testing set4: " + noNickelMatches + " matches in 200 tests"); 
      System.out.println("Testing set5: " + someSetMatches + " matches in 200 tests"); 
   }

   private static boolean cointCounter(int[] freqA, int[] freqB){
      int countA, countB;
      countA = countB = 0;
      for(int i = 0; i < freqA.length; i++){
         countA += freqA[i];
         countB += freqB[i];
      }
      
      return countA == countB;
   }
}
