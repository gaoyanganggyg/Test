package com.offer.test;
/**
 * 数组左到右，上到下，都为递增
 * 找出指定的数
 * @author Administrator
 *
 */
public class FindNum {
	static int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
	public static void main(String[] args) {
		boolean result = Find(array, 0);
		System.out.println(result);
	}
	
	public static  boolean Find(int [][] array,int target) {
        int len = array[0].length;
		int i = 0;
        int j = len - 1;
        while(j > 0 && array[i][j] > target){
            j--;
        }
		while(i < len && array[i][j] < target){
            i++;
        }
       for(int k = i; k < len; k++){
           for(int l = 0; l <= j; l++){
               if(array[k][l] == target) return true;
           }
       }
        return false;
    }
	
}
