package com.offer.test;
/**
 * 字符串的排列
 * @author Administrator
 *
 */
public class Permutation {
	public static void main(String[] args) {
		permutation("abc".toCharArray());
	}
	
	static void permutation(char[] str){
		permutation(str, 0);
	}
	
	static void permutation(char[] str, int pos){
		if(pos == str.length)
			System.out.println(str);
		else {
			for(int i = pos; i < str.length; i++){
				char temp = str[i];
				str[i] = str[pos];
				str[pos] = temp;
				
				permutation(str, pos + 1);
				
				temp = str[i];
				str[i] = str[pos];
				str[pos] = temp;
			}
		}
	}
	
}
