package com.concurrent.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1、Deque继承Queue，BlockingDeque继承自BlockingQueue
 * 
 * 2、 Deque的实现类
 * 	  （1）、LinkedList
 * 			在LinkedList中，可以使用标准的Deque方法来添加或者删除list两端元素。LinkedList还可以被当做非同步的堆栈，用来代替同步的Stack类
 * 		
 * 	  （2）、ArrayDeque
 * 		  一个非同步的、支持无线队列长度（根据需要动态扩展队列的长度）的Deque实现类
 * 
 * 	  （3）、LinkedBlockingDeque
 * 		  LinkedBlockingDeque是Deque实现中唯一支持并发的、基于链表列表、队列长度可选的类
 * 
 * @author Administrator
 *
 */
public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(10);
		deque.add(100);
		
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		
	}
}
