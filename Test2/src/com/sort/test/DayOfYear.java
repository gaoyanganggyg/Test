package com.sort.test;

import java.util.Scanner;

public class DayOfYear {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("input");
		int year = scanner.nextInt();
		int mounth = scanner.nextInt();
		int day = scanner.nextInt();
		dayOfYear(year, mounth, day);
		scanner.close();
	}
	
	private static void dayOfYear(int year, int mounth, int day){
	int[][] dayArr = new int[][]{
			{31,29,31,30,31,30,31,31,30,31,30,31},
			{31,28,31,30,31,30,31,31,30,31,30,31}
		};
	int total = 0;
	int numArr = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 0 : 1;
	for(int i = 0; i < mounth - 1; i++)
		total += dayArr[numArr][i];
	total += day;
	System.out.println(total);
	}
}
