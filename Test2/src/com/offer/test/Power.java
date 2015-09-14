package com.offer.test;
/**
 * 数值的整数次方
 * @author Administrator
 *
 */
public class Power {
	public static void main(String[] args) {
		double result = power(2.3, 5);
		System.out.println(result);
	}
	
	static double power(double base, int exponent){
		
		long start = System.currentTimeMillis();
		
		if(base - 0.0 > -0.000001 && base - 0.0 < 0.000001) return .0;
		int absExponent = exponent < 0 ? -exponent : exponent;
		double result = 1;
		for(int i = 1; i <= absExponent; i++){
			result = base * result;
		}
		if(exponent < 0) result = 1.0 / result;
		
		System.out.println(System.currentTimeMillis() - start);
		
		return result;
	}

	//递归实现
	static double power1(double base, int exponent){
		
		long start = System.currentTimeMillis();
		
		if(base - 0.0 > -0.000001 && base - 0.0 < 0.000001) return .0;
		int absExponent = exponent < 0 ? -exponent : exponent;
		double result = recursive(base, absExponent);
		if(exponent < 0) result = 1.0 / result;
		
		System.out.println(System.currentTimeMillis() - start);
		
		return result;
	}
	
	static double recursive(double base, int exponent){
		if(exponent == 0) return 1;
		if(exponent == 1) return base;
		
		double result = recursive(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1) result *= base;
		return result;
	}
	
}
