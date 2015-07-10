package com.common.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 
 * @author Administrator
 *
 */
public class PascalTriangle {
	public static void main(String[] args) {
		int num = 13;
		List<List<Integer>> showList = new ArrayList<>();
			List<Integer> listOne = new ArrayList<>();
			listOne.add(1);
			showList.add(listOne);
			List<Integer> list1 = new ArrayList<Integer>();
			list1.add(1);
			list1.add(1);
			showList.add(list1);
			for(int i = 3; i <= num; i++){
				List<Integer> list2 = new ArrayList<Integer>();
				list2.add(1);
				for(int j = 0; j < list1.size() - 1; j++){
					int result = list1.get(j) + list1.get(j + 1);
					list2.add(result);
				}
				list2.add(1);
				showList.add(list2);
				list1 = list2;
			}
			int maxLen = showList.get(showList.size() - 1).size();
			for(List<Integer> list : showList){
				print(--maxLen, list);
			}
			
	}
	static void print(int tab, List<Integer> list){
		for(int i = 0; i < tab; i++){
			System.out.print("  ");
		}
		for(int i = 0; i < list.size(); i++){
			if(i != 0){
				System.out.print(" ");
			}
			System.out.print(list.get(i) + "  ");
		}
		System.out.println("");
	}
}
