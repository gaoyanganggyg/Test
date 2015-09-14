package com.designpattern.test.meditor;
/**
 *  中介者模式
 *  用一个中介者来封住一系列的对象交互。中介者使各个对象不需要显式地相互引用，从而使其耦合松散，而且可以独立的改变相互之间的交互
 * @author Administrator
 *
 */
public class Colleague {
	public static void main(String[] args) {
		AbstractColleague A = new Colleague1();
		AbstractColleague B = new Colleague2();
		
		AbstractMediator mediator = new Mediator(A, B);
		
		mediator.setA(200);
		System.out.println("B " + B.getNum());
		System.out.println("A " + A.getNum());
		
		mediator.setB(30);
		System.out.println("B " + B.getNum());
		System.out.println("A " + A.getNum());
	}
}
/**
 * 同事类抽象
 * @author Administrator
 *
 */
abstract class AbstractColleague{
	int num;

	public int getNum() {
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	abstract void setNum(int num, AbstractMediator object);
}

/**
 * 同事类实现
 * @author Administrator
 *
 */
class Colleague1 extends AbstractColleague{
	@Override
	void setNum(int num, AbstractMediator object) {
		this.num = num;
		object.setA(num);
	}
}

class Colleague2 extends AbstractColleague{
	@Override
	void setNum(int num, AbstractMediator object) {
		this.num = num;
		object.setB(num);
	}
}

/**
 * 中介者抽象类
 * @author Administrator
 *
 */
abstract class AbstractMediator{
	 AbstractColleague colleagueA;
	 AbstractColleague colleagueB;
	
	public AbstractMediator(AbstractColleague A, AbstractColleague B){
		this.colleagueA = A;
		this.colleagueB = B;
	}
	
	abstract void setA(int num);
	abstract void setB(int num);
}

/**
 * 中介者实现类
 * @author Administrator
 *
 */
class Mediator extends AbstractMediator{
	public Mediator(AbstractColleague A, AbstractColleague B) {
		super(A, B);
	}
	
	@Override
	void setA(int num) {
		colleagueA.setNum(num / 100);
	}
	
	@Override
	void setB(int num) {
		colleagueB.setNum(num * 100);
	}
}
