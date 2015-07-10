package com.leetcode.test;

public class _125_1579_ValidPalindrome {
	public static void main(String[] args) {
		String str = "1a2"; //A man, a plan, a canal: Panama
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome1(str));
	}

	public static boolean isPalindrome(String s) {
		if(null == s || "".equals(s.trim())) return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for(int i = 0, j = s.length() - 1; i < j ;i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}

	//faster
	public static boolean isPalindrome1(String s) {
		if(null == s || "".equals(s.trim())) return true;
		for(int i = 0, j = s.length() - 1; i < j ;){
			char charI = s.charAt(i);
			char charJ = s.charAt(j);
			if(! isChar(charI) && ! isChar(charJ)){
				i++;
				j--;
				continue;
			}else if (! isChar(charI) && isChar(charJ)) {
				i++;
				continue;
			}else if (isChar(charI) && ! isChar(charJ)) {
				j--;
				continue;
			}else {
				if(charI >= 'a') charI = (char) (charI - 32);
				if(charJ >= 'a') charJ = (char) (charJ - 32);
				if(charI != charJ){
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}
	static boolean isChar(char chars){
		if((chars >= 'a' && chars <= 'z') || (chars >= 'A' && chars <= 'Z') || (chars >= '0' && chars <= '9')){
			return true;
		}
		return false;
	}
}
