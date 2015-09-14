package com.offer.test;

import java.util.LinkedList;
/**
 * 栈的压入，弹出序列
 * @author Administrator
 *
 */
public class IsPopOrder {
	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {4,3,5,1,2};
		boolean possible = is_pop_order(array1, array2, 5);
		System.out.println(possible);
	}
	
	static boolean is_pop_order(int[] array1, int[] array2, int len){
		boolean possible = false;
		if(null != array1 && null != array2 && len != 0){
			LinkedList<Integer> stack = new LinkedList<>();
			int pos1 = 0;
			int pos2 = 0;
			while(pos2 < len){
				while(stack.size() == 0 || stack.peek() != array2[pos2]){
					if(pos1 == len) break;
					stack.push(array1[pos1++]);
				}
				if(stack.peek() != array2[pos2]) break;
				stack.pop();
				pos2++;
			}
			if(stack.isEmpty() && pos2 == len) possible = true;
		}
		return possible;
	}
}
