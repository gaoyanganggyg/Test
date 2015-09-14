package com.designpattern.test.memento;
/**
 * 备忘录（Memento）
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态
 * @author Administrator
 *
 */
public class Memento {
	public static void main(String[] args) {
		Originator originator = new Originator();
		
		originator.setState("state 1");
		System.out.println(originator.getState());
		
		Cracker cracker = new Cracker();
		cracker.setMemento1(originator.createMemento());
		
		originator.setState("state 2");
		System.out.println(originator.getState());
		
		originator.restoreMemento(cracker.getMemento1());
		System.out.println(originator.getState());
	}
}
/**
 * 负责创建一个备忘录用以记录当前时刻他的内部状态，并可以使用备忘录恢复内部状态
 * @author Administrator
 *
 */
class Originator{
	private String state;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	Memento1 createMemento(){
		return new Memento1(this.state);
	}
	
	void restoreMemento(Memento1 memento1){
		this.state = memento1.getState();
	}
}

/**
 * 负责存储Originator对象的内部状态
 * @author Administrator
 *
 */
class Memento1{
	private String state;
	
	public Memento1(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
/**
 * 负责保存好备忘录
 * @author Administrator
 *
 */
class Cracker{
	private Memento1 memento1;
	
	public Memento1 getMemento1() {
		return memento1;
	}
	
	public void setMemento1(Memento1 memento1) {
		this.memento1 = memento1;
	}
}
