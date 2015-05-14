package com.gyg.test;

import java.security.Permission;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.regex.Matcher;

public class Test15 {
	
	static ArrayList<Integer> list;

	public void name() {
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)  {
//		List<Integer> list = Arrays.asList(2,1,3);
//		Collections.sort(list);
//		Collections.shuffle(list);
//		Iterator<Integer> iterator = list.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		int[] i = new int[1];
		System.out.println(i);
			
		for (Map.Entry<String, String> j : System.getenv().entrySet()) {
			System.out.println(j.getKey() + "  " + j.getValue());
		}

		try {
			int a = 2 / 0;
			int b = a;
		} catch (Exception e) {
			System.out.println("a");
			e.printStackTrace();
		}
		
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		if(0 == 2){
		    throw new StringIndexOutOfBoundsException(0);
		}

		List<Test15> list = new ArrayList<>();
		list.add(new Test151());
		list.get(0).name();
		
		
		
		System.err.println("error");
		
		
		System.out.println(Long.MAX_VALUE);
		
		//		System.out.println(list.toString());
//		for (Integer integer : list) {
//			System.out.println(integer);
//		}
		
		
		//Collections.sort(list);
		//System.out.println(Math.pow(2, 31.0));
		
		//Collections.shuffle(list);
		//System.out.println(System.nanoTime());
		
		//System.out.println("");
		
	}
	
}
class Test151 extends Test15{
	
}


