package com.sort.test;
public class FullPermutation {
	 
	   public static void perm(int[] list) {
	      perm(list,0);
	   }
	 
	   private static void perm(int[] list, int k) {
	      if (k == list.length) {
	        for (int i = 0; i < list.length; i++) {
	           System.out.print(list[i]);
	        }
	         System.out.println();
	      }else{
	        for (int i = k; i < list.length; i++) {
	           swap(list, k, i);
	           perm(list, k + 1);
	           swap(list, k, i);
	        }
	      }
	   }
	 
	   private static void swap(int[] list, int pos1, int pos2) {
	      int temp = list[pos1];
	      list[pos1] = list[pos2];
	      list[pos2] = temp;
	   }
	 
	   public static void main(String[] args) {
	      int[] x = {1, 2, 3, 4, 5};
	      perm(x);
	   }
	}
	 