package com.common.test;
/**
 * 1、对于+，-，*,/,只有基本类型，所以，当遇到这些操作时执行拆箱操作
 * 
 * 2、如果对于等值比较==或！=运算符，除非左右两边全部是包装类型,否则，转换成基本类型。
 *    包装类型比较的是地址，值比较时用equils，包装类型的equils方法均已被重写
 * 
 * @author Administrator
 *
 */
public class ChaiXiang {
	public static void main(String[] args) {
		Integer a = 10;
		int b = 20;
		System.out.println(a == b);
	}
}
