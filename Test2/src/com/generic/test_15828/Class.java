package com.generic.test_15828;
/**
 * 1、继承泛型接口的类必须指定泛型的类型
 * 
 * 2、java泛型无法向上类型转换
 * 
 * 3、Java中的泛型基本上是在编译器这个层次来实现的。在生成的Java字节码中是不包括泛型类型信息的。使用泛型是加上的类型参数会在编译器编译的时候去掉。这个过程称为类型擦除
 * 		如在List<Object>和List<String>等类型，在编译后会变成List。JVM只看到List
 * 
 * 4、类型擦除的基本过程：首先找到用来替换类型参数的具体类。这个类一般是Object，如果指定了类型参数上界的话，则使用这个参数的上界
 * 
 * @author Administrator
 *
 */
public class Class implements Interface<String>{
	public void say(String t) {
		System.out.println(t.isEmpty());
	};
}
