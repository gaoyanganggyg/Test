package com.reflect.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 1、Spring 定义了org.springframework.aop.framework.AopProxy接口，并提供了两种final 类型的实现类
 *    （1）、Cglib2AopProxy
 *    （2）、JdkDynamicAopProxy
 *    
 * 2、Sring选择代理类型的判断
 *   如果使用ProxyFactory的setInterfaces（Class[] interfaces）指定针对接口的代理，ProxyFactory就使用JdkDynamicAopProxy，
 *   如果针对类的代理，则使用Cglib2AopProxy。另外如果使用ProxyFactory的setOptimize（true）方法，则启动了优化代理方法，这样针对接口的代理也会使用Cglib2AopProxy
 *   
 * @author Administrator
 *
 */
public class Cglib_Test {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Person person = Factory.getInstance(proxy);
		person.say();
		person.sing();
	}
}
/**
 * 初始类，被代理的目标对象
 * @author Administrator
 *
 */
class Person{
	void say(){
		System.out.println("person can say");
	}
	
	void sing(){
		System.out.println("person can sing");
	}
}

/**
 * 此处为代理类，用于pointcut处添加advise
 * @author Administrator
 *
 */
class CglibProxy implements MethodInterceptor{
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("before invoke...");
		
		arg3.invokeSuper(arg0, arg2);
		
		System.out.println("after invoke...");
		return null;
	}
}
/**
 * 工厂类，生成增强过的目标类
 * @author Administrator                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
 *
 */
class Factory{
	public static Person getInstance(CglibProxy proxy) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Person.class);
		enhancer.setCallback(proxy);  //回调方法的参数为代理类对象，最后增强目标类调用的是代理对象中的intercept方法
		Person person = (Person)enhancer.create(); //person 不是单纯的目标类，是增强过的目标类
		return person;
	}
}
