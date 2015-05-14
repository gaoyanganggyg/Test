package com.mail.test;

public class T416 {
	public static void main(String[] args) {
		System.out.println(reverse("hello"));
	}

	private static String reverse(String str) {
		if (null == str || str.length() <= 1)
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}
}
