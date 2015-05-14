package com.sort.test;

public class MaxSum {
	public static void main(String[] args) {
		 int[] x1 = { 1, -2, 3, 5,-3, 2 };  
	      int[] x2 = { 0, -2, 3, 5,-1, 2 };  
	      int[] x3 = { -9, -2, -3,-5, -3 };  
	      System.out.println(maxSum(x1));   // 8  
	      System.out.println(maxSum(x2));   // 9  
	      System.out.println(maxSum(x3));   //-2  
	}
	
	private static int maxSum(int[] list){
		int[] all = new int[list.length];
		int[] start = new int[list.length];
		int endPos = list.length - 1; 
		start[endPos] = all[endPos] = list[endPos];
		for(int i = endPos - 1; i >= 0; i--){
			start[i] = Math.max(list[i], list[i] + start[i + 1]);
			all[i] = Math.max(start[i], all[i + 1]);
		}
		return all[0];
	}

}
