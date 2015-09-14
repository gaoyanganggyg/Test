package com.serilaizable.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 1、序列化时，不序列化transient修饰的，静态的变量
 * 2、 父类实现了Serilizable接口，则子类不用实现Serilizable接口
 * 3、序列化是“深复制”，这就意味着复制的是整个对象，而不仅仅是基本类型及其引用
 * 4、当一个序列化对象有引用另外一个对象时（需实现Serilizable接口）序列化时会序列化引用的对象
 * 
 * 序列化的基本步骤：
 * 
 * （1）、输出序列化的头部信息，包括标示序列化协议的幻数以及协议的版本信息
 * 
 * （2）、按照子类到父类的顺序，递归的输出类的描述信息，直到不再有父类为止；
 * 		类描述信息按照类元数据，类属性信息顺序写入序列化流中
 * 
 * （3）、按照父类到子类的顺序，递归的输出对象域的实际数据；
 * 		而对象的属性信息是按照基本数据类型到Java对象数据类型的顺序写入到序列化流中；
 * 		其中Java对象类型会从步骤（1）重新开始递归的输出，直到不再有Java对象类型的属性
 * 
 * @author Administrator
 *
 */

public class Ser1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int a = 10;
	String b = "Hello";
	transient int c = 100;
	static String d = "gggg";

	T2 t2 = new T2();
	
	public static void main(String[] args) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.out"));
			oos.writeObject(new Ser1());
			oos.flush();
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("t.out"));
			Ser1 ser1 = (Ser1)ois.readObject();
			
			System.out.println(ser1.a);
			System.out.println(ser1.b);
			System.out.println(ser1.t2.a);
			System.out.println(ser1.t2.b);
			
			System.out.println(ser1.d);
			
			
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
