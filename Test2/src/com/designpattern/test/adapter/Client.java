package com.designpattern.test.adapter;

public class Client {
	public static void main(String[] args) {
		Target t = new Adapter();
		System.out.println(t.eat());
		System.out.println(t.sing());
		t = new Adapter1(new Adaptee() {
		});
		System.out.println(t.eat());
		System.out.println(t.sing());
	}
}
