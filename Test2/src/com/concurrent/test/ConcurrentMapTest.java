package com.concurrent.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 1、java.util.concurrent包中有个继承Map接口的ConcurrentMap的接口，ConcurrentMap提供的方法在一个原子操作中各自提供了一套操作步骤
 * 	   如果将每套步骤放在map之外单独实现，在非原子操作的多线程访问的情况下会导致资源竞争
 * 
 * 2、 ConcurrentMap方法
 *    (1)、putIfAbsent（K key，V value） ：V
 *    	   如果key在map中不存在，则把key-value键值放入map中，否则不执行任何操作。返回值为原来的value，如果不存在map中则返回null
 *    
 *    （2）、remove（Object key， Object value）：boolean
 *        如果map中有相应的key和value，则移除这对数据，否则不执行任何操作
 *    
 *    （3）、replace（K key， V value）： V
 *    		如果map中有这个key，那么用新的value替换原来的value，否则不执行任何操作
 *    
 *    （4）、replace（K key， V oldValue， V newValue）：boolean
 *    		如果map中有key-oldValue数据，那么用newValue替换原来的oldValue，否则不执行任何操作
 *    
 * 3、ConCurrentHashMap
 * 		ConcurrentHashMap提供了两种级别的内部哈希方法。第一种级别是选择一个内部的Segment，第二种是子啊选定的Segment中将数据哈希到buckets中，
 * 		第一种方法通过并行地在不同的Segment上进行读写操作来实现并发

 * @author Administrator
 *
 */
public class ConcurrentMapTest {
	public static void main(String[] args) {
		ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
		map.putIfAbsent(1, "hello");
		
		map.replace(1, "gao");
		
		System.out.println(map.get(1));
		
		map.replace(1, "gao", "yangang");
		
		System.out.println(map.get(1));
		
		map.remove(1);
	}
	
}
