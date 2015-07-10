package com.common.test;

public class T10 {
	public static void main(String[] args) {
		String str = "i am,a.good!man?";
		String[] strArray = str.split("[ |,|.|!|?]");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
	}
}
