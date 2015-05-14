package com.thinkingjava.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test1 {
	private void t1() {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		List<String> list2 = this.t2(list);
		System.out.println(list2.hashCode());
		for (String string : list2) {
			System.out.println(string);
		}
		System.out.println("---------------------------");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("---------------------------");
		System.out.println("t2 " + list2.size());
		System.out.println("t1 " + list.size());
	}

	private List<String> t2(List<String> list) {
		List<String> l1 = new ArrayList<>();
		l1.add("nice");
		System.out.println(l1.hashCode());
		return l1;
	}
	
	public static void main(String[] args) {
		//new Test1().t1();
		System.out.println(System.getenv("java.ext.dirs"));
		System.out.println(System.getenv("java.class.path"));
	}
}
