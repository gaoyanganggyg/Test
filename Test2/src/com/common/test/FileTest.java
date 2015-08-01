package com.common.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
	static long count  = 0;
	public static void main(String[] args) {
//		getFileName(new File("F:\\Upan\\陕勤"));
//		System.out.println("---------------------");
//		System.out.println(count);
		
		getFileName1(new File("F:\\Upan\\陕勤"));
		
//		File file = new File("F:\\Upan\\陕勤\\新建文件夹");
//		System.out.println(file.isDirectory());
//		for(File temp : file.listFiles()){
//			System.out.println(temp.getName());
//		}
//		System.out.println( file.listFiles().length);
	}
	
	static void getFileName(File file){
		System.out.println(file.getName());
		if(file.isDirectory() && 0 == file.listFiles().length){
			return;
		}
		if(file.isFile()){
			count++;
			return;
		}
		for(File temp : file.listFiles()){
			getFileName(temp);
		}
	}
	
	static void getFileName1(File file){
		List<File> list1 = new ArrayList<File>();
		list1.add(file);
		while(list1.size() != 0){
			List<File> list2 = new ArrayList<>();
			for(int i = 0; i < list1.size(); i++){
				File temp = list1.get(i);
				if(temp.isDirectory()){
					File[] fileArray = temp.listFiles();
					for(int j = 0; j < fileArray.length ; j++){
						System.out.println(fileArray[j].getName());
						list2.add(fileArray[j]);
					}
				}
			}
			System.out.println("+++++++++++++++++++++++++++");
			list1 = list2;
		}
	}
}
