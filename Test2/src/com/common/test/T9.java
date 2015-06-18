package com.common.test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T9 {
	public static void main(String[] args) {
		ExecutorService exc = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			result.add(exc.submit(new TaskWithResult(i)));
		}
		for (int i = 0; i < result.size(); i++) {
			try {
				System.out.println(result.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}finally{
				exc.shutdown();
			}
		}
	}
}


class TaskWithResult implements Callable<String>{
	private int id;
	 public TaskWithResult(int id) {
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}
}
