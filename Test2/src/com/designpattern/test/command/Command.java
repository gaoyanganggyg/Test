package com.designpattern.test.command;
/**
 * 命令模式（Command）
 * 将一个请求封装为一个对象，从而使你可以用不同的请求对象进行参数化；对请求排队或记录请求日志，以及支持支持可撤销的操作
 * @author Administrator
 *
 */
public class Command {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		
		Command1 command = new CommandImpl(new Reicver());
		
		invoker.setCommand(command);
		invoker.invoke();
	}
}

class Reicver{
	void doSomething(){
		System.out.println("Hello World");
	}
}

interface Command1{
	void excute();
}

class CommandImpl implements Command1{
	private Reicver reicver;
	
	public CommandImpl(Reicver reicver) {
		this.reicver = reicver;
	}
	
	@Override
	public void excute() {
		reicver.doSomething();
	}
}

class Invoker{
	private Command1 command1;
	
	public void setCommand(Command1 command1){
		this.command1 = command1;
	}
	
	void invoke(){
		command1.excute();
	}
}
