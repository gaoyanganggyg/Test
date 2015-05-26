package com.leetcode.test;

import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating 
 * letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Administrator
 *
 */
public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdbef"));
	}

	 public  static int lengthOfLongestSubstring(String s) {
		 if(null == s) return 0;
		 int[] hashArray = new int[256];
		 Arrays.fill(hashArray, -1);

         int start = 0, ans = 0;
         int i;
         for(i = 0; i < s.length(); i++){
        	 
        	 if( hashArray[s.charAt(i)] < start ){
        		 ans = Math.max(i - start + 1, ans);
        		 hashArray[s.charAt(i)] = i;
        	 }else {
				start = hashArray[s.charAt(i)] + 1;
				ans = Math.max(ans, i - start + 1);
				hashArray[s.charAt(i)] = i;
			}
         }
         return ans;
	 }
}
