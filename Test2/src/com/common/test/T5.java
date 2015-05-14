package com.common.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class T5 {
	public static void main(String[] args) {
		try (Socket client = new Socket("localhost", 8081);) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("input");
			String msg = scanner.nextLine();
			scanner.close();
			PrintWriter writer  = new PrintWriter(client.getOutputStream());
			writer.println(msg);
			writer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println(reader.readLine());
			reader.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
