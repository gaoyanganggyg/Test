package com.common.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class T4 {
	private static final int SERVER_PORT = 8081;

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(SERVER_PORT);
			while (true) {
				Socket client = server.accept();
				new Thread(new ClientHandler(client)).start(); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ClientHandler implements Runnable {
	private Socket client;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(
						client.getOutputStream()))) {
			String msgString = reader.readLine();
			writer.print(msgString + client.getInetAddress());
			writer.flush();
			System.out.println(msgString);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}