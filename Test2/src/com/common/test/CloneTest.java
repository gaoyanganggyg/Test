package com.common.test;
/**
 * 对象克隆
 * @author Administrator
 *
 */
public class CloneTest {
	static class Person implements Cloneable{
		String name;
		int  age;
		public Person(String name, int age){
			this.age = age;
			this.name = name;
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("gao", 12);
		Person p2 = (Person)p1.clone();
		
		System.out.println(p1 == p2);
		
		System.out.println(p1.name == p2.name);
		
		System.out.println(p1.age == p2.age);
	}
}
