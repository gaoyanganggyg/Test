package com.sort.test;

import java.util.Arrays;

/**
 * 约瑟夫环：15个基督教徒和15个非教徒在海上遇险，必须将其中一半的人投入海中， 其余的人才能幸免于难，
 * 于是30个人围成一圈，从某一个人开始从1报数，报到9的人就扔进大海， 他后面的人继续从1开始报数，重复上面的规则，直到剩下15个人为止。
 * 结果由于上帝的保佑，15个基督教徒最后都幸免于难， 问原来这些人是怎么排列的，哪些位置是基督教徒，哪些位置是非教徒。
 * 
 * @author Administrator
 */
public class Josepu {
	private  static final int DEAD_NUM = 9;
	public static void main(String[] args) {
		josepu();
	}
	
	private static void josepu(){
		boolean[] person = new boolean[30];
		Arrays.fill(person, true);
		int count = 0;
		int pos = 0;
		int num = 0;
		while(count < 15){
			if(person[pos]){
				if(++num == DEAD_NUM){
					person[pos] = false;
					count ++;
					num = 0;
				}
			}
			if(++pos == person.length)
				pos = 0;
		}
		
		System.out.println(Arrays.toString(person));
		
		for (boolean b : person) {
			System.out.println(b == false ? "非基督徒" : "基督徒");
		}
	}
}
