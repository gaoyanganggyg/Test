package com.designpattern.test.visitor;
/**
 * 访问者模式（Visitor）
 * 表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作
 * @author Administrator
 *
 */
public class Visitor {
	public static void main(String[] args) {
		IElement e1 = new Element1();
		IElement e2 = new Element2();
		e1.accept(new Visitor1());
		
		e2.accept(new Visitor1());
	}
}

interface IVisitor{
	void visit(Element1 e1);
	void visit(Element2 e2);
}

class Visitor1 implements IVisitor{
	@Override
	public void visit(Element1 e1) {
		e1.doSonething();
	}
	
	@Override
	public void visit(Element2 e2) {
		e2.doSonething();
	}
}

interface IElement{
	void accept(IVisitor visitor);
	void doSonething();
}

class Element1 implements IElement{
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	@Override
	public void doSonething() {
		System.out.println("Element1");
	}
}

class Element2 implements IElement{
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	@Override
	public void doSonething() {
		System.out.println("Element2");
	}
}