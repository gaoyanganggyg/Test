package com.designpattern.test.bridge;
/**
 * 桥接模式（Bridge）
 * 
 * 将抽象部分与它的实现部分分离，使他们都可以独立的变化
 * @author Administrator
 *
 */
public class Brige {
	public static void main(String[] args) {
		Person person1 = new ConretePerson1();
		Person person2 = new ConcretePerson2();
		
		Clothing clothing1 = new Jacket();
		Clothing clothing2 = new Trouser();
		
		person1.setClothing(clothing1);
		person1.dress();
		
		person2.setClothing(clothing2);
		person2.dress();
	}
}

abstract class Person{
	private Clothing clothing;
	
	private String type;
	
	public Clothing getClothing() {
		return clothing;
	}
	
	public void setClothing(Clothing clothing) {
		this.clothing = clothing;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	abstract void dress();
}

class ConretePerson1 extends Person{
	
	public ConretePerson1() {
		setType("ConretePerson1 ");
	}
	
	@Override
	void dress() {
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}
}

class ConcretePerson2 extends Person{
	
	public ConcretePerson2() {
		setType("ConcretePerson2");
	}
	
	@Override
	void dress() {
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}
}


interface Clothing{
	void personDressCloth(Person person);
}

class Jacket implements Clothing{
	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType() + " A");
	}
}

class Trouser implements Clothing{
	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType() + " B");
	}
}


