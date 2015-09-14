package com.concurrent.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * 1、 CopyOnWriteArrayList
 * 		CopyOnWriteArrayList在语义上提供写时复制（copy-on-write）的特性，对这个集合的每次修改都需要对当前数据结构新建副本
 * 		因此写操作花费代价很大。在迭代器创建的时候，会对当前数据结构创建一个快照用于迭代
 * 
 * 2、 CopyOnWriteArraySet
 * 		与CopyOnWriteArrayList相似，也是基于copy-on-write语义实现的list接口
 * 
 * 3、 ConcurrentSkipListSet
 * 		ConcurrentSkipListSet（在javaSE 6 新增）提供的功能类似于TreeSet，能够并发的访问有序的set。因为ConcurrentSkipListSet是基于
 * 		“跳跃列表（skip list）” 实现的，只要线程没有同时修改集合的同一个部分，那么在读，写操作的操作中不会出现竞争现象
 * 		
 * @author Administrator
 *
 */
public class ConcurrentListAndSet {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		list.add(100);
		System.out.println(list.get(0));
		
		//---------------------------------------------------
		
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
		set.add("Hello");
		System.out.println(set.iterator().next());
		
		//-----------------------------------------------------
	}
}
