package com.common.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T20 {
	public static void main(String[] args) {
//		String str = "000123";
//		for(String re : str.split("0")){
//			System.out.println(re);
//		}
//		System.out.println(Long.parseLong("000000"));
//		System.out.println("000123".startsWith("0"));
////		
//		Pattern pattern = Pattern.compile("[^0-9]|^0*$");
//		Matcher matcher = pattern.matcher("");
//		boolean isPhoneNum = matcher.find();
//		System.out.println(isPhoneNum);
		
//		System.out.println("-a-b-a".replaceAll("-", ""));
//		DateFormat formate = DateFormat.getDateInstance();
//		java.util.Date date1 =  null;
//		java.util.Date date2 = null;
//		try {
//			date1 = formate.parse("07:59");
//			date2 = formate.parse("21:08");
//			long time = date2.getTime() - date1.getTime();
//			long hours = time / (1000 * 60 * 60 );
//			long minitues = time / (1000 * 60);
//			System.out.println(hours + ":" + minitues);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		DateFormat format = DateFormat.getDateInstance();
//		try {
//			Date date = format.parse("12/31/2005");
//			System.out.println(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Pattern pattern = Pattern.compile("^([0-9]{2}/){2}[0-9]{4}$");
//		System.out.println(pattern.matcher("12/31/2005").find());
//		
//		System.out.println((12 + "").length());
		
//		System.out.println(Integer.toHexString(20000));
		
		System.out.println("ss".substring(0, 0));
		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		Set<String> set = map.keySet();
		
		int[] a = {1,2,3,4};
		for(int i = 1; i < a.length; i++){
			System.out.println(a[i--]);
		}
	}

}
