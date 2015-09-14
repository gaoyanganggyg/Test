package com.offer.test;
/**
 * 调整数组位置使奇数位于偶数前面
 * @author Administrator
 *
 */
public class SwapOodEven {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		swap(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	static void swap(int[] array){
		int low = 0;
		int high = array.length - 1;
		while(low < high){
			while(low < high && (array[low] & 0x1) == 1) low++;
			while(low < high && (array[high] & 0x1) == 0) high--;
			if(low < high){
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
			
		}
	}
	
}
