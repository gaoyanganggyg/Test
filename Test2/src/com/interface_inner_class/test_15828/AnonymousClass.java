package com.interface_inner_class.test_15828;

/**
 * 1、静态成员类
 * 	  (1)、静态成员类的表现和外部类相同
 * 	   （2）、静态成员类可以访问其外围类的静态部分（包括静态成员类和静态成员方法）
 * 
 * 2、内部类
 * 	  (1)、内部类通常指内部成员类，必须通过外围类的对象才能创建对象
 * 	   （2）、内部类不能含有静态代码（包括静态成员，静态成员方法，静态成员类和嵌套接口）或静态初始化块（值为编译时常量的final静态成员除外）
 *    （3）、内部类可以自由访问外围类和其他内部类，静态成员类
 *   （4）、内部类包含一个外围类的引用，内部类的构造函数第一个参数隐式传入外围类的对象
 *   
 * 3、类继承内部类时，构造函数要传递内部类的外围类对象并通过该对象显示调用内部类的构造函数
 * 
 * 4、本地内部类（本地类）
 * 	  (1)、本地类时声明在实例初始化块、静态初始化块、构造器、方法、静态方法中的类
 * 	  （2）、本地类类似于局部变量，无访问修饰符和static修饰符
 *   （3）、访问约束：本地类不能访问非final的局部变量或方法（构造器）参数。但是，本地类可以通过外围类的成员共享信息
 *    （4）、使用场景：经常用本地类来实现接口，创建对象，再返回对象
 *    
 * 5、匿名内部类
 * 	 （1）、匿名类语法如下：new Interface(){}或者new ClassName(){}
 *   （2）、匿名类的局限性：只能隐式继承或实现，最多只能实现一个接口，无构造器
 *   （3）、匿名类的使用场景与本地类类似，更实用于只使用一次且逻辑简单的情形
 *   
 * 6、嵌套接口
 * 	（1）、嵌套接口是声明在类或接口内部的接口，其永远是静态的（因为接口永远是静态的）
 *  （2）、嵌套接口如果是声明在接口内部，则其也是public的（因为接口成员永远是public的）
 *  （3）、实现外围接口时不需要实现嵌套接口（一般也不实现，接口表达的是一种引用类型）
 * 
 * @author Administrator
 *
 */
public class AnonymousClass {
	static int a = 10;
	String b = "gao";
	
	static interface  MyInterface{
		void say();
	}
	
	static class A{
		int a = 20;
		static int basic = 10;
		void fun1(){
			System.out.println("fun1 executed");
			System.out.println(a);
		}
	}
	
	class B{
		void fun2(){
			System.out.println("fun2 executed");
			System.out.println(a);
			System.out.println(b);
			A as = new A();
			System.out.println(as.a);
			System.out.println(A.basic);
		}
	}
	
	public static void main(String[] args) {
		AnonymousClass anonymousClass = new AnonymousClass();
		B b = anonymousClass.new B();
		b.fun2();
		
		MyInterface interface1 = new MyInterface() {
			@Override
			public void say() {
				System.out.println("Hello");
			}
		};
		interface1.say();
	}
 }
