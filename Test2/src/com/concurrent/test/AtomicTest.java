package com.concurrent.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1、java.utils.concurrent.atomic包中有一系列支持在单个非锁定（Lock）的变量上进行原子操作的类
 * 
 * 2、 booleans, integers, longs, object, references, integers数组， longs数组，object references数组 都有相应的原子类
 *  
 * @author Administrator
 *
 */
public class AtomicTest {
	public static void main(String[] args) {
		AtomicInteger value = new AtomicInteger();
		System.out.println(value.addAndGet(100));
	}
	
}
