package com.leetcode.test;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author Administrator
 *
 */
public class _14_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		String basedString = strs[0];
		int maxPrefixPos = 0;
		for(int i = 0; i < basedString.length(); i++){
			for(int j = 1; j < strs.length; j++){
				if(strs[j].length() > i){
					if(strs[j].charAt(i) != basedString.charAt(i)) 
						return basedString.substring(0, maxPrefixPos);
				}else {
					return basedString.substring(0, maxPrefixPos);
				}
			}
			maxPrefixPos++;
		}
		return basedString.substring(0, maxPrefixPos);
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"ac", ""}));
	}
}
