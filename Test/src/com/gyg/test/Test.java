package com.gyg.test;

import org.apache.log4j.Logger;

public class Test {
	public void hello() {
		System.out.println("gao");
	}

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		logger.info("gaoyangang");
	}
}
