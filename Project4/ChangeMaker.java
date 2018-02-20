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
      while(n != 0)
         change_DP(n,coins);

      System.out.println("Thanks for playing. Good Bye.");


   }
   public static int[] change_DP(int n, int[] d){


   }
}


