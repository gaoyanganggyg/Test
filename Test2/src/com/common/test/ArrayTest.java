package com.common.test;
/**
 * 数组
 * @author Administrator
 *
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] a = new int[2];
		int[][] b = new int[2][];
		System.out.println(a.toString());
		System.out.println(b.toString());
		Object object = a;
		System.out.println(object instanceof int[]);
		System.out.println(object instanceof Integer[]);
		System.out.println(object.toString());
		int[] c = (int[])object;
		System.out.println(c.toString());
	}
}
