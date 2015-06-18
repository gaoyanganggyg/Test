package com.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T2 {
	public static void main(String[] args) {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
}

class Car{
	@SuppressWarnings("unused")
	private boolean waxOn = false;
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffered() {
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while(waxOn = false){
			wait();
		}
	}
	
	public synchronized void waitForBuffering() throws InterruptedException {
		while(waxOn = true){
			wait();
		}
	}
}

class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c){
		car = c;
	}
	@Override
	public void run() {
		try {
			while(! Thread.interrupted()){
				System.out.println("Wax On");
				TimeUnit.MILLISECONDS.sleep(400);
				car.waxed();
				car.waitForBuffering();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On Task");
	}
}

class WaxOff implements Runnable{
	private Car car;
	public WaxOff(Car c) {
		car = c;
	}
	@Override
	public void run() {
		try {
			while (! Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off");
				TimeUnit.MILLISECONDS.sleep(400);
				car.buffered();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Wax Off Task");
		}
		System.out.println("Ending Wax Off Task");
	}
}


