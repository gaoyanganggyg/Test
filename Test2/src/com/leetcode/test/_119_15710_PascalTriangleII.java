package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Administrator 杨辉三角
 */
public class _119_15710_PascalTriangleII {
	public static void main(String[] args) {
		List<Integer> list = getRow(2);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	public static List<Integer> getRow(int rowIndex) {
		if (0 > rowIndex)
			return null;
		List<Integer> list = null;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		if (0 == rowIndex)
			return list1;
		list1.add(1);
		if (1 == rowIndex)
			return list1;
		int count = 2;
		while (count != rowIndex + 1) {
			list = new ArrayList<Integer>();
			list.add(1);
			for (int i = 1; i < list1.size(); i++) {
				list.add(list1.get(i - 1) + list1.get(i));
			}
			list.add(1);
			list1 = list;
			count++;
		}
		return list;
	}
}
