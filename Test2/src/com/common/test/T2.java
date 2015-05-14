package com.common.test;

import java.io.File;

public class T2 {
	public static void main(String[] args) {
		showFile(new File("E:/3D电影800部"));
	}
	
	private static void showFile(File file){
		if(null == file || ! file.exists()) return;
		if(file.isFile()){
			System.out.println(file.getName());
			return;
		}
		for (File temp : file.listFiles()) {
			showFile(temp);
		}
	}
}
