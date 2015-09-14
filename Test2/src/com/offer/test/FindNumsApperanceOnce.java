package com.offer.test;
/**
 * 数组中只出现一次的数字（两个出现一次的数字）
 * @author Administrator
 *
 */
public class FindNumsApperanceOnce {
	static int num1;
	static int num2;
	public static void main(String... args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		find(array);
		System.out.println(num1);
		System.out.println(num2);
	}

	static void find(int[] array) {
		if (null == array || 0 == array.length)
			return;
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			result ^= array[i];
		}
		int index = findFirstBitOf1(result);
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1 ^= array[i];
			} else {
				num2 ^= array[i];
			}
		}
	}

	static int findFirstBitOf1(int result) {
		int index = 0;
		while ((result & 1) != 1 && index < 32) {
			result >>= 1;
			index++;
		}
		return index;
	}

	static boolean isBit1(int num, int index) {
		num >>= index;
		return (num & 1) == 1;
	}

}
