package com.reflect.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 1、动态代理，利用Java的反射技术（Java Reflection），在运行时创建一个实现某些给定接口的新类（也称“动态代理类”）及其实例
 * 
 *   动态代理其实就是java.lang.reflect.Proxy类动态的根据指定的接口生成一个class byte，该class会继承Proxy类，并实现所指定的接口；
 *   然后在利用指定的classloader将class byte 加载到系统，最后生成一个Class对象，并初始化该对象的一些值，如InvocationHandler，
 *   以及所有的接口对应的Method成员。初始化之后将对象返回给调用客户端。这样客户端拿到的就是一个实现了所有的接口的Proxy对象
 * 
 * 2、代理的是接口（Interfaces），不是类（Class），更不是抽象类
 * 
 * 3、Proxy.newProxyInstance()方法有三个参数
 * 		（1）、类加载器（Class Loader）
 * 		（2）、需要实现接口的数组
 *      （3）、InvocationHandler接口。所有动态代理类的方法调用，都会交由InvocationHandler接口实现invoke（）方法处理。
 * 
 * 4、invoke（）方法有三个参数
 *    （1）、动态代理类的引用，通常情况下不需要他。但可以使用getClass（）方法，得到proxy的Class类从而获取实例的类信息。
 *    （2）、方法对象的引用，代表被动态代理的方法。从中可以得到方法名，参数类型，返回类型
 *    （3）、args对象数组，代表被调用方法的参数。注意基本类型（int，long）会被装箱成为对象类型（Integer， Long）
 * 
 * 5、Proxy.newInstance（ClassLoader loader， Class<?>[] interfaces, InvocationHandler h）做了以下几件事
 *    （1）、根据loader和interfaces调用方法getProxyClass（loader，interfaces）创建代理类$Proxy0
 *    		$Proxy0类实现了interfaces的接口，并继承了Proxy类
 *    
 *    （2）、实例化$Proxy0并在构造方法中把BussinessHandler传过去，接着$Proxy0调用父类Proxy的构造器，为h赋值
 * 	  
 * 6、invoke()方法中的proxy参数不能用于调用proxy对象所实现接口的某些方法（会造成死循环，最后栈溢出）
 * 
 * @author Administrator
 *
 */
public class JDKProxy_Test {
	 Dog dog;
	 
	JDKProxy_Test(Dog dog){
		this.dog = dog;
	}
	
	Animal create(){
		return (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				System.out.println("before invoke");
				System.out.println(proxy.getClass().getCanonicalName());
				Animal animal = (Animal)method.invoke(dog, args);
				System.out.println("after invoke");
				
				return animal;
			}
		});
	}
	
	public static void main(String[] args) {
		JDKProxy_Test reflect_Test = new JDKProxy_Test(new Dog()); 
		reflect_Test.create().say("wangwang");
		reflect_Test.create().sing();
	
	}
}

interface Animal{
	void say(String str);
	void sing();
}

class Dog implements Animal{
	@Override
	public void say(String str) {
		System.out.println("Dog can " + str);
	}
	
	@Override
	public void sing() {
		System.out.println("Sing");
	}
}
