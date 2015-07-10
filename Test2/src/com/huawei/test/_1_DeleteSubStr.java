package com.huawei.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除子字符串
 * @author Administrator
 *
 */
public class _1_DeleteSubStr {
	public static int deleteSubStr(String str, String subStr, String result) {
		if(subStr == null || "".equals(subStr.trim())){
			result = str;
			return str.length();
		}
		if(null == str){
			result = null;
			return 0;
		}
		result = str;
		int count = 0;
		int start = 0;
		int end = 0;
		List<Integer> posList = new ArrayList<Integer>();
		for (int i = 0; i <= str.length();) {
			int iTemp = i;
			for(int j = 0; j < subStr.length() && iTemp < str.length(); j++, iTemp++){
				if(str.charAt(iTemp) == subStr.charAt(j)){
					if(j == 0){
						start = iTemp;
						posList.add(start);
					}
					if(j == subStr.length() - 1){
						end = iTemp;
						posList.add(end + 1);
						count++;
					}
				}else {
					i++;
					break;
				}
			}
			if(end >= start){
				i = end + 1;
			}
		}
		if(0 != posList.size()){
			result = null;
			int start1 = 0;
			for(int i = 0; i < posList.size(); i += 2){
				result = str.substring(start1, posList.get(i));
				start = posList.get(i);
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		String str = "123abc12de234fg1hi34j123k";
		String subString = "123";
		String result = "";
		int count = deleteSubStr(str, subString, result);
		System.out.println(count);
		System.out.println(result);
	}
}
