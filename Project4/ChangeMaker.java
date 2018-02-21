/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * ??/??/2018
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
         //change_DP(n,coins);
         printArr(coins,change_greedy(n,coins));
         System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
         n = input.nextInt();

      }


      System.out.println("Thanks for playing. Good Bye.");


   }
   public static int[] change_DP(int n, int[] d){
      return d;


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
   public static void printArr(int[] d, int[] freq){
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


