package com.java.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.java.util.Print;
@Aspect
public class AopTest {
	@Before("execution(* com.java.service.Hello.foo())")
	public void authority(){
		Print.print("模拟执行权限检查");
	}
	
	@AfterReturning(returning="obj", pointcut="execution(* com.java.service.Hello.addUser(..))")
	public void log(int obj){
		Print.print("获取目标方法的返回值： " + obj);
		Print.print("模拟日志功能、、、");
	}
	@After("execution(* com.java.service.Hello.*(..)) || execution(* com.java.service.World.*(..))")
	public void log1(){
		Print.print("After ");
	}
	
	@Pointcut("execution(* com.java.service.Hello.addUser(..))")
	private void pointCut(){}
}
