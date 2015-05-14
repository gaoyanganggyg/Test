package com.common.test;

public class T6 {
	public static void main(String[] args) {
		Runnable run = () -> System.out.println("Hello");
		run.run();
	}
}
