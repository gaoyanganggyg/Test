package com.socket.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Read_Client_Write extends Thread {
	 volatile boolean flag = true;
	
	@Override
	public void run() {
		if(flag){
			server_Read();
		}else {
			client_Write();
		}
	}
	
	private void server_Read(){
		
		flag = false;
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		Reader reader = null;
		try {
			serverSocket = new ServerSocket(8080);
			socket = serverSocket.accept();
			reader = new InputStreamReader(socket.getInputStream());
			char[] data = new char[100];
			int length = 0;
			while((length = reader.read(data)) != -1){
				reader.read(data, 0, length);
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void client_Write(){
		Socket socket = null;
		Writer writer = null;
		try {
			socket = new Socket("127.0.0.1", 8080);
			writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write("Hello Word");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
