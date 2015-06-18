package com.leetcode.test;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author Administrator
 *
 */
public class _5_LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(new _5_LongestPalindromicSubstring().longestPalindrome("cabccba"));
	}

	public String longestPalindrome(String s) {
        int len = s.length(), max = 1, ss = 0, tt = 0;
        boolean flag[][] = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (i >= j)
                    flag[i][j] = true;
                else flag[i][j] = false;
        for (int j = 1; j < len; j++)
            for (int i = 0; i < j; i++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    flag[i][j] = flag[i+1][j-1];
                    if (flag[i][j] == true && j - i + 1 > max)
                    {
                        max = j - i + 1;
                        ss = i;
                        tt = j;
                    }
                }
                else flag[i][j] = false;
            }
        return s.substring(ss, max);
    }
}
