package com.designpattern.test.strategy;
/**
 * 策略模式（Strategy）
 * 定义了算法家族，分别封装起来，让它们之间可以相互替换，此模式让算法变化，不会影响使用算法的客户
 * @author Administrator
 *
 */
public class Strategy {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IStrategy strategy1 = new ConcreteStrategy1();
		IStrategy strategy2 = new ConcreteStrategy2();
		
		Context context = new Context(strategy2);
		context.execute();
	}
}

interface IStrategy{
	void doSomethong();
}

class ConcreteStrategy1 implements IStrategy{
	@Override
	public void doSomethong() {
		System.out.println("ConcreteStrategy1");
	}
}

class ConcreteStrategy2 implements IStrategy{
	@Override
	public void doSomethong() {
		System.out.println("ConcreteStrategy2");
	}
}

class Context{
	private IStrategy strategy;
	
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void execute(){
		strategy.doSomethong();
	}
	
}
