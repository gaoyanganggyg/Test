package com.generic.test_15828;
/**
 * 泛型数组
 * @author Administrator
 *
 */
public class Generic_Array_Test {

	static Integer a[] = {1,2,3,4};
	
	static <T> T[] getArray(T... args){
		return args;
	}
	
	static <T> void showArray(T args[]){
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	
	public static void main(String[] args) {
		Integer array[] = getArray(a);
		showArray(array);
	}
}
