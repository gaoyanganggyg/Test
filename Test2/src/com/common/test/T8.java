package com.common.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T8 {
	public static void main(String[] args) {
		//Executors.newCachedThreadPool();
		//Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
}

class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int taskCount  = 0;
	private  final int id = taskCount++;
	
	public String status() {
		return "#" + id + "(" + (countDown > 0  ? countDown : "LiftOff!") + "),";
	}
	
	@Override
	public void run() {
		while(countDown-- > 0){
			System.out.println(status());
			Thread.yield();
		}
	}
}
