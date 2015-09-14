package com.offer.test;

public class ReverseString {
	public static void main(String[] args) {
		String str = "gao";
		str = reverse(str);
		System.out.println(str);
	}
	
	static String reverseSquence(String str){
		if(null == str) return null;
		str = reverse(str);
		int start = 0, end = 0;
		while(end != str.length()){
			if(str.charAt(end) == ' '){
				str = reverse(str.substring(start, end));
			}
		}
		
		return null;
	}
	
	

	static String reverse(String str) {
		char[] array = str.toCharArray();
		int len = str.length();
		for (int i = 0; i <= len / 2; i++) {
			char temp = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = temp;
		}
		return new String(array);
	}
}
