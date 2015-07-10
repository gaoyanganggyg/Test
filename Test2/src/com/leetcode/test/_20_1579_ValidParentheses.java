package com.leetcode.test;

import java.util.LinkedList;

public class _20_1579_ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("()[]{{[()]}"));
	}

	public static boolean isValid(String s) {
		if (null == s || "".equals(s.trim()))
			return true;
		LinkedList<Character> list = new LinkedList<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char charI = s.charAt(i);
			if (charI == '(' || charI == '{' || charI == '[') {
				list.offerFirst(charI);
			}else {
				if(list.size() == 0) return false;
				char pusedChar = list.pollFirst();
				switch (charI) {
				case '}':
					if(pusedChar != '{')
						return false;
					break;
				case ')':
					if(pusedChar != '(')
						return false;
					break;
				case ']':
					if(pusedChar != '[')
						return false;
					break;
				}
			}
		}
		if(list.size() != 0) return false;
		return true;
	}
}
