package com.concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1、Executor和易扩展的ExecutorService接口规定了用于执行任务组件的标准。
 * 
 * 2、最通用的Executor接口只能只能访问这种类型的可执行（Runnable）任务：
 * 	  void execute（Runnable command）
 * 
 * 3、Executor子接口ExecutorSerivce新增加了方法，能够执行：Runnable任务，Callable任务以及任务集合
 * 	  Future<?> submit(Runnable task)
 *    Future<T> submit(Callable<T> task)
 *    Future<T> submit(Runnable task, T result)
 *    List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) 
 *    List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
 *    T invokeAny(Collection<? extends Callable<T>> tasks)
 *    T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
 *    
 * 4、 Callable类似于Runnable，而且能够返回值     
 *    
 * 5、 ExecutorService最主要的实现类是ThreadPoolExecutor。这个类实现提供了大量的可配置特性：
 * 	  （1）、线程池： 设定常用线程数量（启动前可选参数）和最大可用数量
 *   （2）、线程工厂： 通过自定义的线程工厂生成线程，例如生成自定义线程名的线程
 *   （3）、工作队列： 指定队列的实现类，实现类必须是阻塞的、可以是无界的或者是有界的
 *   （4）、被拒绝的任务： 当队列以满或者执行者不可用，需要为这些情况指定解决策略
 *   （5）、生命周期中的钩子：重写扩展在任务之前或者生命周期之后的关键点
 *   （6）、关闭-停止已接受的任务，等待正在运行的任务完成后，关闭ThreadPoolExecutor
 *   ScheduledThreadPoolExecutor是ThreadPoolExecutor的一个子类
 * 
 * 6、Executor类有很多静态方法用于创建各种常见情况的预先包装的ExecutorService和ScheuleExectorSerivce实例
 * 	  （1）newSingleThreadExecutor
 *       创建只有一个线程的ExecutorService
 *   （2）、newFixedThreadPool
 *       返回拥有固定数量线程的ExecutorService
 *   （3）、newCachedThreadPool
 *        返回一个数量可变的ExecutorService
 *   （4）、newSingleThreadSceduledExecutor
 *       返回只有一个线程的ScheduledExecutorService
 *   （5）、newScheduledThreadPool
 *       创建拥有一组核心线程的ScheduledExecutorService    
 *
 * 
 * @author Administrator
 *
 */
public class ExecutorService_Test {
	static int processors = Runtime.getRuntime().availableProcessors();
	static ExecutorService service;
	
	
	public static void main(String[] args) {
		service = Executors.newFixedThreadPool(processors);
		Future<Integer> value = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 100;
			}
		});

		try {
			System.out.println(value.get()); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
