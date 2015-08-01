package com.java.service;

import org.springframework.stereotype.Component;

@Component("word")
public class World {
	public void bar() {
		System.out.println("执行Worl组件中bar（）方法");
	}
}
