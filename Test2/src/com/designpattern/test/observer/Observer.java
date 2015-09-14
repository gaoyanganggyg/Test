package com.designpattern.test.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * 观察者模式
 * 定义对象之间一种一对多的依赖关系，使得当每一个对象改变状态时，则所有的它的对象都会的到通知并自动更新
 * @author Administrator
 *
 */
public class Observer {
	public static void main(String[] args) {
		Observer1 observer1Impl = new Observer1Impl();
		Observer1 observer2Impl = new Observer2Impl();
		
		Subject subject = new SubjectImpl();
		subject.attach(observer1Impl);
		subject.attach(observer2Impl);

		subject.doSomething();
	}
}

abstract class Subject{
	List<Observer1> list = new ArrayList<>();
	
	void attach(Observer1 observer1){
		list.add(observer1);
	}
	
	void detach(Observer1 observer1){
		list.remove(observer1);
	}
	
	void notifys(){
		for (Observer1 observer1 : list) {
			observer1.update();
		}
	}
	
	abstract void doSomething();
}
//被观察者
class SubjectImpl extends Subject{
	@Override
	void doSomething() {
		System.out.println("Something Happen");
		this.notifys();
	}
}

interface Observer1{
	void update();
}
//观察者1
class Observer1Impl implements Observer1{
	@Override
	public void update() {
		System.out.println("Oberver1Impl");
	}
}
//观察者2
class Observer2Impl implements Observer1{
	@Override
	public void update() {
		System.out.println("Observer2Impl");
	}
}



