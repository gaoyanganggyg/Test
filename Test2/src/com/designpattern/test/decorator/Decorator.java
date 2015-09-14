package com.designpattern.test.decorator;
/**
 * 装饰模式（Decorator）
 * 
 * 动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更灵活
 * @author Administrator
 *
 */
public class Decorator {
	public static void main(String[] args) {
		Person person = new ConcretePerson();
		
		Decorator1 decorator = new DecoratorA();
		
		decorator.setPerson(person);
		decorator.eat();
	}
}

interface Person{
	void eat();
}

class ConcretePerson implements Person{
	@Override
	public void eat() {
		System.out.println("Man eat");
	}
}

abstract class Decorator1 implements Person{
	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void eat() {
		person.eat();
	}
}

class DecoratorA extends Decorator1{
	@Override
	public void eat() {
		super.eat();
		reEat();
	}
	
	void reEat(){
		System.out.println("reEat");
	}
}



