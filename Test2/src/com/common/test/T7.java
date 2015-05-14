package com.common.test;

import java.util.ArrayList;
import java.util.List;

public class T7 {
	public static void main(String[] args) {
		int[] type = {2,8,9, 10, 11};
		for (int i : type) {
			int temp = 1348;
			List<Integer> list = new ArrayList<>();
			while( temp != 0 ){
				list.add(temp % i);
				temp /= i;
			}
			StringBuilder sb = new StringBuilder();
			for(int j = list.size() - 1; j >= 0; j--){
				sb.append(list.get(j)+"");
			}
			System.out.println(sb.toString());
		}
	}
}
