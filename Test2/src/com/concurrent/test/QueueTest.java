package com.concurrent.test;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
/**
 * 1、java.util.concurrent包中的BlockingQueue接口是Queue的子接口
 * 
 * 2、 Blocking Queue 中 put， take 一直阻塞
 * 					   offer pool 超时阻塞
 * 
 * 3、JDK 中queue的实现
 *   （1）、PriorityQueue
 *   		PriorityQueue是唯一一个非线程安全的队列实现的类，用于单线程存放数据并将数据排序
 *   
 *   （2）、CurrentLinkedQueue
 *   		一个无界的、基于链接列表的、唯一一个线程安全的队列实现类，不支持BlockingQueue
 *   
 *   （3）、ArrayBlockingqueue
 *   		一个无界的、基于数组的阻塞队列
 *   
 *   （4）、LinkedBlockingQueue
 *   		一个有界的、基于链表的阻塞队列。
 *   
 *   （5）、PriorityBlockingQueue
 *   		一个无界的、基于堆的阻塞队列。队列根据设置的Comparator（比较器）来确定组件读取、移除的顺序（不是默认的FIFO顺序）
 *   
 *   （6）、DelayQueue
 *        一个无界的，延迟元素（每个延迟元素都会有相应的延迟时间值）的阻塞队列实现。只有在延时期过了之后，元素才被移除，而且最先被移除的是延时最先到期的元素
 *        
 *    （7）、SychronousQueue
 *    		一种0容量的队列实现，生产者添加元素之后必须等待消费者移除之后才可以返回，反之亦然。如果生产者，消费者两个线程同时访问，那么参数之间从生产者传递到消费者。
 *    		经常用于线程间传递数据
 *   		
 * @author Administrator
 *
 */
public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityBlockingQueue<>();
		queue.add(10);
		System.out.println(queue.peek());
	}
}
