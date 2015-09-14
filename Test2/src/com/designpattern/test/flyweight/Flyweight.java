package com.designpattern.test.flyweight;

import java.util.HashMap;
import java.util.Map;
/**
 * 享源模式（Flyweight）
 * 
 * 运用对象共享技术有效地支持大量细粒度的对象
 * @author Administrator
 *
 */
public class Flyweight {
	public static void main(String[] args) {
		Flyweight1 flyweight1 = FlyweightFactory.getFlyweight("gao");
		flyweight1.action(1);
		
		Flyweight1 flyweight2 = FlyweightFactory.getFlyweight("gao");
		System.out.println(flyweight1 == flyweight2);
	}
}

interface Flyweight1{
	void action(int arg);
}

class FlyweightImpl implements Flyweight1{
	@Override
	public void action(int arg) {
		System.out.println("arg " + arg);
	}
}

class FlyweightFactory{
	
	static Map<String, Flyweight1> map = new HashMap<String, Flyweight1>();
	
	static Flyweight1 getFlyweight(String key){
		if(null == map.get(key)){
			map.put(key, new FlyweightImpl());
		}
		return map.get(key);
	}
}

