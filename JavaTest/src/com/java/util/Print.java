package com.java.util;

import org.apache.log4j.Logger;

public class Print {
	private static final Logger logger = Logger.getLogger(Print.class);
	public static void print(Object info) {
		logger.info("----- " + info + " ------");
	}
}
