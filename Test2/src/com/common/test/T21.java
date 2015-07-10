package com.common.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class T21 {
	
	public static void main(String...args) throws Exception {
		String path="D:\\MyEclipse_work\\SQ\\count";
		int pathLength = path.length();
		
		File rootPath = new File(path);
		if(!rootPath.exists()) {
			throw new Exception("path"+rootPath+"not exists exception");
		}
		
		Stack<File> stack= new Stack<File>();
		stack.push(rootPath);
		int linect = 0;
		
		while(!stack.isEmpty()) {
			File f = stack.pop();
			if(f.isDirectory()) {
				File[] fs = f.listFiles();
				for(File f0:fs) {
					stack.push(f0);
				}
			} else {
				int l = countLines(f);
				if(l>0) {
					System.out.printf("%-6d%s\n",l,f.getAbsolutePath().substring(pathLength));
					linect+= l;
				}
				
			}
		}
		System.out.println("total: "+linect);
		
	}
	
	public static int countLines(File f) {
		BufferedReader br=null;
		try {
			 br= new BufferedReader(new FileReader(f));
			int lines = 0;
			while((br.readLine())!=null) {
				lines++;
			}
			return lines;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}

