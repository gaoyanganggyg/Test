package com.java.service;

import org.springframework.stereotype.Component;

@Component("hello")
public class Hello {
	public void foo() {
		System.out.println("执行Hello组件中foo（）方法");
	}
	public int addUser(String name, String pass) {
		System.out.println("执行Hello（）组件的addUser（） 添加用户：" + name);
		return 20;
	}
	
}
