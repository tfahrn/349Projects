/*
 * Ivonne Guzman and Thomas Fahrner
 * iguzmanl@calpoly.edu and tfahrner@calpoly.edu
 * 2/16/2018
 * Project 3 
 */

import java.util.*;
import java.io.*;

public class FactoryProblem {

   public static void main(String[] args) throws FileNotFoundException {

      System.out.println("Please provide input file name: ");

      Scanner input = new Scanner(System.in);
      String fileName = input.nextLine();
      File file = new File(fileName);
      Scanner sc = new Scanner(file);

      int n = sc.nextInt();
      int e1 = sc.nextInt();
      int e2 = sc.nextInt();
      int x1 = sc.nextInt();
      int x2 = sc.nextInt();
      int[] a1 = new int[n];
      int[] a2 = new int[n];
      int[] t1 = new int[n-1];
      int[] t2 = new int[n-1];

      for(int i = 0; i < n; i++) {
         a1[i] = sc.nextInt();
      }
      for(int i = 0; i < n; i++) {
         a2[i] = sc.nextInt();
      }
      for(int i = 0; i < n-1; i++) {
         t1[i] = sc.nextInt();
      }
      for(int i = 0; i < n-1; i++) {
         t2[i] = sc.nextInt();
      }

      lineScheduling(n, e1, e2, x1, x2, a1, a2, t1, t2);
   }

   private static void lineScheduling(int n, int e1, int e2, int x1, int x2, int[] a1, int[] a2, int[] t1, int[] t2) {
      int[] f1 = new int[n];
      int[] f2 = new int[n];
      int[] l1 = new int[n-1];
      int[] l2 = new int[n-1];

      for(int i = 0; i < n; i++) {

         if(i == 0) {
            f1[i] = e1+a1[i];
            f2[i] = e2+a2[i];
         }
         else {
            f1[i] = Math.min(f1[i-1]+a1[i], f2[i-1]+t2[i-1]+a1[i]);
            l1[i-1] = (f1[i-1]+a1[i] < f2[i-1]+t2[i-1]+a1[i]) ? 1 : 2;

            f2[i] = Math.min(f2[i-1]+a2[i], f1[i-1]+t1[i-1]+a2[i]);
            l2[i-1] = (f2[i-1]+a2[i] < f1[i-1]+t1[i-1]+a2[i]) ? 2 : 1;
         }
      }

      int minCost = Math.min(f1[n-1]+x1,f2[n-1]+x2);
      int lStar = (f1[n-1]+x1 < f2[n-1]+x2) ? 1 : 2;

      int[] revPath = new int[n];
      revPath[0] = lStar;
      int last = lStar;
      for(int i = 1; i < n; i++) {
         int[] line = (last == 1) ? l1 : l2; 
         revPath[i] = line[line.length-i];
         last = line[line.length-1];
      } 

      System.out.println("Fastest time is: " + minCost + "\n");
      System.out.println("The optimal route is:");
      for(int i = n-1; i >= 0 ; i--) {
         System.out.println("station " + (n-i) + ", line " + revPath[i]);
      }
   }
}
