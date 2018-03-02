/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 3/2/2018
 * Project 4
 */

import java.util.*;
import java.io.*;

public class ChangeMaker {

   public static void main(String[] args){

      System.out.println("Enter the number of coin-denominations and the set of coin values: ");
      Scanner input = new Scanner(System.in);
      int k = input.nextInt();
      int coins[] = new int[k];
      for(int i = 0; i < k; i++){
         coins[i] = input.nextInt();
      }

      System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
      int n = input.nextInt();

      while(n != 0){
         System.out.println("DP algorithm results");
         printArr(n,coins,change_DP(n,coins));
         System.out.println("Greedy algorithm results");
         printArr(n,coins,change_greedy(n,coins));
         System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
         n = input.nextInt();
      }

      System.out.println("Thanks for playing. Good Bye.");
   }

   public static int[] change_DP(int n, int[] d) {
      int[] c = new int[n+1]; //number of coins chosen at all targets from 0 to n
      int[] a = new int[n+1]; //coin (index of d) chosen for target (a index == c index)
      int[] chosenCoins = new int[d.length]; //coins (indices of d) chosen for target at n

      c[0] = 0;
      a[0] = -1;

      for(int target = 1; target <= n; target++) {
         int minNumCoins = Integer.MAX_VALUE;
         int chosenCoinIndex = -1;

         for(int coinIndex = 0; coinIndex < d.length; coinIndex++) {
            if(target - d[coinIndex] >= 0 && (1 + c[target - d[coinIndex]] < minNumCoins)) {
               minNumCoins = 1 + c[target - d[coinIndex]];
               chosenCoinIndex = coinIndex;
            }
         }

         c[target] = minNumCoins;
         a[target] = chosenCoinIndex;
      }

      while(n > 0) {
         int chosenCoinIndex = a[n];
         chosenCoins[chosenCoinIndex] += 1;
         n -= d[chosenCoinIndex];
      }

      return chosenCoins;
   }

   public static int[] change_greedy(int n, int[] d){
      int arr[] = new int[d.length];
      int i = 0;
      while(n > 0 && i < arr.length){
         if(d[i] <= n){
            arr[i]++;
            n -= d[i];
         }
         else
            i++;
      }

      return arr;
   }

   public static void printArr(int n,int[] d, int[] freq){
      System.out.println("Amount: " + n);
      System.out.println("Optimal distribution: ");
      int count = 0;
      for(int i = 0; i < d.length-1; i++){
         System.out.print(freq[i] + "*" + d[i] + "c+ ");
         if(freq[i] > 0)
            count += freq[i];

      }

      System.out.print(freq[d.length-1] + "*" + d[d.length-1] + "c\n");
      if(freq[d.length-1] > 0)
         count += freq[d.length-1];
      System.out.println("Optimal coin count: " + count);
   }
}
