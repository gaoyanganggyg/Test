package com.designpattern.test.chain_of_responsibility;
/**
 * 职责链模式（Chain of Responsibility）
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这个对象建成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止
 * @author Administrator
 *
 */
public class Resposibility {
	public static void main(String[] args) {
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		Handler handler4 = new ConcreteHandler4();
		
		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler4);

		handler1.handleRequest(new Requst(3));
	}
}

class Requst{
	private int level;
	public Requst(int level) {
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}
}

class Response{
}

abstract class Handler{
	private Handler nextHandler;
	
	final Response handleRequest(Requst  requst){
		if(this.getHandlerLevel() >= requst.getLevel()){
			this.response();
		}else if (this.nextHandler != null) {
			this.nextHandler.handleRequest(requst);
		}else {
			System.out.println("no adapt handler");
		}
		return null;
	}
	
	void setNextHandler(Handler handler){
		this.nextHandler = handler;
	}
	
	abstract int getHandlerLevel();
	abstract void response();
}

class ConcreteHandler1 extends Handler{
	@Override
	int getHandlerLevel() {
		return 1;
	}
	
	@Override
	void response() {
		System.out.println("handler 1");
	}
}

class ConcreteHandler2 extends Handler{
	@Override
	int getHandlerLevel() {
		return 2;
	}
	
	@Override
	void response() {
		System.out.println("handler 2");
	}
}

class ConcreteHandler4 extends Handler{
	@Override
	int getHandlerLevel() {
		return 4;
	}
	
	@Override
	void response() {
		System.out.println("handler 4");
	}
}




