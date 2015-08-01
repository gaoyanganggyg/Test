package com.designpattern.test.adapter;

public class Adapter1 implements Target {
	private Adaptee adaptee;
	 public Adapter1(Adaptee adaptee) {
		 this.adaptee = adaptee;
	 }
	@Override
	public String eat() {
		return adaptee.eat();
	}

	@Override
	public String sing() {
		return "sing1 ...";
	}
}
