package com.socket.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Server_Read_Client_Write socketClient_Write = new Server_Read_Client_Write();
		
		//socketClient_Write.start();
		//socketClient_Write.start();
		
		service.submit(socketClient_Write);
		service.submit(socketClient_Write);
	}
}
