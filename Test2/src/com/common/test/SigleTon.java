package com.common.test;

/**
 * 单例模式
 * 
 * @author Administrator
 *
 */
public class SigleTon {
	private static String name;

	static class Instance {
		public static String getInstance() {
			return name = "gao";
		}
	}

	public String getInstance() {
		return Instance.getInstance();
	}

	public String getInstance1() {
		if (null == name) {
			synchronized (this) {
				if (null == name) {
					name = "li";
				}
			}
		}
		return name;
	}

	public static void main(String[] args) {
		System.out.println(new SigleTon().getInstance());
		System.out.println(new SigleTon().getInstance1());
	}
}
