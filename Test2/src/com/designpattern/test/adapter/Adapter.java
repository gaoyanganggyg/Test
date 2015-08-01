package com.designpattern.test.adapter;

public class Adapter extends Adaptee implements Target {
	@Override
	public String eat() {
		return super.eat();
	}

	@Override
	public String sing() {
		return "sing ...";
	}
}
