package com.common.test;

import java.util.ArrayList;
import java.util.List;

public class SameObjectTest {
	public static void main(String[] args) {
		List<Test> list = new ArrayList<>();
		Test t1 = new Test("hello");
		Test t2 = new Test("hello");
		Test t3 = new Test("hello");
		Object t4 = new Test("hello");
		list.add(t1);
		System.out.println(list.contains(t2));
		System.out.println(t2.equals(t3));
		System.out.println(t3.equals(t4));
	}
}

class Test{
	String val;
	public Test(String val) {
		this.val = val;
	}
	
	public boolean equals(Test obj) {
		if(obj == this) return true;
		if(obj instanceof Test){
			return obj.val.equals(this.val);
		}
		return false;
	}
}