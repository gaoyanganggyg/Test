package com.sort.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * 单词计数
 * @author Administrator
 *
 */
public class Counter {
	public static void main(String[] args) {
		count(new File("D:\\MyEclipse_work\\SQ\\log\\log_user.txt"));
	}

	private static void count(File file) {
		if(! file.exists())
			return;
		FileReader reader = null;
		int count = 0;
		int chars = 0;
		boolean state = false;
		try {
			reader = new FileReader(file);
			while((chars = reader.read()) != -1){
				if(chars == ' '  || chars == '\n' || chars == '\t' || chars == '\r')
					state = false;
				else if (! state) {
					state = true;
					count ++;
				}
			}
			System.out.println(count);
		} catch ( IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
