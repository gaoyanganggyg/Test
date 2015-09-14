package com.designpattern.test.protype;
/**
 * 原型模式
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象
 * @author Administrator
 *
 */
public class ProtoType {
	public static void main(String[] args) {
		ProtoType11 protoType11 = new ProtoType11();
		for(int i = 0; i < 5; i++){
			ProtoType11 protoType112 = (ProtoType11) protoType11.clone();
			protoType112.show();
		}
	}
}

abstract class ProtoType1 implements Cloneable{
	public ProtoType1 clone() {
		ProtoType1 protoType1 = null;
		
		try {
			protoType1 = (ProtoType1)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return protoType1;
	}
}

class ProtoType11 extends ProtoType1{
	void show(){
		System.out.println("Hello");
	}
}


